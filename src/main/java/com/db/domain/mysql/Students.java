package com.db.domain.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_usecase")
public class Students {

	@Id
	@Column(name="stu_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="stu_name")
	private String name;
	@Column(name="total")
	private Float total;
	@Column(name="average")
	private Float average;
	@Column(name="result")
	private String result;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Float getAverage() {
		return average;
	}
	public void setAverage(Float average) {
		this.average = average;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public Students(String name, Float total, Float average, String result) {
		super();
		this.name = name;
		this.total = total;
		this.average = average;
		this.result = result;
	}
	
	public Students() {
		super();
	}
	
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", total=" + total + ", average=" + average + ", result="
				+ result + "]";
	}

}