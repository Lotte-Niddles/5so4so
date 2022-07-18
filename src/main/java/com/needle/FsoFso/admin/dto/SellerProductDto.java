package com.needle.FsoFso.admin.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SellerProductDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	id;
	private String name;
	private String thumbnailUrl;
	private int price;
	private int stock;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
