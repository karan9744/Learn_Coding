/* Created by - Karan Khanna
 * Progream - 0-1 Knapsack Problem
 * Complexity - O(nW)
 *  */


package com.karan.algos;

import java.io.*;
import java.util.*;
public class Knapsack_DP {

	public static void main(String args[])throws Exception
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the no of elements.");
		
		int n=s.nextInt();
		
		int wt[]=new int[n];
		int value[]=new int[n];
		
		System.out.println("Enter the weight of n elements.");
		
		for(int i=0;i<n;i++)
			wt[i]=s.nextInt();
		
		System.out.println("Enter the value of n elements. ");
		
		for(int j=0;j<n;j++)
			value[j]=s.nextInt();
		
		System.out.println("Enter the maximum weight allowed in the sack.");
			
			int W=s.nextInt();
			
		int result=KP(n,wt,value,W);
		
		System.out.println("The maximum value of items in the sack is : " + result);
		
	}
	
	
	static int KP(int n,int wt[],int val[],int W)
	{
		int kp[][]=new int[n+1][W+1];
		
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=W;j++)
			{
				
				if(i==0 || j==0)
					kp[i][j]=0;
				
				else if(wt[i-1] <= j)
					kp[i][j]=Math.max(val[i-1] + kp[i-1][j - wt[i-1]], kp[i-1][j]);
				
				else
					kp[i][j]=kp[i-1][j];
			}
		}
		return kp[n][W];
	}
}
