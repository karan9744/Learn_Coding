package com.karan.algos;
import java.io.*;
import java.util.*;

public class BinarySearch {
	
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the array");
		
		String arr[]=br.readLine().split(" ");
		
		ArrayList<Integer> array=new ArrayList<>();
		
		for(int i=0;i<arr.length;i++)
				array.add(Integer.parseInt(arr[i]));
		
		Collections.sort(array);
		
		System.out.println("Enter the number to be searched");
		
		int query=Integer.parseInt(br.readLine());
		
		int pos=Binary_Search(array,0,array.size(),query);
		
		if(pos==-1)
			System.out.println("Element Not Found my Fried!");
		else
			System.out.println("Element Found at : " + pos);
		
	}
	
	
	public static int Binary_Search(ArrayList<Integer> array,int start, int end, int query)
	{
		int mid=(start + end) /2;
		int cur=array.get(mid);
		
		if(start > end)
			return -1;
		else if(query < cur) return Binary_Search(array,start,mid-1,query);
		else if(query > cur) return Binary_Search(array,mid+1,end,query);
		else 
			return mid;
			
			
	}
}
