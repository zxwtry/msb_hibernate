package slw03map;

import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Map<String,String> map;
	public Student() {}
	
	public Student(String name, Map<String, String> map) {
		super();
		this.name = name;
		this.map = map;
	}

	public Student(int id, String name, Map<String, String> map) {
		super();
		this.id = id;
		this.name = name;
		this.map = map;
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
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
}
