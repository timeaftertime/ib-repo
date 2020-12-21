package cn.milai.ib.repo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.milai.common.api.Resp;
import cn.milai.ib.repo.IBRepoResp;
import cn.milai.ib.repo.ex.ParamInvalidException;
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
	public Resp<Void> handleParamInvalid(BindException e, HttpServletRequest request) {
		FieldError fieldError = e.getBindingResult().getFieldError();
		String desc = fieldError.getDefaultMessage() + ":" + fieldError.getField() + "=" + fieldError
			.getRejectedValue();
		log.info(request.getRequestURI() + " " + desc);
		return Resp.fail(IBRepoResp.PARAM_INVALID, desc);
	}

	@ExceptionHandler(ParamInvalidException.class)
	@ResponseBody
	public Resp<Void> handleParamInvalid(ParamInvalidException e, HttpServletRequest request) {
		log.info(request.getRequestURI() + " " + e.getDesc());
		return Resp.fail(IBRepoResp.PARAM_INVALID, e.getDesc());
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Resp<Void> handleUncaughtException(Exception e) {
		log.error("未知异常", e);
		return Resp.fail(IBRepoResp.UNKNOWN_ERROR);
	}

}
