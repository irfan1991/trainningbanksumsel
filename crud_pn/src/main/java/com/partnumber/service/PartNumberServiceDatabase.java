package com.partnumber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partnumber.dao.PartNumberMapper;
import com.partnumber.model.PartNumberModel;


@Service
public class PartNumberServiceDatabase implements PartNumberService {

	@Autowired
	PartNumberMapper partNumberMapper;
	
	@Override
	public List<PartNumberModel> selectAll() {
		// TODO Auto-generated method stub
		return partNumberMapper.ambilSemua();
	}

	@Override
	public void addPartNumber(PartNumberModel partNumberModel) {
		// TODO Auto-generated method stub
		partNumberMapper.simpanData(partNumberModel);
	}

	@Override
	public void updatePartNumber(PartNumberModel partNumberModel) {
		// TODO Auto-generated method stub
		partNumberMapper.updateData(partNumberModel);
		
	}

	@Override
	public void deletePartNumber(int idPartNumber) {
		// TODO Auto-generated method stub
		partNumberMapper.deleteData(idPartNumber);
	}

	@Override
	public PartNumberModel selectView(int idPartNumber) {
		// TODO Auto-generated method stub
		return partNumberMapper.selectId(idPartNumber);
	}

	@Override
	public List<PartNumberModel> selectByDate(String date1, String date2) {
		// TODO Auto-generated method stub
		return partNumberMapper.ambilSemuaByDate(date1, date2);
	}

}
