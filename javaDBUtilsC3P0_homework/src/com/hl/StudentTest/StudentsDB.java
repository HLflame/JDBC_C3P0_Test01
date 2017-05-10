package com.hl.StudentTest;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.hl.modle.*;
import com.hl.JDBCC3P0Utils.JDBCC3P0Utils;

public class StudentsDB {
	@Test
	//(1)使用DBUtils+C3P0完成该表的记录的删除/修改/添加操作
	//插入
	public void test01() throws SQLException{
		QueryRunner querRunner=new QueryRunner(JDBCC3P0Utils.getDataSource());
		querRunner.update("insert into student values(?,?,?,?,?,?)",12,"asd",44,"黑马五期",30000,67.6);
	}
	//修改
	@Test
	public void test02() throws SQLException{
		QueryRunner queryRunner=new QueryRunner(JDBCC3P0Utils.getDataSource());
		queryRunner.update("update student set sname=?,classname=? where sid=?","ccc","黑马火箭班",12);
	}
	//删除
	@Test
	public void test03() throws SQLException{
		QueryRunner queryRunner=new QueryRunner(JDBCC3P0Utils.getDataSource());
		queryRunner.update("delete from student where sid=?",12);
	}
	//(2)使用DBUtils+C3P0查询年龄在30岁以下的同学，并将结果集封装在一个List集合里面
	@Test
	public void test04() throws Exception{
		QueryRunner queryRunner=new QueryRunner(JDBCC3P0Utils.getDataSource());
		List<Student> list = queryRunner.query("select * from student where age<?", new BeanListHandler<Student>(Student.class), 30);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	//(3)使用DBUtils+C3P0查询sid等于3的同学，并将结果集封装在一个自定义的JavaBean中
	@Test
	public void test05() throws SQLException{
		QueryRunner queryRunner=new QueryRunner(JDBCC3P0Utils.getDataSource());
		Student student=queryRunner.query("select * from student where sid=?", new BeanHandler<Student>(Student.class), 3);
		System.out.println(student);
	}
	//(4)使用DBUtils+C3P0查询毕业薪资最高的学生信息，并封装在一个Map集合中
	@Test
	public void test06() throws SQLException{
		QueryRunner queryRunner=new QueryRunner(JDBCC3P0Utils.getDataSource());
		Map<String, Object> map = queryRunner.query("select * from student where salary=(select max(salary) from student)",new MapHandler());
		System.out.println(map);
	}
	//(5)使用DBUtils+C3P0查询姓名在（张飞 关羽 刘备）中的学生，并将结果集封装在一个List<Map>集合中
	@Test
	public void test07() throws SQLException{
		QueryRunner queryRunner=new QueryRunner(JDBCC3P0Utils.getDataSource());
		List<Map<String,Object>> list=queryRunner.query("select * from student where sname in (?,?,?)", new MapListHandler(), "张飞","关羽","刘备");
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	//(6)使用DBUtils+C3P0查询薪资在10000以上的学生个数，并使用ScalarHandler进行封装
	@Test
	public void test08() throws SQLException{
		QueryRunner queryRunner=new QueryRunner(JDBCC3P0Utils.getDataSource());
		Object number =  queryRunner.query("select count(1) from student where salary>?", new ScalarHandler(), 10000);
		System.out.println(number);
	}
}
