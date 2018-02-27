package com.karan.algos;

/* Program to convert String 1 to String 2 with minimum operations. 
 * Performance - O(m X n)  roughly n^2 complexity
 * Creator - Karan Khanna 
 * Tester - Karan Khanna
 * Created On - 27/02/2018
 * */
import java.io.*;
public class EditDistance_DP {

	public static void main(String args[])throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the strings");
		
		String str1=br.readLine();
		String str2=br.readLine();
		
		int cost=editDistance(str1,str2,str1.length(),str2.length());
		
		System.out.println("The cost to convert str1 -> str2 is : " + cost);
		
}
	static int editDistance(String s1,String s2,int x,int y)
	{
		int dp[][]=new int[x+1][y+1];
		
		for(int i=0;i<=x;i++)
		{
			for(int j=0;j<=y;j++)
			{
				if(i==0)
					dp[i][j]=j;
				
				else if(j==0)
					dp[i][j]=i;
				
				else if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				
				else
					dp[i][j] = 1 + min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]);
			}
		}
		return dp[x][y];
	}
	
	static int min(int a,int b,int c)
	{
		if(a<=b && a<=c)	return a;
   else if(b<=a && b<=c)	return b;
   else       				return c;
	}
}