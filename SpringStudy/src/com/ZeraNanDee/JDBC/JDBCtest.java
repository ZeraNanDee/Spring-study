package com.ZeraNanDee.JDBC;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;;

public class JDBCtest {

	private ApplicationContext contest = null;
	private JdbcTemplate template;
	private NamedParameterJdbcTemplate jdbcTemplate;
	{
		contest = new ClassPathXmlApplicationContext("SpringJDBC.xml");
		template = (JdbcTemplate) contest.getBean("jdbc");// 实例化JdbcTemplate
		jdbcTemplate=(NamedParameterJdbcTemplate) contest.getBean("namedParameterjdbc");
	}
	
	
	/*
	 * 这个NamedParameterJdbctemplate.update(sql, paramSource)的好处是
	 * 1.和类的属性名一致，方便维护，更方便观察
	 * 2.使用SqlParameterSource的BeanPropertySqlParameterSource(user)作为实现类实现
	 */
	@Test
	public void namedParameterJdbc() {
		String sql="insert into user(name,password,email) values(:name,:password,:email)";
		User user=new User();
		user.setName("huangweige");
		user.setPassword("huang11");
		user.setEmail("193@qq.com");
		SqlParameterSource paramSource=new BeanPropertySqlParameterSource(user);
		jdbcTemplate.update(sql, paramSource);
	}
	

	@Test
	public void testDataSource() throws SQLException {// 测试类
		DataSource source = (DataSource) contest.getBean("dataSource");
		System.out.println(source.getConnection());
	}

	/*
	 * 执行jdbc的insert，update，delete，select
	 */
	@Test
	public void testUpdate() {
		String sql = "delete from user where id>10 ";
		template.update(sql);// 执行spring的jdbctemplate模板，第一参数是更新的sql语句，第二个是sql内容值
	}

	@Test
	public void batchUpdate() {// 执行批量插入,更改，删除 记录
		String sql = "insert into user (name,password,email) values(?,?,?)";
		List<Object[]> batchArgs = new ArrayList<>();// 指定list的泛型数组，在不知道类型的情况下，用Object[]数组存数据
		batchArgs.add(new Object[] { "xy", "jchs11", "1kwen@qq.com" });
		batchArgs.add(new Object[] { "xyx", "jch1s11", "kwen@qq.com" });
		batchArgs.add(new Object[] { "xyz", "jxchs11", "tkwen@qq.com" });
		batchArgs.add(new Object[] { "xyv", "jcchs11", "1kggwen@qq.com" });
		batchArgs.add(new Object[] { "xyn", "jcbhs11", "1kweccn@qq.com" });
		template.batchUpdate(sql, batchArgs);
	}
	
 

	@Test // 从数据库获取一条记录，实际得到对应的对象,jdbctemplate是个JDBC小工具，不是ORM
	public void testSelect() {// 注意返回的是queryForObject(sql, rowMapper)这个方法，where里面的？是此方法第三个参数
		String sql = "select id,name,password,email from user where id=?";
		RowMapper<User> rowmapper = new BeanPropertyRowMapper<>(User.class);// RowMapper指定如何去映射结果集的行
		User user = template.queryForObject(sql, rowmapper, 1);// 常用的实现类的为BeanPropertyRowMapper<>()
		System.out.println(user);
	}
	
	@Test
	public void Count()
	{
		String sql = "select count(*) from user";
		int count=template.queryForObject(sql, Integer.class);//查看有多少个记录在user里面
		System.out.println(count);
	}
	

}
