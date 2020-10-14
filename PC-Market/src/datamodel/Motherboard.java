package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Motherboard")
public class Motherboard {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;
   
   @Column(name = "Manufacturer")
   private String manufacturer;
   
   @Column(name = "Model_Name")
   private String modelName; 

   @Column(name = "Socket_Type")
   private String socketType;

   @Column(name = "Form_Factor")
   private String formFactor;

   public Motherboard(Integer id, String manufacturer, String modelNa, String socket, String form) {
      this.id = id;
      this.manufacturer = manufacturer;
      this.modelName = modelNa;
      this.socketType = socket;
      this.formFactor = form;
   }

   public Motherboard(String manufacturer, String modelNa, String socketType, String formFactor) {
	  this.manufacturer = manufacturer;
	  this.modelName = modelNa;
      this.socketType = socketType;
      this.formFactor = formFactor;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
   
	public String getManufacturer() {
		return Manufacturer;
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

   public String getForm() {
      return formFactor;
   }

   public void setForm(String form) {
      this.formFactor = form;
   }

   @Override
   public String toString() {
      return "Motherboard:" + this.id + ", " + this.manufacturer + ", " + this.modelName + ", " + this.socketType + ", " + this.formFactor;
   }
}