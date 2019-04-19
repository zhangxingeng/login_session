package data;

public class Phone_type_data {
	private String brand;
	private String model;
	private int ram;
	private int rom;
	private int cpu_core;
	private String os;
	
	
	public Phone_type_data(String brand, String model, int ram, int rom, int cpu_core, String os) {
		super();
		this.brand = brand;
		this.model = model;
		this.ram = ram;
		this.rom = rom;
		this.cpu_core = cpu_core;
		this.os = os;
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
	public int getCpu_core() {
		return cpu_core;
	}
	public void setCpu_core(int cpu_core) {
		this.cpu_core = cpu_core;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}

	
}
