package slw03cascade;

import java.util.Set;

public class Category {
	private int id;
	private String name;
	private Category parent;
	private Set<Category> sons;
	public Category() {}
	public String getName() {
		return name;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Category> getSons() {
		return sons;
	}
	public void setSons(Set<Category> sons) {
		this.sons = sons;
	}
}