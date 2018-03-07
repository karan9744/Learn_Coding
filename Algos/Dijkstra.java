package com.karan.algos;

import java.io.*;
import java.util.*;
public class Dijkstra {

	
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
		
		dijkstra(g,0,v);
		
	}
	
	static void dijkstra(WeightedGraph g,int src,int v)
	{
		int dist[]=new int[v];
		boolean visited[]=new boolean[v];
		
		for(int i=0;i<v;i++)
		{
			dist[i]=Integer.MAX_VALUE;
			visited[i]=false;
		}
			
		dist[src]=0;
		
		
		for(int i=0;i<v-1;i++)
		{
			int u=minDist(dist,visited,v);
			
			visited[u]=true;
			
			for(Node n : g.adjList[u])
			{
				if(!visited[n.dest] && dist[u] !=Integer.MAX_VALUE 
						&& dist[u] + n.weight < dist[n.dest])
					dist[n.dest]=dist[u] + n.weight;
				
			}
			
			
		}
		
		printSolution(dist,v);
		
	}
	
	static int minDist(int dist[],boolean visited[],int v)
	{
		int min=Integer.MAX_VALUE;
		int min_index=-1;
		
		for(int i=0;i<v;i++)
		{
			if(!visited[i] && dist[i] <= min)
			{
				min=dist[i];
				min_index=i;
			}
		}
		
		return min_index;
	}
	static void printSolution(int dist[],int v)
	{
		for(int i=0;i<v;i++)
			System.out.println(i + " - > " + dist[i]);
		
	}
	
	
}
