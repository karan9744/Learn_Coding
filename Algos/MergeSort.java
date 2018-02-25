package com.karan.algos;
import java.io.*;

public class MergeSort {

	
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] inp=br.readLine().split(" ");
		
		int arr[]=new int[inp.length];
		
		System.out.println("Unsorted Array : ");
		
		for(int i=0;i<inp.length;i++){
			arr[i]=Integer.parseInt(inp[i]);
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
			
				Sort(arr,0,inp.length-1);
		//Display the sorted contents
				System.out.println("Sorted Array : ");
				for(int i=0;i<arr.length;i++)
					System.out.print(arr[i] + " ");
	
				System.out.println("\nEnd of Program");
	}
	
	public static void Sort(int arr[],int l,int r)
	{
		if(l < r)
		{
			int mid= (l+r) /2;
			
			Sort(arr,l,mid);
			Sort(arr,mid+1,r);
			
			merge(arr,l,mid,r);
		}
	}
	
	public static void merge(int arr[],int l,int m,int r)
	{
		int n1=m-l+1;
		int n2=r-m;
		
		int L[]=new int[n1];
		int R[]=new int[n2];
		
		for(int i=0;i<n1;i++)
			L[i]=arr[l+i];
		for(int j=0;j<n2;j++)
			R[j]=arr[m+1+j];
		
		
		int i=0,j=0;
		
		int k=l;
		
		while(i<n1 && j<n2)
		{
			if(L[i] < R[j])
			{
				arr[k]=L[i];
				i++;
			}
			else
			{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		
		while(i<n1)
		{
			arr[k]=L[i];
			i++;
			k++;
		}

		while(j<n2)
		{
			arr[k]=R[j];
			j++;
			k++;
		}
	}
}

