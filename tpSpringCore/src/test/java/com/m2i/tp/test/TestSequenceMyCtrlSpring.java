package com.m2i.tp.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m2i.tp.essai.MyCtrlSpring;

public class TestSequenceMyCtrlSpring {
	private ClassPathXmlApplicationContext springContext;
	private MyCtrlSpring myCtrlSpring; //à tester
	
	@Before //ou @BeforeClass
	public void init() {
		this.springContext =
				new ClassPathXmlApplicationContext("/mySpringConf.xml");
		myCtrlSpring= springContext.getBean(MyCtrlSpring.class);
	}
	@After
	public void fin() {
		springContext.close();
	}
	
	@Test
	public void testSequence() {
		Assert.assertNotNull(myCtrlSpring);
		myCtrlSpring.sequence();
	}

}
