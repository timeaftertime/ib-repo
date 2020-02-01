package cn.milai.ib.repo.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.milai.ib.repo.ex.IBRepoException;
import cn.milai.ib.repo.model.Response;
import cn.milai.ib.repo.model.ResponseCode;
import lombok.extern.slf4j.Slf4j;

/**
 * Service 异常全局处理
 * @author milai
 * @date 2020.01.31
 */
@Slf4j
@Aspect
@Component
public class ServiceExceptionHandler {

	@Pointcut("execution(public * cn.milai.ib.repo.service.*.*(..))")
	public void serviceMethods() {
	}

	@Around("serviceMethods()")
	public Object handleUnhandledException(ProceedingJoinPoint point) {
		try {
			return point.proceed();
		} catch (IBRepoException e) {
			log.info(point.toShortString() + " " + e.getDesc(), e);
			return Response.fail(ResponseCode.of(e.getCode()), e.getDesc());
		} catch (Throwable e) {
			log.info("未知异常", e);
			return Response.fail(ResponseCode.UNKNOWN_ERROR);
		}
	}

}
