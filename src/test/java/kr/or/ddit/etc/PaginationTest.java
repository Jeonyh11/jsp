package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaginationTest {

	@Test
	public void paginationtest() {
		
		/***Given***/
		int userTotCnt = 32;
		int pageSize = 5;

		/***When***/
		int pagination = (int) Math.ceil((double)userTotCnt/pageSize);

		/***Then***/
		assertEquals(7, pagination);
	}

}
