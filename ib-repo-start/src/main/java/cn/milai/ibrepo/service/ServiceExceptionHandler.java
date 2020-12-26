package cn.milai.ibrepo.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.milai.common.api.Resp;
import cn.milai.ibrepo.IBRepoResp;
import cn.milai.ibrepo.ex.IBRepoException;
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

	@Pointcut("execution(public * cn.milai.ibrepo.service.*.*(..))")
	public void serviceMethods() {
	}

	@Around("serviceMethods()")
	public Object handleUnhandledException(ProceedingJoinPoint point) {
		try {
			return point.proceed();
		} catch (IBRepoException e) {
			log.info(point.toShortString() + " " + e.getDesc(), e);
			return Resp.fail(e.getCode(), e.getDesc());
		} catch (Throwable e) {
			log.info("未知异常", e);
			return Resp.fail(IBRepoResp.UNKNOWN_ERROR);
		}
	}

}
