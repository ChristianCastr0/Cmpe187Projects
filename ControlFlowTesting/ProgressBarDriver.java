import java.util.Scanner;

public class ProgressBarDriver {
	public static void main(String[] args) {
        ProgressBar progressBar = new ProgressBar();
        Scanner scan = new Scanner(System.in);
        String input; 

        System.out.print("Enter: [p]-Change progress [c]-Check color of a point\n");

        while(!(input=scan.nextLine()).equals("q")) {
            switch(input) {
                case "p":
                    System.out.println("Enter the circle progress: ");
                    float progress = scan.nextFloat();
                    progressBar.setProgress(progress);
                    break;
                case "c":
                    System.out.println("Enter the x coordinate: ");
                    float x = scan.nextFloat();
                    System.out.println("Enter the y coordinate: ");
                    float y = scan.nextFloat();
                    if(progressBar.isBlue(x, y)) {
                        System.out.println("Point is blue");
                    }
                    else{
                        System.out.println("Point is red");
                    }
                    break;
                default:
                    System.out.print("Enter: [p]-Change progress [c]-Check color of a point\n");
            }
        }
	}
}