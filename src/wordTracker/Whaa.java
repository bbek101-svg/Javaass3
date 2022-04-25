package wordTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import utilities.WordRead;

public class Whaa {
	public static void main(String[] args) throws FileNotFoundException {
String fileName = "res/textfile.txt";
		
		File file = new File(fileName);
		Scanner fileRead = new Scanner(file);
		int line = 1;
		int words = 0;
		while(fileRead.hasNextLine()) {
			//removing the punctuation
			String[] lineread = (fileRead.nextLine().split(" "));
		
			for(int i = 0; i <lineread.length; i++) {
				
				String word = (lineread[i]).replaceAll("\\p{P}", "");
				if(word.trim().equals("")) {
					continue;
				}
				System.out.println(word);
				words++;
			}
			line++;
			
		}
		System.out.println(line);
		System.out.println(words);
		}
	
}
