package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MinSwaps {
	public static void main(String[] args){ 		 
    	minSwapsQuestion();   	 
    } 
	
	 public static void minSwapsQuestion() {
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   int[] a=new int[n];
	   for(int i=0;i<n;i++) {
	   	a[i]=sc.nextInt();
	   }
	   System.out.println(minSwaps(a, n));
	   sc.close();
	 }
	    
	 public static int minSwaps(int[] arr, int N) {
	  int numOfZeroes=0;
	  int minSwap=0;
	  for(int x: arr) {
		  if(x==0) {
			  numOfZeroes++;
		  }
	  }
	  for(int i=0;i<N;i++) {
		  if(i>numOfZeroes) break;
		  if(arr[i]==1) minSwap++;
	  }
	  return minSwap;
	 } 
}
