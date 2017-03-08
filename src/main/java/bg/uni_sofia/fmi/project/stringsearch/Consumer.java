package bg.uni_sofia.fmi.project.stringsearch;

public class Consumer implements Runnable {

	private String stringToSearch;
	private static boolean foundString = false;
	private static Store store;
	
	
	public Consumer(String stringToSearch, Store store) {
		this.stringToSearch = stringToSearch;
		Consumer.store = store;
	}
	
	public String getStringToSearch() {
		return stringToSearch;
	}

	public static Store getStore() {
		return store;
	}

	public boolean consume(Product product) {
		if(product.getText().contains(stringToSearch)) { 
			System.out.printf(" Filename: %s line:%d : %s \n", product.getFileName(), product.getNumberOfARowInFile(), product.getText());
			foundString = true;
			return true;
			
		}
		return false;
	}
	
	public void run() {

		while(true) {
			
			synchronized (store) {
				for(Product product : store) {
					this.consume(product);
				}
				
				store.clear();
				
				try {
					store.wait();
				} catch (InterruptedException iex) {
					iex.printStackTrace();
				}
			}
		}
	}

	public static boolean isFoundString() {
		return foundString;
	}

}
