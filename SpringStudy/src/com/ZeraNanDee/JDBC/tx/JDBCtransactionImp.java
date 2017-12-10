package com.ZeraNanDee.JDBC.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jDBCtransaction")
public class JDBCtransactionImp implements JDBCtransaction {

	@Autowired
	private JDBCtest jdbc;
	//添加事务注解
	@Transactional
	@Override
	public void buy(String name, int money) {
		//购买的条件，如果购买money大于price购买成功,同时book的价格更新为money，否则事务提交不了
		//更新book价格
		try {
			jdbc.updateprice(name,money);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
