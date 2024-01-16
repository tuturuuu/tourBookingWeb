package asm1;

public class Booking {
	private int id; 
	private String userFullName;
	private String name;
	private String image;
	private float price;
	private int user_id;
	private int tour_id;
	private String created_date;
	private int adult_quant;
	private int child_quant;
	
	public Booking(int id, String name, String image, float price, int user_id, int tour_id, String created_date,
			int adult_quant, int child_quant) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.user_id = user_id;
		this.tour_id = tour_id;
		this.created_date = created_date;
		this.adult_quant = adult_quant;
		this.child_quant = child_quant;
	}
	
	public Booking(int id, String userFullName, int user_id, int tour_id, String created_date, int adult_quant,
			int child_quant) {
		super();
		this.id = id;
		this.userFullName = userFullName;
		this.user_id = user_id;
		this.tour_id = tour_id;
		this.created_date = created_date;
		this.adult_quant = adult_quant;
		this.child_quant = child_quant;
	}



	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTour_id() {
		return tour_id;
	}
	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public int getAdult_quant() {
		return adult_quant;
	}
	public void setAdult_quant(int adult_quant) {
		this.adult_quant = adult_quant;
	}
	public int getChild_quant() {
		return child_quant;
	}
	public void setChild_quant(int child_quant) {
		this.child_quant = child_quant;
	}
	

	
	
	
}
