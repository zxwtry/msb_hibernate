package slw03;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
	public Student(int id, String name, int age, Set<String> hobby) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private Set<String> hobby;
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
	public Set<String> getHobby() {
		return hobby;
	}
	public void setHobby(Set<String> hobby) {
		this.hobby = hobby;
	}
	public Student() {
	}
	public Student(int id, String name, Set<String> hobby) {
		this.id = id;
		this.name = name;
		this.hobby = hobby;
	}
}
