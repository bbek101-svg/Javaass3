package utilities;

import java.util.ArrayList;

public class WordRead implements Comparable{
	private String word;
	private int count;
	private ArrayList<Integer> linenumbers;
	private String fileName;
	
	public WordRead(String word, String fileName) {
		super();
		this.word = word;
		this.fileName = fileName;
		this.linenumbers = new ArrayList<>();
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList<Integer> getLinenumbers() {
		return linenumbers;
	}
	public void setLinenumbers(int line) {
		this.linenumbers.add(line);
	}
	public String getFilename() {
		return fileName;
	}
	@Override
	public String toString() {
		return getWord() + ", " + getCount() + ", " + getFilename();
	}
	@Override
	public int compareTo(Object o) {
		if((((WordRead) o).getWord()).compareTo(word) == 0) {
			return 0;
		}else if((((WordRead) o).getWord()).compareTo(word) > 0)
			return 1; 
		else
			return -1;
	}
}
