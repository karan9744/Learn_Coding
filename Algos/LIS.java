package com.karan.algos;
import java.io.*;
import java.util.*;

public class LIS {

	public static void main(String args[])throws Exception
	{
		Scanner s=new Scanner(System.in);
		
		int N=s.nextInt();
		int arr[]=new int[N];
		
		for(int i=0;i<N;i++)
		{
			arr[i]=s.nextInt();
		}
		
		int lis_count=lis(arr,N);
		
		System.out.println("Longest Increasing Subsequence is of length : " +lis_count );
	}
	
	public static int lis(int arr[],int n)
	{
		int lis[]=new int[n];
		
		for(int i=0;i<n;i++)
			lis[i]=1;
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(arr[j] < arr[i] && lis[i] < lis[j] + 1)
					lis[i]=lis[j]+1;
			}
		}
		int max=lis[0];
		
		for(int i=1;i<n;i++)
		{
			if(lis[i] > max)
				max=lis[i];
		}
		return max;
	}
	
}
