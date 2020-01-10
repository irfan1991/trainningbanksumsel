package com.partnumber.service;

import java.util.List;


import com.partnumber.model.PartNumberModel;



public interface PartNumberService {
	
	List<PartNumberModel> selectAll();
	void addPartNumber(PartNumberModel partNumberModel);
	void updatePartNumber(PartNumberModel partNumberModel);
	void deletePartNumber(int idPartNumber);
	PartNumberModel selectView(int idPartNumber);
	List<PartNumberModel> selectByDate(String date1, String date2);
	
}
