package by.htp.xml.food.entity;

public class Food {

	private int id;
	private String name;
	private double price;
	private String description;
	private double calories;

	public Food() {
		super();
	}

	public Food(int id, String name, double price, String description, double calories) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.calories = calories;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", calories="
				+ calories + "]";
	}
	
	

}
