package com.partnumber.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.partnumber.model.PartNumberModel;

@Mapper
public interface PartNumberMapper {

	@Select("SELECT id,part_number,part_name,part_stock,part_uom,DATE_FORMAT( part_date , '%D %M %Y')  AS part_date FROM t_pn")
	List<PartNumberModel> ambilSemua();
	
	@Insert("INSERT INTO t_pn (part_number, part_name, part_stock,part_uom,part_date) VALUES (#{part_number},#{part_name},#{part_stock},#{part_uom},#{part_date})")
	void simpanData(PartNumberModel partNumberModel);
	
	@Update("UPDATE t_pn SET part_number=#{part_number}, part_name=#{part_name}, part_stock=#{part_stock}, part_uom=#{part_uom} ,part_date=#{part_date} WHERE id=#{id}")
	void updateData(PartNumberModel partNumberModel);
	
	@Select("SELECT id,part_number,part_name,part_stock,part_uom,part_date FROM t_pn WHERE id=#{id}")
	PartNumberModel selectId(int idPartNumber);
	
	@Select("SELECT id,part_number,part_name,part_stock,part_uom,DATE_FORMAT( part_date , '%D %M %Y')  AS part_date FROM t_pn WHERE  part_date BETWEEN #{date1} AND #{date2}")
	List<PartNumberModel> ambilSemuaByDate(String date1,String date2);

	
	
	@Delete("DELETE FROM t_pn WHERE id=#{id}")
	void deleteData(int idPartNumber);
} 
