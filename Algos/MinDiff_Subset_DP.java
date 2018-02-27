package com.karan.algos;

import java.io.*;
import java.util.*; 
public class MinDiff_Subset_DP {

	public static void main(String args[])throws Exception
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the no of elements in the set");
		
		int n=s.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		int result=minDiffSubset(arr,n);
		
		System.out.println("The minimum dfference in two sets is : " + result);
		
	}
	
	static int minDiffSubset(int arr[],int n)
	{
		int sum=0;
		int diff=0;
		
		for(int i=0;i<n;i++)
			sum+=arr[i];
		
		boolean dp[][]=new boolean[n+1][sum+1];
		
		for(int i=1;i<=n;i++)
			dp[i][0]=true;
		
		for(int i=1;i<=sum;i++)
			dp[0][i]=false;
		
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				dp[i][j]=dp[i-1][j];
				
				if(arr[i-1] <= j)
					dp[i][j] |=dp[i-1][j-arr[i-1]];
			}
		}
		
		for(int j=sum/2;j>=0;j--)
		{
			if(dp[n][j] == true)
			{
				diff=sum-(2*j);
				break;
			}
		}
		
		
		return diff;
	}
	
}

