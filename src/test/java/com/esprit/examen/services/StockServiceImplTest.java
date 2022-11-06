package com.esprit.examen.services;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
	IStockService stockService;
	

	
	@Test
	public void testAddStock() {

		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
	@Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}

	 @Test
	 public void testUpdateOperateur() {
	 Stock o = new Stock("stock test",10,100);
	 o.setLibelleStock("updated stock");

	 Stock savedStock = stockService.addStock(o);
	 savedStock.setLibelleStock("updated stock");
	 stockService.updateStock(savedStock);
	 assertEquals(o.getLibelleStock(), savedStock.getLibelleStock());
	 stockService.deleteStock(savedStock.getIdStock());
	 }
}
