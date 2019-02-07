import java.util.Scanner;

public class TriangleTester {
	public static boolean validSide(Double s) {
		if(s.compareTo(0.0)>0)
			return true;
		else {
			System.out.println("Value of side must be greater than 0");
			return false;
		}
	}
	
	public static boolean validTriangle(Double side1, Double side2, Double side3) {
		//Not a triangle if side length<=0 or sum of two sides are less than length of third side
		if(side1+side2<side3||side2+side3<side1||side1+side3<side2) {
			System.out.println("a");
			return false;
		}
		return true;
	}
	
	public static String typeOf(Double side1, Double side2, Double side3) {
		if(validTriangle(side1,side2,side3)&& side1.compareTo(side2)==0&&side1.compareTo(side3)==0&&side2.compareTo(side3)==0)	//Valid triangle and all sides equal
			return "Equilateral Triangle";
		else if(validTriangle(side1,side2,side3)&&side1.compareTo(side2)!=0&&side1.compareTo(side3)!=0&&side2.compareTo(side3)!=0)	//Valid Triangle and none of the sides are equal
			return "Scalene Triangle";
		else if(validTriangle(side1,side2,side3)&&((side1.compareTo(side2)==0&&side1.compareTo(side3)!=0||
				(side1.compareTo(side3)==0&&side1.compareTo(side2)!=0)||(side2.compareTo(side3)==0&&side2.compareTo(side1)!=0))))	//Valid triangle and exactly 2 sides are equal
			return "Isosceles Triangle";
		else
			return "Not a triangle";
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Double s1,s2,s3;
		
		//Set value for side 1,2,3
		while(true) {
			System.out.print("Enter length of first side: ");
			try {
				s1=Double.parseDouble(scan.nextLine());
				if(validSide(s1))
					break;
			}catch(NumberFormatException e){
				System.out.println("Error! Enter a numeric value for side.");
			}	
		}
		while(true) {
			System.out.print("Enter length of second side: ");
			try {
				s2=Double.parseDouble(scan.nextLine());
				if(validSide(s2))
					break;
			}catch(NumberFormatException e){
				System.out.println("Error! Enter a valid value for side.");
			}	
		}
		while(true) {
			System.out.print("Enter length of third side: ");
			try {
				s3=Double.parseDouble(scan.nextLine());
				if(validSide(s3))
					break;
			}catch(NumberFormatException e){
				System.out.println("Error! Enter a valid value for side.");
			}	
		}
		System.out.print(typeOf(s1,s2,s3));
		scan.close();
	}
}
