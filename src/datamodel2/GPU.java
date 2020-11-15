package datamodel2;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gpu")
public class GPU{
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "model_name")
	private String modelName; 
	
	@Column(name = "clock_speed")
	private String clockSpeed;
	
	@Column(name = "interf")
	private String interfaceType;
	
	@Column(name = "memory")
	private String memorySize;
	
	@Column(name = "price")
	private String price;
	
	public GPU() {
	}
	
	public GPU(Integer id, 
			   String manufacturer, 
			   String modelNa,
			   String clockSpeed,
			   String interf, 
			   String memory, 
			   String price) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.clockSpeed = clockSpeed;
		this.interfaceType = interf;
		this.memorySize = memory;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelNa) {
		this.modelName = modelNa;
	}
	
	public String getClockSpeed() {
		return clockSpeed;
	}
	
	public void setClockSpeed(String clockSpeed) {
		this.clockSpeed = clockSpeed;
	}
	
	public String getInterfaceType() {
		return interfaceType;
	}
	
	public void setInterfaceType(String interf) {
		this.interfaceType = interf;
	}
	
	public String getMemorySize() {
		return memorySize;
	}
	
	public void setMemorySize(String memory) {
		this.memorySize = memory;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public ArrayList<String> getAttributes() {
		ArrayList<String> attributes = new ArrayList<String>();
		attributes.add(manufacturer);
		attributes.add(modelName);
		attributes.add(clockSpeed);
		attributes.add(interfaceType);
		attributes.add(memorySize);
		return attributes;
	}
	
	@Override
	public String toString() {
		return "GPU:" + this.id + ", " + this.manufacturer + ", " +
			   this.modelName + ", " + this.interfaceType + ", " + 
			   this.memorySize + ", " + this.price;
	}
}