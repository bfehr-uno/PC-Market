package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CPU")
public class CPU {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "Manufacturer")
	private String manufacturer;
	
	@Column(name = "Model_Name")
	private String modelName; 
	
	@Column(name = "Num_of_Cores")
	private String numOfCores;

	@Column(name = "Frequency")
	private String frequency;

	@Column(name = "Socket_Compatibility")
	private String socketCompatibility;

	public CPU() {
	}

	public CPU(Integer id, String manufacturer, String modelNa, String cores, String freq, String socketC) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.numOfCores = cores;
		this.frequency = freq;
		this.socketCompatibility = socketC;
	}

	public CPU(String manufacturer, String modelNa, String cores, String freq, String socketC) {
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.numOfCores = cores;
		this.frequency = freq;
		this.socketCompatibility = socketC;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public String getnumOfCores() {
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
	
	public String getsocketCompatibility() {
		return socketCompatibility;
	}

	public void setsocketCompatibility(String socketC) {
		this.socketCompatibility = socketC;
	}


	@Override
	public String toString() {
		return "CPU(s):" + this.id + ", " + this.manufacturer + ", " + 
			   this.ModelName + ", " +  this.numOfCores  + ", " + 
			   this.frequency + ", " + this.socketCompatibility;
	}
}
