package bg.uni_sofia.fmi.project.stringsearch;

import java.util.ArrayList;

public class Store extends ArrayList<Product> {
	
	private static final int MAX_SIZE_OF_STORE = 1000;
	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}
	
	public boolean isFull() {
		return this.size() >= MAX_SIZE_OF_STORE;
	}
	
}
