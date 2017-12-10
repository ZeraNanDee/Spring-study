package com.ZeraNanDee.JDBC.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("jDBCtest")
public class JDBCtest {
	
	@Autowired
	private JdbcTemplate template;
	

	public void updateprice(String name, int money) throws Exception {
		String sql2="select price from book where name=? ";
		int price=template.queryForObject(sql2, Integer.class,name);
		if (price<money) {
			throw new Exception("price价格小于money，事务提交失败");
		}else {
			System.out.println("price价格大于money，事务提交成功，book价格被改变!");
			String sql="update book set price=? where name=?";
			template.update(sql,money,name);
		}
	}
}
