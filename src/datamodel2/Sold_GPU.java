package datamodel2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sold_gpu")
public class Sold_GPU {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "clock_speed")
	private String clockSpeed;
	
	@Column(name = "interf")
	private String interf;
	
	@Column(name = "memory")
	private String memory;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "date_sold")
	private String dateSold;
	
	public Sold_GPU() {
	}
	
	public Sold_GPU(String clockSpeed, String interf, String memory, String price, String dateSold) {
		this.clockSpeed = clockSpeed;
		this.interf = interf;
		this.memory = memory;
		this.price = price;
		this.dateSold = dateSold;
	}
	
	public String getClockSpeed() {
		return clockSpeed;
	}
	
	public String getInterf() {
		return interf;
	}
	
	public String getMemory() {
		return memory;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getDateSold() {
		return dateSold;
	}
}
