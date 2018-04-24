package com.karan.deshaw;

import java.io.*;
import java.util.*;

public class P1 {

	public static void main(String args[])throws IOException
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		long A[][]={{0,1,0,0,1},{1,0,1,0,0},{0,1,0,1,0},{0,0,1,0,1},{1,0,0,1,0}};
	
		while(t>0)
		{
			long n=s.nextLong();
			long res=matrixP(A,n);
			System.out.println(res%1000000007);
			t--;
		}
	}
	
	public static long matrixP(long base[][],long pow)
	{
		long ans[][]=new long[5][5];
		
		for(int i=0;i<5;i++)
			ans[i][i]=1;
		
		while(pow!=0)
		{
			if((pow & 1) != 0)
				ans=multiplyMatrix(ans,base);
			
			base=multiplyMatrix(base,base);
			
			pow>>=1;
			
		
		}
		return ans[0][0];
	}
	
	public static long[][] multiplyMatrix(long m[][],long m2[][])
	{
		long ans[][]=new long[5][5];
		
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
			{
				ans[i][j]=0;
				for(int k=0;k<5;k++)
				{
					ans[i][j] +=(m[i][k] * m2[k][j])%1000000007;
					ans[i][j]%=1000000007;
				}
			}
		return ans;
	}
}
