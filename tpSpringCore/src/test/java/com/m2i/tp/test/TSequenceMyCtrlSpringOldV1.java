package com.m2i.tp.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m2i.tp.essai.MyCtrlSpring;

public class TSequenceMyCtrlSpringOldV1 {
	private static ClassPathXmlApplicationContext springContext;
	private MyCtrlSpring myCtrlSpring; //à tester
	
	@BeforeClass
	public static void initClass() {
		springContext =	new ClassPathXmlApplicationContext("/mySpringConf.xml");
	}
	@Before
	public void init() {
		myCtrlSpring= springContext.getBean(MyCtrlSpring.class);
	}
	@AfterClass
	public static void fin() {
		springContext.close();
	}
	
	@Test
	public void testSequence() {
		Assert.assertNotNull(myCtrlSpring);		myCtrlSpring.sequence();
	}
}
