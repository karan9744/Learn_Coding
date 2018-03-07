package com.karan.algos;

import java.util.LinkedList;
public class WeightedGraph {

	int V;
	LinkedList<Node> adjList[];
	
	WeightedGraph(int V)
	{
		this.V=V;
		
		for(int i=0;i<V;i++)
			adjList[i]=new LinkedList<Node>();
		
	}
	
	void addEdge(int u,Node v)
	{
		adjList[u].add(v);
		adjList[v.dest].add(new Node(u,v.weight));
	}
	
	
}
