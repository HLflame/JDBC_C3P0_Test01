package com.hl.modle;

public class Student {
	private int sid;
	private String sname;
	private int age;
	private String classname;
	private double salary;
	private double grade;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sid, String sname, int age, String classname,
			double salary, double grade) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.classname = classname;
		this.salary = salary;
		this.grade = grade;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", age=" + age
				+ ", classname=" + classname + ", salary=" + salary
				+ ", grade=" + grade + "]";
	}
	
}
