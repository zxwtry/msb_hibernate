package slw03bag;

import java.io.Serializable;
import java.util.Collection;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private String name = null;
	private Collection<String> hobby = null;
	public Student() {}
	public Student(int id, String name, Collection<String> hobby) {
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
	public Collection<String> getHobby() {
		return hobby;
	}
	public void setHobby(Collection<String> hobby) {
		this.hobby = hobby;
	}
}