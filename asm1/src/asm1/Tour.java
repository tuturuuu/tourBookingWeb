package asm1;

public class Tour {
	private int id;  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private String  image;
	private String description;
	private String start_date;
	private String duetime;
	private float price;
	private boolean status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String knownImageData) {
		this.image = knownImageData;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getDuetime() {
		return duetime;
	}
	public void setDuetime(String duetime) {
		this.duetime = duetime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Tour [id=" + id + ", name=" + name + ", image=" + image + ", description=" + description
				+ ", start_date=" + start_date + ", duetime=" + duetime + ", price=" + price + ", status=" + status
				+ "]";
	}
	public Tour(int id, String name, String image, String description, String start_date, String duetime, float price,
			boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.description = description;
		this.start_date = start_date;
		this.duetime = duetime;
		this.price = price;
		this.status = status;
	}
	public Tour(String name, String image, String description, String start_date, String duetime, float price,
			boolean status) {
		super();
		this.name = name;
		this.image = image;
		this.description = description;
		this.start_date = start_date;
		this.duetime = duetime;
		this.price = price;
		this.status = status;
	}
	
	
	
	
}
