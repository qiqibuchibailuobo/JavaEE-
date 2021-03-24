package edu.hhtc.jsj.aspect.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import edu.hhtc.jsj.dao.MyAdvice;
@Aspect
@Component("myXMLAspect")
public class MyXMLAspect {
	@Pointcut("execution(* edu.hhtc.jsj.dao.CustomerDaoImpl.*(..))")
	private void myPointCut() {
		
	}
		
	  // 前置通知
	@Before("myPointCut()")
		public void myBefore(JoinPoint joinPoint) {
			//权限检查
			MyAdvice.check_Permissions();
			System.out.print("目标类是："+joinPoint.getTarget() );
			System.out.println(",被织入增强处理的目标方法为："
	                            +joinPoint.getSignature().getName());
		}
	
		// 后置通知
	@AfterReturning("myPointCut()")
		public void myAfterReturning(JoinPoint joinPoint) {
			//记录日志
			MyAdvice.log();
			System.out.println("被织入增强处理的目标方法为："
	                          + joinPoint.getSignature().getName());
		}
		/**
		 * 环绕通知
		 * ProceedingJoinPoint 是JoinPoint子接口，表示可以执行目标方法
		 * 1.必须是Object类型的返回值
		 * 2.必须接收一个参数，类型为ProceedingJoinPoint
		 * 3.必须throws Throwable
		 */
	@Around("myPointCut()")
		public Object myAround(ProceedingJoinPoint proceedingJoinPoint) 
	             throws Throwable {
			//权限检查
			MyAdvice.check_Permissions();
			// 执行当前目标方法
			Object obj = proceedingJoinPoint.proceed();
			//记录日志
			MyAdvice.log();
			return obj;
		}
		// 异常通知
	@AfterThrowing(value="myPointCut()",throwing="e")
		public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
			//记录日志
			MyAdvice.log();
			System.out.println("异常通知：" + "出错了" + e.getMessage());
		}
		// 最终通知
	@After("myPointCut()")
		public void myAfter() {
			System.out.println("最终通知：模拟方法结束后的释放资源...");
		}

}
