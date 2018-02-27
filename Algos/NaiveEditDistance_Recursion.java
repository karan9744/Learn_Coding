package com.karan.algos;
/* Program to convert String 1 to String 2 with minimum operations. 
 * Performance - Exponential in Worst Case Scenario O(3^M)
 * Creator - Karan Khanna 
 * Tester - Karan Khanna
 * Created On - 27/02/2018
 * */
import java.io.*;
import java.util.*;
public class NaiveEditDistance_Recursion {

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
		if(x==0)
			return y;
		
		if(y==0)
			return x;
		
		if(s1.charAt(x-1) == s2.charAt(y-1))
			return editDistance(s1,s2,x-1,y-1);
		 
			return 1 + min(editDistance(s1,s2,x,y-1),
						   editDistance(s1,s2,x-1,y),
						   editDistance(s1,s2,x-1,y-1));
	}
	
	static int min(int a,int b,int c)
	{
		if(a<=b && a<=c)	return a;
   else if(b<=a && b<=c)	return b;
   else       				return c;
	}
}
