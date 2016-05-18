package slw04m2m;

import java.util.Set;

public class Food {
	private int id;
	private String foodName;
	private float price;
	private Set<Custom> customs;
	public Food() {}
	public Set<Custom> getCustoms() {
		return customs;
	}

	public void setCustoms(Set<Custom> customs) {
		this.customs = customs;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
