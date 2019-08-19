package com.sapient.ops.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name = "products_sapient")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long product_id;
	@NotBlank
	private String product_name;
	private String description;
	@JsonFormat(shape = JsonFormat.Shape.STRING,
			pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date manufacture_date;
	@NotNull
	private Double buying_price;
	
	public Product() {
	}
	public Product(Long product_id, @NotBlank String product_name, String description, Date manufacture_date,
			@NotBlank Double buying_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.description = description;
		this.manufacture_date = manufacture_date;
		this.buying_price = buying_price;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getManufacture_date() {
		return manufacture_date;
	}
	public void setManufacture_date(Date manufacture_date) {
		this.manufacture_date = manufacture_date;
	}
	public Double getBuying_price() {
		return buying_price;
	}
	public void setBuying_price(Double buying_price) {
		this.buying_price = buying_price;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", description=" + description
				+ ", manufacture_date=" + manufacture_date + ", buying_price=" + buying_price + "]";
	}
	
	
}
