package slw032o2m;

/*
 * 	双向的一对多(多对一)
 * 	多的一端
 * 	需要对少的一端进行对象的引用
 */

import java.util.Date;

public class Orders {
	private int id;
	private String orderNum;
	private Date orderTime;
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Orders() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	
}
