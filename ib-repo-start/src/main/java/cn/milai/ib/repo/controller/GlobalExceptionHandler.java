package cn.milai.ib.repo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.milai.ib.repo.entity.Response;
import cn.milai.ib.repo.entity.ResponseCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理器
 * 2020.01.26
 * @author milai
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Response<?> handleUncaughtException(Exception e) {
		log.error("未知异常", e);
		return Response.fail(ResponseCode.UNKNOWN_ERROR);
	}

}
