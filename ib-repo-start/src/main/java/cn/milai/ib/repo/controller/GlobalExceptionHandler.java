package cn.milai.ib.repo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.milai.ib.repo.entity.Response;
import cn.milai.ib.repo.entity.ResponseCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理器 2020.01.26
 * @author milai
 */
@Slf4j
@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionHandler {

	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Response<Void> handleParamInvalid(BindException e, HttpServletRequest request) {
		FieldError fieldError = e.getBindingResult().getFieldError();
		String desc = fieldError.getDefaultMessage() + ":" + fieldError.getField() + "=" + fieldError
			.getRejectedValue();
		log.info(request.getRequestURI() + " " + desc);
		return Response.fail(ResponseCode.PARAM_INVALID, desc);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Response<Void> handleUncaughtException(Exception e) {
		log.error("未知异常", e);
		return Response.fail(ResponseCode.UNKNOWN_ERROR);
	}

}
