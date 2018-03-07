package com.karan.algos;


import java.io.*;
import java.util.*;

public class FractionalKnapsack_Greedy {

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
			
		double result=GKP(n,wt,value,W);
		
		System.out.println("The maximum value of items in the sack is : " + (int)result);
		
	}
		
	static double GKP(int n,int wt[],int val[],int W)
	{
				
		Map map=new TreeMap(Collections.reverseOrder());
		
		for(int i=0;i<n;i++)
			map.put(new Double(val[i]/wt[i]), new Integer(wt[i]));
		
		Set<Map.Entry<Double,Integer>> set= map.entrySet();
		
		int cur_weight=0;
		double value=0.0;
		for(Map.Entry<Double, Integer> entry : set)
		{
			int x=entry.getValue();
			double vbw=entry.getKey();
			
			System.out.println(vbw + "--> " + x);
			if((cur_weight + x) <= W)
			{
				cur_weight+=x;
				value+= vbw*x;
				
				//System.out.println("Value till whole part taken - " + value);
			}
			else
			{
				//System.out.println("andar aaya h");
				int remain=W - cur_weight;
				//System.out.println("remains" + remain);
				//System.out.println("Weight left : " + vbw*x);
				value+= vbw * remain;
				
			}
		}
		return value;
		
	}
	
}
