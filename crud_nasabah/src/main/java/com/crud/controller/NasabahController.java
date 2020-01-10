package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.model.NasabahModel;
import com.crud.service.NasabahService;

@Controller
public class NasabahController {

	@Autowired
	NasabahService nasabahService;
	
	
	
	@RequestMapping("/nasabah/semua")
	public String lihatSemuaNasabah(Model model) {
		List<NasabahModel> nasabahs = nasabahService.selectAllNasabah();
		model.addAttribute("n", nasabahs);
		return "semua-nasabah";
		
	}
	
	@RequestMapping("/nasabah/tambah")
	public String tambahNasabah() {
		return "form-nasabah";
	}
	
	@RequestMapping("/nasabah/simpan")
	public String  simpanNasabah(
			@RequestParam(value = "nama",required = false) String nama,
			@RequestParam(value = "alamat", required = false) String alamat
			) {
		NasabahModel nasabah = new NasabahModel(0,nama,alamat);
		nasabahService.addNasabah(nasabah);
		  return "redirect:/nasabah/semua";
		  
	}
	
	@RequestMapping("/nasabah/view/{idx}")
	public String viewNasabah(Model model, @PathVariable(value="idx") int id) {
		NasabahModel nasabah = nasabahService.selectNasabah(id);
		model.addAttribute("nasabahs",nasabah);
		return "view-nasabah";
		
	}
	
	
	@RequestMapping("/nasabah/edit/{idx}")
	public String editNasabah(Model model, @PathVariable(value="idx") int id) {
		NasabahModel nasabah = nasabahService.selectNasabah(id);
		model.addAttribute("nasabahs",nasabah);
		return "edit-nasabah";
		
	}
	
	@RequestMapping(value="/nasabah/update", method=RequestMethod.POST)
	public String updateNasabah(
			@RequestParam(value="id", required=false)int id,
			@RequestParam(value = "nama",required = false) String nama,
			@RequestParam(value = "alamat", required = false) String alamat
			) {
		NasabahModel nasabah = new NasabahModel(id,nama,alamat);
		nasabahService.updateNasabah(nasabah);
		return "redirect:/nasabah/semua";
		
	}
	
	@RequestMapping("/nasabah/hapus/{idx}")
	public String hapusNasabah(@PathVariable(value="idx")int id) {
		nasabahService.deleteNasabah(id);
		return "redirect:/nasabah/semua";
	}
	
	
}
