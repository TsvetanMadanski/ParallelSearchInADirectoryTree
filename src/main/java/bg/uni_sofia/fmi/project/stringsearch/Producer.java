package bg.uni_sofia.fmi.project.stringsearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;



public class Producer implements Runnable {
	
	private static Store store;
	private Path directory;
	
	public Producer(Path directory, Store store) {
		this.directory = directory;
		Producer.store = store;
	}
	
	public static Store getStore() {
		return store;
	}

	public Path getDirectory() {
		return directory;
	}

	public void run() {
		String line;
		int numberOfLine = 0;
		ArrayList<Product> products = new ArrayList<Product>();
		
		
		try(BufferedReader br =  new BufferedReader(new FileReader(directory.toFile().toString()))) {
			while((line = br.readLine()) != null) {
				numberOfLine++;
				products.add(new Product(directory.toString(), numberOfLine, line));
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		synchronized (store) {
			while(store.isFull()) {
				try {
					store.wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			store.addAll(products);
			store.notify();
		}
		

	}

}
