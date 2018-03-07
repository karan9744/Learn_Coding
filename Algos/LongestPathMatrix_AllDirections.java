package com.karan.algos;
import java.io.*;
import java.util.Scanner;

public class LongestPathMatrix_AllDirections {

	static int[] dx={-1,1,0,0};
	static int[] dy={0,0,-1,1};			//Modify these arrays to get the required directions
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
		if(n==0)
			return 0;
		int dp[][]=new int[n][n];
		int longest=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				longest=Math.max(longest, dfs(mat,i,j,dp,n));
			}
		}
		
		return longest;
	}
	
	static int dfs(int mat[][],int i,int j,int dp[][],int n)
	{
	
		if(dp[i][j]!=0)
			return dp[i][j];
		
		for(int k=0;k<4;k++)
		{
			int x=i+dx[k];
			int y=j+dy[k];
			
			if(x>=0 && y>=0 && x<n && y<n &&  mat[x][y] > mat[i][j])  //Modify last condition to obtain any desired result
				dp[i][j]=Math.max(dp[i][j], dfs(mat,x,y,dp,n));
			
		}
		return ++dp[i][j];
	}
}
