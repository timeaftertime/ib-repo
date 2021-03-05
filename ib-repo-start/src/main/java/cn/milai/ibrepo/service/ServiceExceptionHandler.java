package cn.milai.ibrepo.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.milai.common.decoupling.Resp;
import cn.milai.ibrepo.IBRepoResp;
import cn.milai.ibrepo.ex.IBRepoException;

/**
 * Service 异常全局处理
 * @author milai
 * @date 2020.01.31
 */
@Aspect
@Component
public class ServiceExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceExceptionHandler.class);

	@Pointcut("execution(public * cn.milai.ibrepo.service.*.*(..))")
	public void serviceMethods() {}

	@Around("serviceMethods()")
	public Object handleUnhandledException(ProceedingJoinPoint point) {
		try {
			return point.proceed();
		} catch (IBRepoException e) {
			LOG.info(point.toShortString() + " " + e.getDesc(), e);
			return Resp.fail(e.getCode(), e.getDesc());
		} catch (Throwable e) {
			LOG.info("未知异常", e);
			return Resp.fail(IBRepoResp.UNKNOWN_ERROR);
		}
	}

}
