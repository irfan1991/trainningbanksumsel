package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.NasabahMapper;
import com.crud.model.NasabahModel;

@Service
public class NasabahServiceDatabase implements NasabahService {

	@Autowired
	NasabahMapper nasabahMapper;
	
	@Override
	public List<NasabahModel> selectAllNasabah() {
		// TODO Auto-generated method stub
		return nasabahMapper.ambilSemuaNasabah();
	}

	@Override
	public void addNasabah(NasabahModel nasabah) {
		// TODO Auto-generated method stub
		nasabahMapper.tambahNasabah(nasabah);;
	}

	@Override
	public NasabahModel selectNasabah(int nasabah) {
		// TODO Auto-generated method stub
		return nasabahMapper.ambilNasabah(nasabah);
	}

	@Override
	public void updateNasabah(NasabahModel nasabah) {
		// TODO Auto-generated method stub
		nasabahMapper.updateNasabah(nasabah);
	}

	@Override
	public void deleteNasabah(int id) {
		// TODO Auto-generated method stub
		nasabahMapper.hapusNasabah(id);
	}

}
