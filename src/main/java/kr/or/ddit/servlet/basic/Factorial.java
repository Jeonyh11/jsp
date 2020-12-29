package kr.or.ddit.servlet.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Factorial {
	
	private static final Logger logger = LoggerFactory.getLogger(Factorial.class);
	
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		
		int result = factorial.calculate(5);

		if(result == 120) {
			logger.debug("success");
		} else {
			logger.debug("fall");
		}
		
		result = factorial.calculate(0);

		if(result == 1) {
			logger.debug("success");
		} else {
			logger.debug("fall");
		}
		
		result = factorial.calculate(3);

		if(result == 6) {
			logger.debug("success");
		} else {
			logger.debug("fall");
		}
	}
	
	/**
	 * 
	* Method : calculate
	* 작성자 : Sub-02
	* 변경이력 :
	* @param fac
	* Method 설명 : 인자로 들어온 n 값을 이용하여 팩토리얼을 계산
	 */
	public int calculate(int n) {
		
		int fac = 1;
		for (int i = 1; i <= n; i++) {
			fac = fac * i;
		}
		
		return fac;
	}
}
