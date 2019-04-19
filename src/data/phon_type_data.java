package data;

public class phon_type_data {
	private String brand;
	private String model;
	private Int ram;
	private Int rom;
	private Int cpu_core;
	private String os;

	
  public phon_type(String brand, String model, Int ram, Int rom, int cpu_core, String os) {
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
	public void setBrand(String Brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Int getRam() {
		return ram;
	}
	public void setRam(Int ram) {
		this.ram = ram;
	}
  	public Int getRom() {
		return rom;
	}
	public void setRom(Int rom) {
		this.rom = rom;
	}
  	public Int getCpu_core() {
		return cpu_core;
	}
	public void setCpu_core(Int cpu_core) {
		this.cpu_core = cpu_core;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	
}
