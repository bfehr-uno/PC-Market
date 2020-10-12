package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hard_Drive")
public class Hard_Drive {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "Storage_Space")
	private String storageSpace;

	@Column(name = "Rotations_Per_Minute")
	private String rotationsPerMinute;

	public Hard_Drive() {
	}

	public Hard_Drive(Integer id, String storage, String rpm) {
		this.id = id;
		this.storageSpace = storage;
		this.rotationsPerMinute = rpm;
	}

	public Hard_Drive(String storage, String rpm) {
		this.storageSpace = storage;
		this.rotationsPerMinute = rpm;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStorageSpace() {
		return storageSpace;
	}

	public void setStorageSpace(String storage) {
		this.storageSpace = storage;
	}

	public String getRotationsPerMinute() {
		return rotationsPerMinute;
	}

	public void setRotationsPerMinute(String rpm) {
		this.rotationsPerMinute = rpm;
	}

	@Override
	public String toString() {
		return "Motherboard:" + this.id + ", " + this.storageSpace + ", " + this.rotationsPerMinute;
	}
}