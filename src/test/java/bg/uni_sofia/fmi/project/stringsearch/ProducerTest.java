package bg.uni_sofia.fmi.project.stringsearch;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import bg.uni_sofia.fmi.project.stringsearch.Producer;
import bg.uni_sofia.fmi.project.stringsearch.Store;
import junit.framework.Assert;

public class ProducerTest {

	@Test
	public void producerObjectServiceTest() {
		Path directory = Paths.get("D:\\Users");
		Store store = new Store();
		
		Producer producer = new Producer(directory, store);
		
		Assert.assertTrue(producer.getDirectory().equals(directory));
		Assert.assertTrue(Producer.getStore().equals(store));
	}

}
