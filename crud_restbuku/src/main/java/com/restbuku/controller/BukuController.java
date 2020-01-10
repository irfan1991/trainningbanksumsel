package com.restbuku.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restbuku.repository.BukuRepository;
import com.restbuku.model.*;
@RestController
@RequestMapping("/api/v1")
public class BukuController {

	@Autowired
	BukuRepository bukuRepository;
	
	@GetMapping("/buku")
	public List<Buku> getAll(){
		return bukuRepository.findAll() ;
		
	}
	
	@PostMapping("/buku")
	public Buku tambahbuku(@Valid @RequestBody Buku buku) {
		return bukuRepository.save(buku);
		
	}
	
	@PutMapping("/buku/{id}")
	public ResponseEntity<Buku> updateBuku(
			@PathVariable(value ="id")Long id,
			@Valid @RequestBody Buku detailBuku
	){
		Buku buku =  bukuRepository.findById(id).get();
		if(buku == null)
			return ResponseEntity.notFound().build();
		buku.setTitleBook(detailBuku.getTitleBook());
		buku.setNamaBelakangPengarang(detailBuku.getNamaBelakangPengarang());
		buku.setNamaDepanPengarang(detailBuku.getNamaDepanPengarang());
		buku.setNamaPeminjam(detailBuku.getNamaPeminjam());
		buku.setStatusPeminjaman(detailBuku.getStatusPeminjaman());
		Buku updatedBuku =bukuRepository.save(buku);
		return ResponseEntity.ok(updatedBuku);
		
		
	}
	
	@GetMapping("/buku/{id}")
	public Map<String, Object> getBukuId(@PathVariable(value="id") Long id){
		Buku buku =  bukuRepository.findById(id).get();
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(buku == null) {
			 map.put("status", "error");
	    	 map.put("message",  ResponseEntity.notFound().build());
	    	 return  map;
		}else {
		map.put("status", "success");
	    map.put("data", ResponseEntity.ok().body(buku));
		return map;
		}

	
	}
	
	@DeleteMapping("/buku/{id}")
	public HashMap<String, String> deleteBuku(@PathVariable(value="id") Long id) {
		Buku buku =  bukuRepository.findById(id).get();
		
		String result = "";
		
		if(buku == null) {
		result = "id "+id+" tidak ditemukan";
		 HashMap<String, String> map = new HashMap<>();
		    map.put("status", "error");
		    map.put("message", result);
		return map;
		}
		result = "id "+id+" berhasil di hapus";
		bukuRepository.deleteById(id);
		 HashMap<String, String> map = new HashMap<>();
		    map.put("status", "error");
		    map.put("message", result);
		return map; 
		
		
	}
	
	
	@GetMapping("/sortbuku")
	public List<Buku> sortBuku(@RequestParam(value="title") String titleBook){
		return bukuRepository.findByTitleBook(titleBook);
		
	}
	
	@GetMapping("/sortstatus/{statusPeminjaman}")
	public List<Buku> sortStatus(@PathVariable(value="statusPeminjaman")int statusPeminjaman){
		return bukuRepository.findByStatusPeminjaman(statusPeminjaman);
	}
	
	
	
	
}
