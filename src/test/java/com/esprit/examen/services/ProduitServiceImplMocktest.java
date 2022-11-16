package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplMocktest {
	
	
	@Autowired
	ProduitServiceImpl  ProduitServiceImpl; 
	
	@MockBean
	ProduitRepository ProduitRepository; 
	
	
	

	@Test
	@Order(1)
	public void addProduit()
	{
	  Produit p=new Produit("khaledmocktest","khaledmock");
	  Mockito.when(ProduitRepository.save(p)).thenReturn(p);
		assertEquals(p, ProduitServiceImpl.addProduit(p));
		log.info("produit ajouter avec success");
	  
	  
	}
	@Test
	@Order(2)
	public void update() {
		Produit p = new Produit("khaledmocktest22", "khaledmocktest22");
		Mockito.when(ProduitRepository.save(p)).thenReturn(p);
		assertEquals(p, ProduitServiceImpl.addProduit(p));
		log.info("produit ajouter avec success");
		p.setCodeProduit("aaaa");
		p.setLibelleProduit("mocktest");
		Mockito.when(ProduitRepository.save(p)).thenReturn(p);
		assertEquals(p, ProduitServiceImpl.updateProduit(p));
		log.info("produit mdofier avec success");
	}
	

	@Test
	@Order(3)
	public void retriveAllproducts() {
		Mockito.when(ProduitRepository.findAll()).thenReturn(Stream
				.of(new Produit("prod2", "prod2"), new Produit("prod 3 ", "prod 3")).collect(Collectors.toList()));
		assertEquals(2, ProduitServiceImpl.retrieveAllProduits().size());
		List<Produit> listProduit = ProduitServiceImpl.retrieveAllProduits();
		log.info("==>size:"+listProduit.size());
		for(int i=0;i<listProduit.size();i++){
			log.info("==>"+listProduit.get(i).getLibelleProduit());
		}
	}
	
	
	
	@Test
	@Order(4)
	public void deleteProduitTest() {
		Produit p = new Produit("prod4", "prod 4");
		assertNotNull(p.getCodeProduit());
		assertNotNull(p.getLibelleProduit());
		ProduitServiceImpl.deleteProduit(p.getIdProduit());
		verify(ProduitRepository, times(1)).deleteById(p.getIdProduit());
		log.info("produit supprimer avec success");
	}
	
	@Test
	@Order(5)
	public void deleteAllProduitTest() {
		Mockito.when(ProduitRepository.findAll()).thenReturn(Stream
				.of(new Produit("prod2", "prod 2"), new Produit("prod3", "prod3")).collect(Collectors.toList()));
		assertEquals(2, ProduitServiceImpl.retrieveAllProduits().size());
		List<Produit> listProduit = ProduitServiceImpl.retrieveAllProduits();
		log.info("==>size:"+listProduit.size());
		for(int i=0;i<listProduit.size();i++){
			ProduitServiceImpl.deleteProduit(listProduit.get(i).getIdProduit());;
			log.info("==> categorie "+listProduit.get(i).getLibelleProduit()+" deleted successfulyy ");
		}
	}
	
	}
	
	
	
	

