package com.karan.algos;

import java.io.*;
import java.util.*;
public class FindLongestPathInMatrix {
	
	public static void main(String args[])throws Exception
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the dimension of the matrix.");
		int n=s.nextInt();
		
		System.out.println("Enter the matrix!");
		
		int mat[][]=new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				mat[i][j]=s.nextInt();
			}
		}
		
		int outi=findMaxPath(mat,n);
		
		System.out.println("The max path is of length : " + outi);
		
		
	}
	
	static int findMaxPath(int mat[][],int n)
	{
		
		int answer;
		int dp[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				dp[i][j]=-1;
			}
		}
		
		answer=findLongestFromCell(0,0,mat,dp,n);
		
		return answer;
		
	}
	static int findLongestFromCell(int i,int j,int mat[][],int dp[][],int n)
	{
		if(dp[i][j] < 0)
		{
			
			int result=0;
			 
			if(i==n-1 && j==n-1)
				return dp[i][j]=1;
			
			if(i==n-1 || j==n-1)
				result=1;
		
		if(i+1 < n && mat[i][j] <	mat[i+1][j])
			result = 1 + findLongestFromCell(i+1,j,mat,dp,n);
		
		if(j+1 < n && mat[i][j] <	mat[i][j+1])
			result =	Math.max(result, 1 + findLongestFromCell(i,j+1,mat,dp,n));
		
		dp[i][j]=result;
				
		}
		return dp[i][j];
	}
	

}
