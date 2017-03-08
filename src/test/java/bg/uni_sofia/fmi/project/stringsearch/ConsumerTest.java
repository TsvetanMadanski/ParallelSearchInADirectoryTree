package bg.uni_sofia.fmi.project.stringsearch;

import org.junit.Test;

import bg.uni_sofia.fmi.project.stringsearch.Consumer;
import bg.uni_sofia.fmi.project.stringsearch.Product;
import bg.uni_sofia.fmi.project.stringsearch.Store;
import junit.framework.Assert;

public class ConsumerTest {

	@Test
	public void consumerObjectServiceTest() {
		String stringToSearch = "Roger";
		Store store = new Store();
		Consumer consumer = new Consumer(stringToSearch, store);
		
		Assert.assertTrue(stringToSearch.equals(consumer.getStringToSearch()));
		Assert.assertTrue(store.equals(Consumer.getStore()));
	}
	
	@Test
	public void consumeMethodTest() {
		
		String stringToSearch = "aye";
		String fileName = "RogerFederer.txt";
		int rowNumber = 3;
		String lineOfText = "tennis player ever.";
		String otherLineOfText = "Federer - 17 grand slams";
		
		Product product = new Product(fileName, rowNumber, lineOfText);
		Consumer consumer = new Consumer(stringToSearch, new Store());
		Assert.assertEquals(true, consumer.consume(product));
		
		product.setText(otherLineOfText);
		Assert.assertEquals(false, consumer.consume(product));
		
		product.setText("Krayev");
		Assert.assertEquals(true, consumer.consume(product));
	} 
	
	@Test
	public void isFoundStringTest() {
		String stringToSearch = "aye";
		String fileName = "RogerFederer.txt";
		int rowNumber = 3;
		String lineOfText = "tennis player ever.";
		
		Product product = new Product(fileName, rowNumber, lineOfText);
		Consumer consumer = new Consumer(stringToSearch, new Store());
		
		consumer.consume(product);
		boolean actual = Consumer.isFoundString();
		Assert.assertEquals(true, actual);
	}
	

}
