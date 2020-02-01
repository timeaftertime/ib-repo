package cn.milai.ib.repo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.milai.ib.repo.ex.ParamInvalidException;
import cn.milai.ib.repo.model.Response;
import cn.milai.ib.repo.model.ResponseCode;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller 全局异常处理
 * @date 2020.01.26
 * @author milai
 */
@Slf4j
@ControllerAdvice(annotations = Controller.class)
public class ControllerExceptionHandler {

	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Response<Void> handleParamInvalid(BindException e, HttpServletRequest request) {
		FieldError fieldError = e.getBindingResult().getFieldError();
		String desc = fieldError.getDefaultMessage() + ":" + fieldError.getField() + "=" + fieldError
			.getRejectedValue();
		log.info(request.getRequestURI() + " " + desc);
		return Response.fail(ResponseCode.PARAM_INVALID, desc);
	}

	@ExceptionHandler(ParamInvalidException.class)
	@ResponseBody
	public Response<Void> handleParamInvalid(ParamInvalidException e, HttpServletRequest request) {
		log.info(request.getRequestURI() + " " + e.getDesc());
		return Response.fail(ResponseCode.PARAM_INVALID, e.getDesc());
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Response<Void> handleUncaughtException(Exception e) {
		log.error("未知异常", e);
		return Response.fail(ResponseCode.UNKNOWN_ERROR);
	}

}
