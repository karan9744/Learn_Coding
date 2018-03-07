package com.karan.algos;

import java.io.*;
import java.util.Scanner;
public class DFS_BFS_Driver {

	public static void main(String args[])throws Exception
	{
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the number of vertices");
		
		int v=s.nextInt();
		Graph g=new Graph(v);
		
		System.out.println("Enter the no of edges.");
		
		int e=s.nextInt();
		
		System.out.println("Enter the edges.");
		
		for(int i=0;i<e;i++)
		{
			int v1=s.nextInt();
			int v2=s.nextInt();
			g.addEdge(v1, v2);
		}
		
		
		System.out.println("Enter the vertex from where you want to begin DFS.");
		int start=s.nextInt();
		
		g.DFS(start);
		
		System.out.println("Enter the vertex from where you want to begin BFS. ");
		
		int start1=s.nextInt();
		g.BFS(start1);
        
	}
}
