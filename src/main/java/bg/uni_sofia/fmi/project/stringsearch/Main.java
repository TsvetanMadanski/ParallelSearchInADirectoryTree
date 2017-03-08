package bg.uni_sofia.fmi.project.stringsearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static final int NUM_OF_CONSUMERS = 2000;
	private static String stringToSearch;
	private static Path directoryToSearch;
	private static Store store;
	private static ArrayList<Thread> consumers;
	
	
	public static void main(String[] args) {
		
		inputData();
		
		for(Thread consumer : consumers) {
			consumer.start();
		}
		
		
		ParallelSearch ps = new ParallelSearch(directoryToSearch, store);
		
		try {
			ps.beginSearchingParaller();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
		
	}

	public static void inputData() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string to search: ");
		stringToSearch = input.next();
		
		String directory;
		System.out.println("Enter a directory to search for the string: ");
		directory = input.next();
		
		while(!isCorrectDirectory(directory)) {
			System.err.println(" This directory does not exist ");
			System.out.println("Enter a directory again to search for the string: ");
			directory = input.next();
		}
		
		directoryToSearch = Paths.get(directory);
		consumers = new ArrayList<Thread>();
		store = new Store();
		
		for(int i = 0; i < NUM_OF_CONSUMERS; ++i) {
			consumers.add(new Thread(new Consumer(stringToSearch, store)));
		}
		
	}

	public static boolean isCorrectDirectory(String dir) {
	
		File file = new File(dir);
		if(!file.exists()) {
			return false;
		}
		
		if(file.isDirectory()) {
			return true;
		}
		
		if(file.isFile()) {
			return true;
		}
		
		return false;
	}
	
}