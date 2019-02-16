import java.util.Scanner;
/**
 * Driver class to test functionality of LinkedList class
 * @author Christian Castro
 * @version 1.0	2/17/2019
 */
public class LinkedListDriver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList l = new LinkedList();
		String input;
		
		System.out.print("Enter: [a]-append [d]-delete [l]-length [e]-isEmpty [h]-Value of head\n");
		
		while(!(input=scan.nextLine()).equals("q")) {
			switch(input) {
			//Append new node to list
			case "a":
				System.out.print("Enter integer to append to linked list: ");
				int in1=scan.nextInt();
				scan.nextLine();
				l.append(new Node(in1));
				break;
			//Delete node from list
			case "d":
				System.out.print("Enter value to delete from list: ");
				int in2=scan.nextInt();
				scan.nextLine();
				System.out.println(l.delete(in2)+"\n");
				break;
			//Get length of list
			case "l":
				System.out.print("There are "+l.length()+" elements in the list.\n");
				break;
			//Check if list is empty
			case "e":
				if(l.isEmpty())
					System.out.println("List is empty!");
				else
					System.out.println("List is not empty!");
				break;
			//Get value of head
			case "h":
				if(l.getHead()!=null)
					System.out.println("The head of the list is "+l.getHead().value);
				else
					System.out.println("List is empty!");
				break;	
				
			default:
				System.out.println("");
			}
			System.out.println("Current contents of list: {"+l.contents()+"}\n");
			System.out.print("Enter: [a]-append [d]-delete [l]-length [e]-isEmpty [h]-Value of head\n");
		}
		System.out.print("Exit");
		scan.close();
	}
}
