package com.partnumber.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.partnumber.model.PartNumberModel;
import com.partnumber.service.PartNumberService;

@Controller
public class PartNumberController {
	
	@Autowired
	PartNumberService partNumberService;
	int number =0;
	
	@RequestMapping("/all")
	public String partNumberSemua(Model model) {
		List<PartNumberModel>  partNumbers = partNumberService.selectAll();
		model.addAttribute("parts",partNumbers);
		model.addAttribute("no",number);
		return "semua-partnumber";
			
	}
	
	@RequestMapping("/pn/tambah")
	public String tambahPn() {
		return "form-pn";
	}
	
	@RequestMapping("/pn/simpan")
    public String simpanData (
            @RequestParam(value = "part_number", required = false) String part_number,
            @RequestParam(value = "part_name", required = false) String part_name,
            @RequestParam(value = "part_stock", required = false) int part_stock,
            @RequestParam(value = "part_uom", required = false) String part_uom,
            @RequestParam(value = "part_date", required = false) String part_date
            ) throws ParseException
    {
		

		PartNumberModel partNumberModel = new PartNumberModel(0, part_number, part_name, part_stock, part_uom,part_date);
        partNumberService.addPartNumber(partNumberModel);
        
        return "redirect:/all";
       // return part_number.toString();
    }
	
	@RequestMapping("/pn/edit/{id}")
	public String editData(Model model,@PathVariable(value="id")int id ) {
		PartNumberModel getView = partNumberService.selectView(id);
		model.addAttribute("views",getView);
		return "edit-form-pn";
	}
	
	@RequestMapping(value="/pn/update",method=RequestMethod.POST)
	public String updateData
	(
			 @RequestParam(value = "id", required = false) int id,
			 @RequestParam(value = "part_number", required = false) String part_number,
	         @RequestParam(value = "part_name", required = false) String part_name,
	         @RequestParam(value = "part_stock", required = false) int part_stock,
	         @RequestParam(value = "part_uom", required = false) String part_uom,
	         @RequestParam(value = "part_date", required = false) String part_date
	) 
	{
		PartNumberModel nilaiUpdate  = new PartNumberModel(id,part_number,part_name,part_stock,part_uom,part_date);
		partNumberService.updatePartNumber(nilaiUpdate);
		return "redirect:/all";	
	}
	
	
	
	@RequestMapping(value="/pn/date",method=RequestMethod.POST)
	public String cariDateData
	(
			 @RequestParam(value = "date1", required = false) String date1,
	         @RequestParam(value = "date2", required = false) String date2,
	         Model model
	         
	) 
	{
		List<PartNumberModel>  partNumbers = partNumberService.selectByDate(date1, date2);
		model.addAttribute("parts",partNumbers);
		return "semua-partnumber";
	}
	
	
	
	
	@RequestMapping("/pn/hapus/{id}")
	public String deleteData(@PathVariable(value="id")int id) {
		partNumberService.deletePartNumber(id);
		return "redirect:/all";
		
	}

}
