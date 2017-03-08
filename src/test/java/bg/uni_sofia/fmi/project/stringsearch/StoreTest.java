package bg.uni_sofia.fmi.project.stringsearch;

import org.junit.Assert;
import org.junit.Test;

import bg.uni_sofia.fmi.project.stringsearch.Product;
import bg.uni_sofia.fmi.project.stringsearch.Store;

public class StoreTest {

	@Test
	public void isEmptyTest() {
		
		Store store = new Store();
		String fileName = "D:\\A.txt";
		int rowNumber = 4;
		String text = "rafael nadal vs roger federer";
		Product product = new Product(fileName, rowNumber, text);
		
		store.add(product);
		
		Assert.assertFalse(store.isEmpty());
	}
	
	@Test
	public void isFullTest() {
		//MAX SIZE OF STORE IS 1000 
		Store store = new Store();
		String fileName = "D:\\A.txt";
		
		String text = "novak djokovic vs roger federer";
		
		for(int rowNumber = 1; rowNumber <= 1001; ++rowNumber) {
			store.add(new Product(fileName, rowNumber , text));
		}
		
		Assert.assertTrue(store.isFull());
		
		store.remove(0);
		
		Assert.assertTrue(store.isFull());
		
		store.remove(0);
		
		Assert.assertFalse(store.isFull());
	}

}
