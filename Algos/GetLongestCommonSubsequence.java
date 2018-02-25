package com.karan.algos;
import java.io.*;
import java.util.*;
public class GetLongestCommonSubsequence {
	
	static StringBuilder s=new StringBuilder();
	public static void main(String args[])throws Exception
	{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the strings to be compared");
		
		String s1=br.readLine();
		String s2=br.readLine();
		
		char a1[]=s1.toCharArray();
		char a2[]=s2.toCharArray();
		
		int m=a1.length;
		int n=a2.length;
		int lcs_len=lcs(a1,a2,m,n);
		
		System.out.println(lcs_len);
		System.out.println("Longest Common Subsequence is : " + s.reverse());
		
	}
	static int lcs(char s1[],char s2[],int a,int b)
	{
		
		int res[][]=new int[a+1][b+1];
		
		for(int i=0;i<=a;i++)
		{
			for(int j=0;j<=b;j++)
			{
				if(i==0 || j==0)
					res[i][j]=0;
				else if(s1[i-1] == s2[j-1])
					res[i][j] = res[i-1][j-1] + 1;
				else
					res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
			}
		}
		
		int x=a,y=b;	//Starting from last cell in 2D matrix
		
		while(x>0 && y>0)
		{
			if(s1[x-1] == s2[y-1]){				//Forming the lcs substring when match found
				s.append(s1[x-1]);
				x--;							// If match found move diagonally
				y--;
			}
			else if(res[x-1][y] > res[x][y-1]) 		//If match NOT found, move in the direction of larger available cell while movin backward in 2D res matrix
				x--;
			else
				y--;
		}
		
		return res[a][b];
	}
}
