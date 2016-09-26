package cn.zjc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author zjc
 * @version 2016/9/26 23:20
 * @description
 */
@Component
@Aspect
public class WebLogAspect {

	private ThreadLocal<Long> startTime = new ThreadLocal<>();

	private Logger log = LoggerFactory.getLogger(WebLogAspect.class);

	//定义日志切点
	@Pointcut(value = "execution(public * cn.zjc.web..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		//接收到请求并记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		log.info("URL: " + request.getRequestURL().toString());
		log.info("HTTP METHOD: " + request.getMethod());
		log.info("IP: " + request.getRemoteAddr());
		log.info("CLASS METHOD: " + joinPoint.getSignature());
		log.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
		startTime.set(System.currentTimeMillis());
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		log.info("RESPONSE: " + ret);
		log.info("SPEND TIME: " + (System.currentTimeMillis() - startTime.get()));
	}
}
