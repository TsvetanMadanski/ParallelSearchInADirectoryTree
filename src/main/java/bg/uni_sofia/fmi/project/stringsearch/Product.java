package bg.uni_sofia.fmi.project.stringsearch;

public class Product {
	private String fileName;
	private int numberOfARowInFile;
	private String text;
	
	public Product(String fileName, int numberOfARowInFile, String text) {
		this.fileName = fileName;
		this.numberOfARowInFile = numberOfARowInFile;
		this.text = text;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public int getNumberOfARowInFile() {
		return numberOfARowInFile;
	}
	
	public void setNumberOfARowInFile(int numberOfARowInFile) {
		this.numberOfARowInFile = numberOfARowInFile;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}
