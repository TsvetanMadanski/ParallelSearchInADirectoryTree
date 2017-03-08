package bg.uni_sofia.fmi.project.stringsearch;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import bg.uni_sofia.fmi.project.stringsearch.ParallelSearch;
import bg.uni_sofia.fmi.project.stringsearch.Store;
import junit.framework.Assert;

public class ParallelSearchTest {

	@Test
	public void parallelSearchObjectServiceTest() {
		Path directory = Paths.get("D:\\");
		Store store = new Store();
		
		ParallelSearch ps = new ParallelSearch(directory, store);
		
		Assert.assertTrue(ps.getDirectory().equals(directory));
		Assert.assertTrue(ParallelSearch.getStore().equals(store));
	}
	

}
