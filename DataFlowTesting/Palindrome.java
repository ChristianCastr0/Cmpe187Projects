import java.util.Scanner;
/**
 * Program that takes user input and checks if the 
 * work/phrase is a palindrome and returns result and length of string back to user
 * @author Christian Castro
 * @version 1.0 3/3/2019
 */
public class Palindrome {
	/**
	 * Method that checks if a string is a palindrome
	 * @param s String being analyzed
	 * @return boolean true or false
	 */
	public static boolean palindromeCheck(String s) {
		s=s.toLowerCase().replaceAll("[^A-Za-z]+", "");	//Remove all spaces from string and make all lettes lower case
		int len = s.length();	//Length of string or number of characters
		
		//Compare characters one by one from beginning to end and end to beginning
		for(int i=0;i<=len;i++) {
			if(s.charAt(i)==s.charAt(len-1)) {
				len--;
			}
			else
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input="";
		
		//Get user input and check if it is a palindrome then return length of input
		while(!input.equals("q")) {
			System.out.print("Enter a word/phrase (q to quit): ");
			input=scan.nextLine();
			if(palindromeCheck(input)) {
				System.out.println("This is a palindrome\nThe phrase is "+input.length()+" characters long.\n");
			}
			else
				System.out.println("The phrase entered is not a palindrome\n");
		}
		scan.close();
	}
}
