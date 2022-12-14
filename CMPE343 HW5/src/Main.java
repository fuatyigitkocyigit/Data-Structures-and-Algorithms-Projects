//-----------------------------------------------------
// Title: Main Class
// Authors: Baris Sinapli / Fuat Yigit Kocyigit
// ID: 38039235216 / 16429085948
// Section: 1 / 2
// Assignment: 5
// Description: This class is the Main class of the Assignment 5.
//-----------------------------------------------------


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception {
		Locale.setDefault(new Locale("en"));
		Scanner userIn = new Scanner(System.in);
		// file path
		String filePath = userIn.nextLine().toLowerCase();
		
		String textContent = readFile(filePath, Charset.defaultCharset());
		textContent = textContent.replaceAll("\\p{Punct}", "");
		textContent = textContent.toLowerCase();
		String[] words = textContent.split(" ");

		TST<Integer> tst = new TST<Integer>();
		Integer num = 0;
		for(String word : words) {
			tst.put(word, num++);
		}	
		
		Functions functions = new Functions(tst);
		
		int command = userIn.nextInt();
		
		
		switch(command) {
		case 1:
			String searchWord = userIn.next().toLowerCase();
			boolean isExists = functions.Search(searchWord);
			if(isExists) System.out.println("True"); else System.out.println("False");
			break;
		case 2:
			String autoCompleteWord = userIn.next().toLowerCase();
			functions.autoComplete(autoCompleteWord);
			break;
		case 3:
			String reverseCompleteWord = userIn.next().toLowerCase();
			functions.reverseAutoComplete(reverseCompleteWord);
			break;
		case 4:
			String prefixToComplete = userIn.next().toLowerCase();
			String suffixToComplete = userIn.next().toLowerCase();
			functions.FullAutoComplete(prefixToComplete, suffixToComplete);
			break;
		case 5:
			int numberK = userIn.nextInt();
			functions.findTopK(numberK);
			break;
		case 6:
			String puzzlePath = userIn.nextLine().toLowerCase();
			functions.SolvePuzzle(puzzlePath);
			break;
		default:
			System.out.println("Invalid Command!");
			break;
		}
		
		
		userIn.close();

	}
	
	static String readFile(String path, Charset encoding)
			  throws IOException
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}

}
