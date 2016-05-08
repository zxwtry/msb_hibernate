package slw03m2o;

import java.io.Serializable;
import java.util.Date;

/*
 * 	单向的多对一
 * 	多的一端
 */

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String empName;
	private Date hireDate;
	private Dept dept;
	public Employee () {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
