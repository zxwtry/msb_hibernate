package slw03m2o;

import java.io.Serializable;

/*
 * 	单向的多对一
 * 	少的一端
 */
public class Dept implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String deptName;
	public Dept () {}
	public Dept(int id, String deptName) {
		super();
		this.id = id;
		this.deptName = deptName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
