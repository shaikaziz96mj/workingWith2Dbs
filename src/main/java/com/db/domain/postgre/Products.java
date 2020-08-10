package com.db.domain.postgre;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="type")
	private String type;
	@Column(name="price")
	private Long price;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	public Products(String name, String type, Long price) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
	}
	
	public Products() {
		super();
	}
	
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}	
	
}