package slw04m2m_m2m;

import java.util.Set;

public class Custom {
	private int id;
	private String customName;
	private float money;
	private Set<Food> foods;
	
	public Set<Food> getFoods() {
		return foods;
	}
	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public Custom() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
}
