package datamodel2;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "motherboard")
public class Motherboard {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "model_name")
	private String modelName; 
	
	@Column(name = "socket")
	private String socketType;
	
	@Column(name = "expansion_slots")
	private String expansionSlots;
	
	@Column(name = "price")
	private String price;
	
	public Motherboard() {
	}
	
	public Motherboard(Integer id, 
					   String manufacturer, 
					   String modelNa, 
					   String socket, 
					   String expansion,  
					   String price) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.modelName = modelNa;
		this.socketType = socket;
		this.expansionSlots = expansion;
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
	
	public String getSocket() {
		return socketType;
	}
	
	public void setSocket(String socket) {
		this.socketType = socket;
	}
	
	public String getExpansionSlots() {
		return expansionSlots;
	}
	
	public void setExpansionSlots(String expansion) {
		this.expansionSlots = expansion;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Motherboard:" + this.id + ", " + this.manufacturer + ", " +
			   this.modelName + ", " + this.socketType + ", " + 
			   this.expansionSlots + ", " + this.price;
	}
}