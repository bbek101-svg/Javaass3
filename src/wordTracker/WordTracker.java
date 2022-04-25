package wordTracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import exceptions.TreeException;
import referenceBasedTreeImplementation.BSTReferencedBased;
import utilities.Iterator;
import utilities.WordRead;

public class WordTracker {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException, IOException, TreeException {
		BSTReferencedBased myBST = new BSTReferencedBased();
		BSTReferencedBased uniqueBST = new BSTReferencedBased();
		File serializedBST = new File("res/repository.ser");
		if(serializedBST.exists()) { 
			try {
                FileInputStream fileIn = new FileInputStream(serializedBST);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				myBST = (BSTReferencedBased)in.readObject();
			}catch(FileNotFoundException ex) {
				System.out.println("File Not Found like Bruh!!");
			}catch(ClassNotFoundException ex1) {
				System.out.println("BSTReferenced class not found");
			}
		}
		String fileName = "res/textfile.txt";
		boolean found = false;
		File file = new File(fileName);
		Scanner fileRead = new Scanner(file);
		int line = 1;
		
		int count = 1;
		while(fileRead.hasNext()) {
			//removing the punctuation
			String[] lineread = fileRead.nextLine().split(" ");
			
			for(int i = 0; i <lineread.length; i++) {
				String word = (lineread[i]).replaceAll("\\p{P}", "");
				if(word.trim().equals("")) {
					continue;
				}
				WordRead wordObj = new WordRead(word, fileName);
				wordObj.setLinenumbers(line);
				if(myBST.isEmpty()) {
					wordObj.setCount(count);
					myBST.add(wordObj);
				}else {
					Iterator it = myBST.inorderIterator();
					while(it.hasNext()) {
						
						WordRead alreadyRead = (WordRead)it.next();
						if((alreadyRead.getWord()).equals(wordObj.getWord())){
							
							count++;
							wordObj.setCount(count);
							System.out.println(count);
							found = true;
						}
					}
					if(!found) {
						wordObj.setCount(count);
						myBST.add(wordObj);

					}
				}
				found = false;
				count = 1;
			} 
			line++;
			
			
		}
		
		int word = 0;
		Iterator it1 = myBST.inorderIterator();
		while(it1.hasNext()) {
			WordRead read = (WordRead) it1.next();
//			System.out.println(read);
			
		}
		System.out.println(word);
		System.out.println(line);
		
		
	}
}
