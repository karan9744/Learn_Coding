package com.karan.algos;
	
import java.util.*;
public class Graph {
	
	private int V;
	private LinkedList<Integer> adjList[];
	
	Graph(int v)
	{
		V=v;
		adjList=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adjList[i]=new LinkedList();
		}
		
	}
	
	void addEdge(int v,int w)
	{
		adjList[v].add(w);
	}
	
	void BFS(int s)
	{
		boolean visited[]=new boolean[V];
		
		LinkedList<Integer> queue=new LinkedList<Integer>();
		
		visited[s]=true;
		queue.add(s);
		
		while(queue.size() != 0)
		{
			s=queue.poll();
			System.out.println(s+ " ");
			
			Iterator<Integer> i=adjList[s].listIterator();
			
			while(i.hasNext())
			{
				int n=i.next();
				if(!visited[n])
				{
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
	
	void DFS(int v)
	{
		boolean visited[]=new boolean[V];
		
		DFSUtil(v,visited);
	}
	
	private void DFSUtil(int v,boolean visited[])
	{
		visited[v]=true;
		System.out.println(v + " ");
		
		Iterator<Integer> i=adjList[v].listIterator();
		
		while(i.hasNext())
		{
			int n=i.next();
			if(!visited[n])
				DFSUtil(n,visited);
		}
		
	}

}
