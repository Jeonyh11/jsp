package kr.or.ddit.etc;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import kr.or.ddit.util.FileUtil;

public class FileuploadTest {

	@Test
	public void fileUploadTest() {
		/***Given***/
		
		
		/***When***/

		/***Then***/
	}
	@Test
	public void getFileNameFailTest() {
		/***Given***/
		
		
		/***When***/

		/***Then***/
	}
	
	@Test
	public void getFIleExtensionTest() {
		/***Given***/
		String filename ="brown.png";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		
		
		/***Then***/
		assertEquals(".png", extension);
	}
	
	@Test
	public void getFIleExtensionTes2t() {
		/***Given***/
		String filename ="line.brown.png";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		
		
		/***Then***/
		assertEquals(".png", extension);
	}
	
	@Test
	public void getFIleExtensionTest3() {
		/***Given***/
		String filename ="brown";

		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		
		
		/***Then***/
		assertEquals("", extension);
	}
	
	@Test
	public void test() {
		System.out.println(UUID.randomUUID().toString());
	}
	
	@Test
	public void regisUserTest() {
		
	}
	

}
