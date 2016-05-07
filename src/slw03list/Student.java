package slw03list;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<String> hobby;
	public Student() {
	}
	public Student(int id, String name, List<String> hobby) {
		this.id = id;
		this.name = name;
		this.hobby = hobby;
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
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
}
