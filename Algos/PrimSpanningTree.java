package com.karan.algos;

import java.io.*;
import java.util.Scanner;

public class PrimSpanningTree {

	public static void main(String args[])throws Exception
	{
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the number of vertices.");
		int v=s.nextInt();
		
		System.out.println("Enter the number of edges.");
		int e=s.nextInt();
		
		WeightedGraph g=new WeightedGraph(v);
		for(int i=0;i<e;i++)
		{
			int x=s.nextInt();
			int y=s.nextInt();
			int weight=s.nextInt();
			
			g.addEdge(x, new Node(y,weight));
		}
		
		Prims(g,v);
		
	}
	
	static void Prims(WeightedGraph g,int v)
	{
		int parent[]=new int[v];
		
		int dist[]=new int[v];
		
		boolean visited[]=new boolean[v];
		
		
		for(int i=0;i<v;i++)
			dist[i]=Integer.MAX_VALUE;
		
		dist[0]=0;
		parent[0]=-1; 
		
		
		for(int i=0;i<v-1;i++)
		{
			int u=minDist(dist,visited,v);
			
			visited[u]=true;
			
			for(Node n : g.adjList[u])
			{
				if(!visited[n.dest] && n.weight < dist[n.dest])
				{
					parent[n.dest]=u;
					dist[n.dest]=n.weight;
				}
			}
			
			
		}
		
		
		printMST(parent,dist,v);
		
		
	}
	
	static int minDist(int dist[],boolean visited[],int v)
	{
		
		int min=Integer.MAX_VALUE;
		int min_index=-1;
		
		for(int i=0;i<v;i++)
		{
			if(!visited[i] && dist[i] < min)
			{
				min=dist[i];
				min_index=i;
			}
			
		}
		return min_index;
	}
	
	static void printMST(int parent[],int dist[],int v)
	{
		for(int i=1;i<v;i++)
			System.out.println(parent[i] + "  ->  " + i + "  " +	 dist[i]);
	}
	
}
