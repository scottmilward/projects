//	------				Scott Milward     			--------------------- //
//	------				3/31/13						--------------------- //
// 	------				Simple Mad Lib Program		--------------------- //
//-------------------------------------------------------------------------//
//-------------------------------------------------------------------------//


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MadLibs {

	private List<String> files = new ArrayList<String>();
	private List<String> placeholders = new ArrayList<String>();
	private int filesize;
	FinalWindow win = new FinalWindow();

	public MadLibs() {   //constructor that adds all the file names in the madlib folder into a list
		// get all madlib files in directory
		File folder = new File("MadLibFiles");
		File[] listOfFiles = folder.listFiles();
		filesize = listOfFiles.length;

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile())
				files.add(listOfFiles[i].getName());
		}

	}

	public String getMadLibTitle(int fileindex) { //returns titlename for the file
		String title = files.get(fileindex);
		return title;
	}

	public int getfilesize() {  //returns the number of files in the folder
		return filesize;
	}

	@SuppressWarnings("resource")
	public List<String> getPlaceholders(String filepath) {

		List<Character> charlist = new ArrayList<Character>();  //
		String s = "";
		String read = "";
		Scanner sc;
		try {
			sc = new Scanner(new File("MadLibFiles/" + filepath));
			while (sc.hasNext())
				read += sc.nextLine();      //read text in the file into string read

			for (int i = 0; i < read.length(); i++) {  //loops through each character in the text

				s = new String();

				if (read.charAt(i) == '(' && read.charAt(++i) == '(') {  //placeholder is found
					i++;
					while (read.charAt(i) != ')') {
						charlist.add(read.charAt(i));    //add placeholder text to a list
						i++;
					}

					for (char ch : charlist)
						s += ch;

					// clear array list
					charlist.clear();
					placeholders.add(s);

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return placeholders;

	}

	public void GenerateText(List<String> answers, String filepath) {

		List<Character> charlist = new ArrayList<Character>();
		Scanner sc;
		String read = "";
		int j = 0;
		try {
			sc = new Scanner(new File("MadLibFiles/" + filepath));

			while (sc.hasNext())
				read += sc.nextLine(); //adds text to string variable 


			for (int i = 0; i < read.length(); i++) {  //loop through all characters in read

				if (read.charAt(i) == '(' && read.charAt(++i) == '(') {
					while (read.charAt(i) != ')') {       //placeholder is found
						i++;
					}
					i++;
					char[] templist = answers.get(j).toCharArray();  //add user answer to a char arry
					j++;											 //variable to itererate to next answer
					for (char w : templist)
						charlist.add(w);

					charlist.add(' ');
				} 
				else
					charlist.add(read.charAt(i));

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FinalWindow.open(charlist);

	}
}
