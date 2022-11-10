package com.esprit.examen.services;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;

@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {
	@Mock
    StockRepository stockRepository;

    @InjectMocks
	StockServiceImpl stockServiceImpl;
	
	Stock s = new Stock("testLibelle1",10,150);
	Stock s1 = new Stock("testLibelle1",50,100);
	Stock s2 = new Stock("testLibelle2",5,80);
	List<Stock> stock = new ArrayList<Stock>() {{add(s1); add(s2);}}; 
	
	@Test
	public void testGetAllStock() {
		stockServiceImpl.retrieveAllStocks();
		verify(stockRepository).findAll();
	}
	
	@Test
	public void testGetStock() {
		Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
		assertNotNull(stockServiceImpl.retrieveStock((long)3));	
	}
	
	@Test
	public void testaddStock() {
		Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(s);
		assertNotNull(stockServiceImpl.addStock(s));
		//verify(stockRepository).save(s);
	}
	
	@Test
	public void testUpdateStock() {
		Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(s);
		s.setQte(55);
		assertNotNull(stockServiceImpl.updateStock(s));	
		assertEquals(55, s.getQte());
	}
	
	
	@Test
	public void testDeleteStock() {
		stockServiceImpl.deleteStock((long)3);
		verify(stockRepository).deleteById((long)3);
	}
	
	
	
	
	
	
	
	
	
	
}