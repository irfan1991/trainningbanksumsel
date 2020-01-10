package com.restbuku.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updatedAt"} ,allowGetters = true)
public class Buku implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank
	private String titleBook;
	
	@NotBlank
	private String namaDepanPengarang ;
	
	@NotBlank
	private String namaBelakangPengarang;
	
	
	private int statusPeminjaman ;
	
	@NotBlank
	private String namaPeminjam;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitleBook() {
		return titleBook;
	}


	public void setTitleBook(String titleBook) {
		this.titleBook = titleBook;
	}


	public String getNamaDepanPengarang() {
		return namaDepanPengarang;
	}


	public void setNamaDepanPengarang(String namaDepanPengarang) {
		this.namaDepanPengarang = namaDepanPengarang;
	}


	public String getNamaBelakangPengarang() {
		return namaBelakangPengarang;
	}


	public void setNamaBelakangPengarang(String namaBelakangPengarang) {
		this.namaBelakangPengarang = namaBelakangPengarang;
	}


	public int getStatusPeminjaman() {
		return statusPeminjaman;
	}


	public void setStatusPeminjaman(int statusPeminjaman) {
		this.statusPeminjaman = statusPeminjaman;
	}


	public String getNamaPeminjam() {
		return namaPeminjam;
	}


	public void setNamaPeminjam(String namaPeminjam) {
		this.namaPeminjam = namaPeminjam;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
	
	
	
	

}
