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

   @Column(name = "Socket_Type")
   private String socketType;

   @Column(name = "Form_Factor")
   private String formFactor;

   public Motherboard() {
   }

   public Motherboard(Integer id, String socket, String form) {
      this.id = id;
      this.socketType = socket;
      this.formFactor = form;
   }

   public Motherboard(String socketType, String formFactor) {
      this.socketType = socketType;
      this.formFactor = formFactor;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
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
      return "Motherboard:" + this.id + ", " + this.socketType + ", " + this.formFactor;
   }
}