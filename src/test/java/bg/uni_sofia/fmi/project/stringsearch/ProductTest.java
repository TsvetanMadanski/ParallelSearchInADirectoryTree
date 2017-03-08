package bg.uni_sofia.fmi.project.stringsearch;

import org.junit.Test;

import bg.uni_sofia.fmi.project.stringsearch.Product;
import junit.framework.Assert;

public class ProductTest {

	@Test
	public void productObjectServiceTest() {
		
		String fileName = "D:\\A.txt";
		int rowNumber = 4;
		String text = "rafael nadal vs roger federer";
		Product product = new Product(fileName, rowNumber, text);
		
		Assert.assertTrue(fileName.equals(product.getFileName()));
		Assert.assertTrue(rowNumber == product.getNumberOfARowInFile());
		Assert.assertTrue(text.equals(product.getText()));
		
		product.setNumberOfARowInFile(5);
		Assert.assertFalse(rowNumber == product.getNumberOfARowInFile());
	}

}
