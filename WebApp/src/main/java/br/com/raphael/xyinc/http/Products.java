package br.com.raphael.xyinc.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Products {
	
	private Integer id;
	private String name;
	private String description;
	private float price;
	private String category;

	public Products() {

	}

	public Products(Integer id, String name, String description, float price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
