package slw032o2m_self;

import java.util.Set;

/*
 * 	双向一对多或多对一　自身关联
 */

public class Category {
	private int id;
	private String name;
	
	// 如果把Category看成多的一端
	private Category parent;
	
	// 如果把Category看成少的一端，则需要对多的一端进行对象集合的引用
	private Set<Category> sons;
	
	public Category () {}

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

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Set<Category> getSons() {
		return sons;
	}

	public void setSons(Set<Category> sons) {
		this.sons = sons;
	}
}
