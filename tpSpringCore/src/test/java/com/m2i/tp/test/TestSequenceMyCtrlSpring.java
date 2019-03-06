package com.m2i.tp.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.tp.essai.MyCtrlSpring;
//il faut spring-test dans pom.xml
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/mySpringConf.xml"})
public class TestSequenceMyCtrlSpring {

	@Autowired
	private MyCtrlSpring myCtrlSpring; //à tester
	
	@Test
	public void testSequence() {
		Assert.assertNotNull(myCtrlSpring);		myCtrlSpring.sequence();
	}
}
