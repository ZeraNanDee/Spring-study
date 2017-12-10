package com.ZeraNanDee.JDBC.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBC {
	
	private ApplicationContext contest = null;	
	private JDBCtransaction jdbct;
	{
		contest=new ClassPathXmlApplicationContext("SpringJDBC.xml");
		jdbct=contest.getBean(JDBCtransaction.class);
	}

	@Test
	public void testBuy() {
		jdbct.buy("the Superman", 20);
	}
	
}
