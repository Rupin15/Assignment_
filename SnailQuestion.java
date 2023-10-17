import java.util.Scanner;

public class SnailQuestion {

	public static void main(String[] args){ 
	 SnailQuestion();	    	 
    } 
	
	 public static void SnailQuestion() {
		 Scanner sc=new Scanner(System.in);
	     int feet=sc.nextInt();
	     int climbingSpeed=sc.nextInt();
	     int slidingSpeed=sc.nextInt();
	     System.out.println(snailTime(feet,climbingSpeed,slidingSpeed));
	     sc.close();
	 }
	 
	 public static int snailTime(int feet, int climbingSpeed, int slidingSpeed) {
		 int first= (feet-climbingSpeed)/(climbingSpeed-slidingSpeed);
		 return ++first;
	 }
	 
}
