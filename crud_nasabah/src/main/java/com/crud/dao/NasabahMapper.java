package com.crud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.crud.model.NasabahModel;

@Mapper
public interface NasabahMapper {
	
	@Select("SELECT id, nama, alamat FROM nasabah")
	List<NasabahModel> ambilSemuaNasabah();
	
	@Insert("INSERT INTO nasabah (nama,alamat) VALUES (#{nama},#{alamat})")
	void tambahNasabah(NasabahModel nasabah);
	
	@Select("SELECT id,nama,alamat FROM nasabah WHERE id=#{id}")
	NasabahModel ambilNasabah(int id);
	
	@Update("UPDATE nasabah SET nama=#{nama},alamat=#{alamat} WHERE id=#{id}")
	void updateNasabah(NasabahModel nasabah);
	
	@Delete("DELETE FROM nasabah WHERE id=#{id} ")
	void hapusNasabah(int id);
}
