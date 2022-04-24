package wordTracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import referenceBasedTreeImplementation.BSTReferencedBased;

public class WordTracker {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		BSTReferencedBased myBST = new BSTReferencedBased();
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
		
		File file = new File("res/textfile.txt");
		Scanner fileRead = new Scanner(file);

		
		while(fileRead.hasNext()) {
			String word = fileRead.next();
			myBST.add(word);
		}
		
	}
}
