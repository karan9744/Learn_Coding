package com.karan.algos;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class FloydWarshal {

	public static void main(String args[])throws Exception
	{
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the number of vertices.");
		int v=s.nextInt();
		
		System.out.println("Enter the number of edges.");
		int e=s.nextInt();
		
		int [][] graph=new int[v][v];
		
		for(int i=0;i<v;i++)
			for(int j=0;j<v;j++)
			{
				if(i==j)
				{
					graph[i][j]=0;
					continue;
				}
				
				graph[i][j]=Integer.MAX_VALUE;
			}
				
		
		System.out.println("Enter the edges.");
		for(int i=0;i<e;i++)
		{
			int x=s.nextInt();
			int y=s.nextInt();
			int weight=s.nextInt();
			
			graph[x][y]=weight;
			graph[y][x]=weight;
		}
		
		floydWarshall(graph,v);
		
		printSol(graph,v);
		
	}
	
	static void floydWarshall(int[][] graph,int v)
	{
		for(int k=0;k<v;k++)
		{
			for(int i=0;i<v;i++)
			{
				for(int j=0;j<v;j++)
				{
					if(graph[i][k] + graph[k][j] < graph[i][j])
						graph[i][j] = graph[i][k] + graph[k][j];
				}
			}
		}
		
		
	}
	static void printSol(int[][] graph,int v)
	{
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(graph[i][j] == Integer.MAX_VALUE)
					System.out.print("INF ");
				else
				System.out.print(graph[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
}
