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
		
	  // ǰ��֪ͨ
	@Before("myPointCut()")
		public void myBefore(JoinPoint joinPoint) {
			//Ȩ�޼��
			MyAdvice.check_Permissions();
			System.out.print("Ŀ�����ǣ�"+joinPoint.getTarget() );
			System.out.println(",��֯����ǿ�����Ŀ�귽��Ϊ��"
	                            +joinPoint.getSignature().getName());
		}
	
		// ����֪ͨ
	@AfterReturning("myPointCut()")
		public void myAfterReturning(JoinPoint joinPoint) {
			//��¼��־
			MyAdvice.log();
			System.out.println("��֯����ǿ�����Ŀ�귽��Ϊ��"
	                          + joinPoint.getSignature().getName());
		}
		/**
		 * ����֪ͨ
		 * ProceedingJoinPoint ��JoinPoint�ӽӿڣ���ʾ����ִ��Ŀ�귽��
		 * 1.������Object���͵ķ���ֵ
		 * 2.�������һ������������ΪProceedingJoinPoint
		 * 3.����throws Throwable
		 */
	@Around("myPointCut()")
		public Object myAround(ProceedingJoinPoint proceedingJoinPoint) 
	             throws Throwable {
			//Ȩ�޼��
			MyAdvice.check_Permissions();
			// ִ�е�ǰĿ�귽��
			Object obj = proceedingJoinPoint.proceed();
			//��¼��־
			MyAdvice.log();
			return obj;
		}
		// �쳣֪ͨ
	@AfterThrowing(value="myPointCut()",throwing="e")
		public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
			//��¼��־
			MyAdvice.log();
			System.out.println("�쳣֪ͨ��" + "������" + e.getMessage());
		}
		// ����֪ͨ
	@After("myPointCut()")
		public void myAfter() {
			System.out.println("����֪ͨ��ģ�ⷽ����������ͷ���Դ...");
		}

}
