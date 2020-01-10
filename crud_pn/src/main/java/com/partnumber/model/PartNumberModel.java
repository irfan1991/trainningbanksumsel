package com.partnumber.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartNumberModel {
	
	private int id;
	private String part_number;
	private String part_name;
	private int part_stock;
	private String part_uom;
	private String  part_date;

}
