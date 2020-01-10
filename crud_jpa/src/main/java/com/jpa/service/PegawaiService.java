package com.jpa.service;

import java.util.List;

import com.jpa.model.Pegawai;

public interface PegawaiService {

	
	List<Pegawai> listPegawai();
	Pegawai saveOrUpdate(Pegawai pegawai);
	Pegawai getIdPegawai(Integer id);
	void hapus(Integer id);
	
}
