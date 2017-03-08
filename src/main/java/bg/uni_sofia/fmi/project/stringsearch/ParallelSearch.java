package bg.uni_sofia.fmi.project.stringsearch;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.FileVisitResult;
import java.io.*;

public class ParallelSearch {
	
	private Path directory;
	private static Store store;

	public ParallelSearch(Path directory, Store store) {
		this.directory = directory;
		ParallelSearch.store = store;
	}
	
	public Path getDirectory() {
		return directory;
	}

	public static Store getStore() {
		return store;
	}


	public void beginSearchingParaller() throws IOException {
		Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				return FileVisitResult.SKIP_SUBTREE;
			}
			
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if(file.toString().endsWith(".txt")) {
					Thread producer = new Thread(new Producer(file, store));
					producer.start();
					try {
						producer.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				return FileVisitResult.CONTINUE;
			}
		});
	}
	
}
