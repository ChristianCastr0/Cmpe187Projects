import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that simulates the tower of hanoi game
 * @author Christian Castro
 * @version 1.0	2/24/2019
 */
public class TowerHanoi {
	/**
	 * Inner class that represents a rod on the board used for the Tower of Hanoi
	 * @author Owner
	 *
	 */
	public static class Rod{
		public String name;	//Name to differentiate each rod
		public ArrayList<Integer> rod;	//Array list that holds integers that represent disks
		
		public Rod(String name) {
			this.name=name;
			rod = new ArrayList<Integer>();
		}
		
		/**
		 * Returns the values inside of the array list
		 * @return String containing values of array list
		 */
		public String contents() {
			String s="";
			if(rod.size()>0) {
				for(int i=0;i<rod.size();i++) {
					s+=rod.get(i).toString()+" ";
				}
			}
			return s;
		}
	}
	
	/**
	 * Recursive method that solves the Tower of Hanoi
	 * @param numDisks	Number of disks used in the game
	 * @param source	Rod that disk is being removed from
	 * @param other		Rod that is not being interacted with on the current turn
	 * @param destination	Rod that the disk being taken from the source is being placed
	 */
	public static void solve(int numDisks, Rod source, Rod other, Rod destination) {
		if(numDisks==1) {
			destination.rod.add(source.rod.get(source.rod.size()-1));	//Add disk at the top of source rod to destination rod
			source.rod.remove(source.rod.size()-1);	//Remove disk taken out, from source rods array list
			
			System.out.print(source.name+"->"+ destination.name+": \n\t"+source.name+": "+source.contents()+"\n\t"+
					other.name+": "+other.contents()+"\n\t"+destination.name+": "+destination.contents()+"\n\n");
		}
		else {
			solve(numDisks-1, source, destination, other);	//Recursively move on to the net rod
			
			destination.rod.add(source.rod.get(source.rod.size()-1));
			source.rod.remove(source.rod.size()-1);
			
			System.out.print(source.name+"->"+ destination.name+": \n\t"+source.name+": "+source.contents()+"\n\t"+
					other.name+": "+other.contents()+"\n\t"+destination.name+": "+destination.contents()+"\n\n");
			
			solve(numDisks-1,other, source, destination);
		}
	}
	
	public static void main(String[] args) {
		//Create the 3 rods that are on the board
		Rod rod1=new Rod("Rod1");
		Rod rod2=new Rod("Rod2");
		Rod rod3=new Rod("Rod3");
		
		//Take user input for the number of disks they want to use for the game 
		Scanner scan = new Scanner(System.in);
		int disks = 0;
		//Ensure that a positive numeric value is entered 	
		while(true) {
			System.out.print("Enter number of disk for tower: ");
			try {
				disks= Integer.parseInt(scan.nextLine());
				if(disks>0 && disks<=15) {	//Due to excessive runtimes limit range of disks
					break;
				}
				else
					System.out.println("Enter a value greater than 0 and less than or equal to 15");
			}catch(NumberFormatException e){	//Handle for a non numeric input
				System.out.println("Error! Enter a valid integer.");
				
			}	
		}
		
		//Add disks to first rod
		for(int i=1;i<=disks;i++) {
			rod1.rod.add(i);
		}
		
		solve(disks,rod1,rod2,rod3);
		scan.close();
	}
}
