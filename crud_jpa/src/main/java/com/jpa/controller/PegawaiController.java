package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpa.model.Pegawai;
import com.jpa.service.PegawaiService;

@Controller
public class PegawaiController {

	private PegawaiService pegawaiService;

	
	@Autowired
	public void setPegawaiService(PegawaiService pegawaiService) {
		this.pegawaiService = pegawaiService;
	}
	
	@RequestMapping("pegawai")
	public String home(Model model) {
		model.addAttribute("pegawais",pegawaiService.listPegawai());
		return "semua-pegawai";
		
	}
	
	@RequestMapping(value ="/pegawai/create",method=RequestMethod.GET )
	public String tampilkanForm(Model model) {
		model.addAttribute("pegawai",new Pegawai());
		model.addAttribute("view",0);
		return "form-pegawai";
	}
	
	@RequestMapping(value = "/pegawai/edit/{id}",method=RequestMethod.GET)
	public String editForm(@PathVariable Integer id,Model model) {
		model.addAttribute("view",0);
		model.addAttribute("pegawai",pegawaiService.getIdPegawai(id));
		return "form-pegawai";
		
	}
	
	@RequestMapping(value = "/pegawai/view/{id}",method=RequestMethod.GET)
	public String viewForm(@PathVariable Integer id,Model model) {
		model.addAttribute("view",1);
		model.addAttribute("pegawai",pegawaiService.getIdPegawai(id));
		return "form-pegawai";
		
	}
	
	@RequestMapping(value= "/pegawai/create", method=RequestMethod.POST)
	public String simpanDataPegawai(Model model, Pegawai pegawai) {
		model.addAttribute("pegawai", pegawaiService.saveOrUpdate(pegawai));
		return "redirect:/pegawai";
	}
	
	
	@RequestMapping(value = "/pegawai/hapus/{id}")
	public String hapus(@PathVariable Integer id) {
		pegawaiService.hapus(id);
		return "redirect:/pegawai";
		
	}
	
}
