package data;
import java.sql.Timestamp;

public class List_item_data {
	private String email;
	private String title;
	private String description;
	private String status;
	private float start_price;
	private Timestamp timestamp;
	private int item_num;
	
	private String brand;
	private String model;
	private int ram;
	private int rom;
	private int cpu_core;
	private String os;
	//data beneath here is generated
	private float curr_price;
	private int bid_count;

	
	public List_item_data() {
		
	}

	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
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
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
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

	public int getCpu_core() {
		return cpu_core;
	}

	public void setCpu_core(int cpu_core) {
		this.cpu_core = cpu_core;
	}
	public int getBid_count() {
		return bid_count;
	}
	
	public void setBid_count(int bid_count) {
		this.bid_count = bid_count;
	}
	
}