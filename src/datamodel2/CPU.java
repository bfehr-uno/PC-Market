package datamodel2;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cpu")
public class CPU {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "model_name")
	private String modelName; 
	
	@Column(name = "cores")
	private String numOfCores;

	@Column(name = "frequency")
	private String frequency;

	@Column(name = "socket")
	private String socketCompatibility;
	
	@Column(name = "price")
	private String price;

	public CPU() {
	}

	public CPU(Integer id, 
			   String manufacturer, 
			   String modelNa, 
			   String cores, 
			   String freq, String socketC, 
			   String price) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.numOfCores = cores;
		this.frequency = freq;
		this.socketCompatibility = socketC;
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
	
	public String getNumOfCores() {
		return numOfCores;
	}

	public void setnumOfCores(String cores) {
		this.numOfCores = cores;
	}

	public String getFreq() {
		return frequency;
	}

	public void setFreq(String freq) {
		this.frequency = freq;
	}
	
	public String getSocketCompatibility() {
		return socketCompatibility;
	}

	public void setsocketCompatibility(String socketC) {
		this.socketCompatibility = socketC;
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
		attributes.add(numOfCores);
		attributes.add(frequency);
		attributes.add(socketCompatibility);
		return attributes;
	}

	@Override
	public String toString() {
		return "CPU(s):" + this.id + ", " + this.manufacturer + ", " + 
			   this.modelName + ", " +  this.numOfCores  + ", " + 
			   this.frequency + ", " + this.socketCompatibility + ", " + 
			   this.price;
	}
}
