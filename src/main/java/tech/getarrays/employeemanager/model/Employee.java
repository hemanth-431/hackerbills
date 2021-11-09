package tech.getarrays.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false,updatable=false,name="BillId")
private Long id;
	
private String BilledTo;
@Column(name="BillDate") 
private String date;
@Column(name="BillPrice") 
private String price;
@Column(name="BillTax") 
private String tax;
@Column(name="BillTotal") 
private String total;

public Employee(Long id, String BilledTo, String date, String price, String tax, String total) {
	super();
	this.id = id;
	this.BilledTo = BilledTo;
	this.date = date;
	this.price = price;
	this.tax = tax;
	this.total = total;
	
}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getBilledTo() {
	return BilledTo;
}

public void setBilledTo(String billedTo) {
	BilledTo = billedTo;
}


public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}


public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getTax() {
	return tax;
}

public void setTax(String tax) {
	this.tax = tax;
}

public String getTotal() {
	return total;
}

public void setTotal(String total) {
	this.total = total;
}


@Override
public String toString() {
	return "Employee [Bill Number=" + id + ", Billed To=" + BilledTo + ", Billed Date=" + date + ", Billed Price=" + price + ", Tax=" + tax
			+ ", Total=" + total + "]";
}


 
}

