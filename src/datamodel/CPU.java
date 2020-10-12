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

	@Column(name = "Num_of_Cores")
	private String NumOfCores;

	@Column(name = "Cache_Size")
	private String CacheSize;

	@Column(name = "Socket_Compatibility")
	private String SocketCompatibility;

	public CPU() {
	}

	public CPU(Integer id, String cores, String cache, String socketC) {
		this.id = id;
		this.NumOfCores = cores;
		this.CacheSize = cache;
		this.SocketCompatibility = socketC;
	}

	public CPU(String cores, String cache, String socketC) {
		this.NumOfCores = cores;
		this.CacheSize = cache;
		this.SocketCompatibility = socketC;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumOfCores() {
		return NumOfCores;
	}

	public void setNumOfCores(String cores) {
		this.NumOfCores = cores;
	}

	public String getCacheSize() {
		return CacheSize;
	}

	public void setCacheSize(String cache) {
		this.CacheSize = cache;
	}
	
	public String getSocketCompatibility() {
		return SocketCompatibility;
	}

	public void setSocketCompatibility(String socketC) {
		this.SocketCompatibility = socketC;
	}


	@Override
	public String toString() {
		return "CPU(s):" + this.id + ", " + this.NumOfCores  + ", " + this.CacheSize + ", " + this.SocketCompatibility;
	}
}
