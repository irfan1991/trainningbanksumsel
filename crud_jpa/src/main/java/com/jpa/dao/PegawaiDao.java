package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpa.model.Pegawai;
import com.jpa.service.PegawaiService;


@Service
public class PegawaiDao implements PegawaiService {

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf =emf;
	}
	
	
	@Override
	public List<Pegawai> listPegawai() {
		// TODO Auto-generated method stub
		EntityManager em=emf.createEntityManager();
		return em.createQuery("from Pegawai",Pegawai.class).getResultList();
	}

	@Override
	public Pegawai saveOrUpdate(Pegawai pegawai) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pegawai saved = em.merge(pegawai);
		em.getTransaction().commit();
		
		return saved;
	}

	@Override
	public Pegawai getIdPegawai(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Pegawai.class, id);
	}

	@Override
	public void hapus(Integer id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Pegawai.class,id));
		em.getTransaction().commit();
		
	}

}
