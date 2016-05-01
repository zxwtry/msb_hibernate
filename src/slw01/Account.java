package slw01;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zxwtry
 * date: 2016/04/28
 * 实体类
 */
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;		//OID
	private String name;
	private int age;
	private double score;
	private Date birthday;
	public Account() {
	}
	public Account(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + ", birthday=" + birthday
				+ "]";
	}
}
