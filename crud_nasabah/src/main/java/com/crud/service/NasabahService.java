package com.crud.service;

import java.util.List;

import com.crud.model.NasabahModel;

public interface NasabahService {
	
	List<NasabahModel> selectAllNasabah();
	void addNasabah(NasabahModel nasabah);
	NasabahModel selectNasabah(int nasabah);
	void updateNasabah(NasabahModel nasabah);
	void deleteNasabah(int id);
}
