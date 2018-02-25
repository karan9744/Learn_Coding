package com.karan.algos;
/* Computing Longest Common Subsequence using Dynamic Programming and building 
  	solution in a bottom up manner. 
 */
import java.io.*;
import java.util.*;

public class LongestCommonSubsequence {

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
		return res[a][b];
	}
}
