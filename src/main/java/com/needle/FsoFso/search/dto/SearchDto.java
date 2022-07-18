package com.needle.FsoFso.search.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class SearchDto implements Serializable {
	
	private static final long serialVersionUID = -5976928232131418153L;
	
	/**
	 * 
	
	create table product (
		id bigint auto_increment primary key ,
		name varchar(50),
		thumbnail_url varchar(500) not null,
		price int  not null,
	    stock int  not null,
		created_at timestamp not null,
		updated_at timestamp not null
	);

	 */
	
	private BigInteger id;
	private String name;
	private String thumbnail_url;
	private int price;
	private int stock;
	private Timestamp created_at;
	private Timestamp updated_at;

	public SearchDto() {
	}

	public SearchDto(BigInteger id, String name, String thumbnail_url, int price, int stock, Timestamp created_at,
			Timestamp updated_at) {
		this.id = id;
		this.name = name;
		this.thumbnail_url = thumbnail_url;
		this.price = price;
		this.stock = stock;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbnail_url() {
		return thumbnail_url;
	}

	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
}