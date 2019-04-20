<<<<<<< HEAD
package data;
import java.util.Date;

public class List_item_data {
	private String email;
	private String title;
	private String description;
	private String category;
	private String status;
	private float start_price;
	private java.util.Date date;
	private int item_bidamount;
	private String item_num;
	//data beneath here is generated
	private float curr_price;
	
	
	
	public List_item_data(String email, String title, String description, String category, String status,
			float start_price, Date date, int item_bidamount, String item_num, float curr_price) {
		super();
		this.email = email;
		this.title = title;
		this.description = description;
		this.category = category;
		this.status = status;
		this.start_price = start_price;
		this.date = date;
		this.item_bidamount = item_bidamount;
		this.item_num = item_num;
		
		this.curr_price =curr_price;
	}
	
	
	public String getItem_num() {
		return item_num;
	}
	public void setItem_num(String item_num) {
		this.item_num = item_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getStart_price() {
		return start_price;
	}
	public void setStart_price(float start_price) {
		this.start_price = start_price;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public int getItem_bidamount() {
		return item_bidamount;
	}
	public void setItem_bidamount(int item_bidamount) {
		this.item_bidamount = item_bidamount;
	}
	
	
	public float getCurr_price() {
		return curr_price;
	}
	public void setCurr_price(float curr_price) {
		this.curr_price = curr_price;
	}
	
}


=======
package data;
import java.util.Date;

public class List_item_data {
	private String email;
	private String title;
	private String description;
	private String status;
	private float start_price;
	private java.util.Date date;
	private int item_bidamount;
	private String item_num;
	
	private String brand;
	private String model;
	private int ram;
	private int rom;
	private String os;
	//data beneath here is generated
	private float curr_price;
	
	
	
	public List_item_data(String email, String title, String description, String status,
			float start_price, Date date, int item_bidamount, String item_num, String brand, String model, int ram,
			int rom, String os, float curr_price) {
		super();
		this.email = email;
		this.title = title;
		this.description = description;
		this.status = status;
		this.start_price = start_price;
		this.date = date;
		this.item_bidamount = item_bidamount;
		this.item_num = item_num;
		this.brand = brand;
		this.model = model;
		this.ram = ram;
		this.rom = rom;
		this.os = os;
		this.curr_price = curr_price;
	}

	
	public String getItem_num() {
		return item_num;
	}
	public void setItem_num(String item_num) {
		this.item_num = item_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getStart_price() {
		return start_price;
	}
	public void setStart_price(float start_price) {
		this.start_price = start_price;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public int getItem_bidamount() {
		return item_bidamount;
	}
	public void setItem_bidamount(int item_bidamount) {
		this.item_bidamount = item_bidamount;
	}
	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getRam() {
		return ram;
	}


	public void setRam(int ram) {
		this.ram = ram;
	}


	public int getRom() {
		return rom;
	}


	public void setRom(int rom) {
		this.rom = rom;
	}


	public String getOs() {
		return os;
	}


	public void setOs(String os) {
		this.os = os;
	}


	
	
	


	public float getCurr_price() {
		return curr_price;
	}
	public void setCurr_price(float curr_price) {
		this.curr_price = curr_price;
	}
	
}
>>>>>>> branch 'master' of https://github.com/zhangxingeng/336_project_buyme.git
