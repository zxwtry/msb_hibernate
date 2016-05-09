package slw03o2m;

import java.util.Set;

/*
 * 	one
 */

public class Account {
	private int id;
	private String accName;
	// 对many端对象集合的引用
	private Set<Orders> setOrders;
	public Account () {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public Set<Orders> getSetOrders() {
		return setOrders;
	}
	public void setSetOrders(Set<Orders> setOrders) {
		this.setOrders = setOrders;
	}
	
}
