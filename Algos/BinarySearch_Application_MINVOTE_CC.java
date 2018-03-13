/*
Created by :Karan Khanna
Dated - 13/03/2018
Problem Name - MINVOTE
Codechef March Long Contest

Problem Statement :

There are N minions who are competing in an election of the president of the ACM (Association of Cute Minions). They are standing in a line in the order from minion 1 to minion N. For each i (1 ≤ i ≤ N), the i-th minion has an influence level of Si.

A single minion may cast any number of votes. Minion j will vote for minion i (i ≠ j) if and only if the influence level of the j-th minion is greater than or equal to the sum of influence levels of all the minions standing between them (excluding the i-th and j-th minion).

Your task is to find the number of votes received by each minion.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the number of minions.
The second line contains N space-separated integers S1, S2, ..., SN.
Output
For each test case, print a single line containing N space-separated integers. For each valid i, the i-th of these integers should denote the number of votes the i-th minion will get.

Constraints
1 ≤ T ≤ 105
1 ≤ N ≤ 105
1 ≤ Si ≤ 109 for each valid i
sum of N over all test cases won't exceed 106
Subtasks
Subtask #1 (30 points):

1 ≤ N ≤ 500
sum of N over all test cases won't exceed 10,000
Subtask #2 (70 points): original constraints

Example
Input:

2
4
4 3 2 1
5
1 2 2 3 1

Output:

1 2 3 2
2 3 2 3 1

High Level Algo Used :

1. Compute sum of influence (generate Sum Array step)
2. For each element find the range in the array in which it can vote using the Binary Search Technique
3. Mark the range using the counting array with range as arr[start_range]+=1 and arr[end_range+1]-=1. Keep boundaries in mind.
4. Count the vote each minion gets by simply parsing and summing up the count array.
5. Print the result.

*/

package com.karan.algos;
import java.io.*;
public class BinarySearch_Application_MINVOTE_CC {

    private static long sumArray[];
 
    private static int totalVotes[];
 
    private static void generateSumArray(int array[],int size)
    {
        sumArray = new long[size];
 
        sumArray[0] = array[0];
 
        for(int i = 1;i < size;i++)
        {
            sumArray[i] = sumArray[i-1] + array[i];
        }
    }
 
    private static int binarySearchOnLeft(int low,int high,int array[],int value,int index)
    {
        if(low < high)
        {
            int mid = low + (high - low)/2;
 
            long sum = sumArray[index] - sumArray[mid] - value;
 
            if(value >= sum)
            {
                return binarySearchOnLeft(low,mid,array,value,index);
            }
            else
            {
                return binarySearchOnLeft(mid+1,high,array,value,index);
            }
        }
 
        return low;
    }
 
    private static int binarySearchOnRight(int low,int high,int array[],int value,int index)
    {
        if(low < high)
        {
            int mid = low + (high - low + 1)/2;
 
            long sum = sumArray[mid] - sumArray[index] - array[mid];
 
            if(value >= sum)
            {
                return binarySearchOnRight(mid,high,array,value,index);
            }
            else
            {
                return binarySearchOnRight(low,mid-1,array,value,index);
            }
        }
 
        return low;
    }
 
    private static StringBuilder countVotes(int array[],int size)
    {
        totalVotes = new int[size];
 
        StringBuilder result = new StringBuilder();
 
        for(int i = 0;i < size;i++)
        {
            if(i == 0)
            {
                int index = binarySearchOnRight(i+1,size-1,array,array[i],i);
 
                if(i != size-1)
                   totalVotes[i+1] += 1;
                
                if(i != size-1 && index != size-1)
                    totalVotes[index+1] -= 1;
            }
            else if(i == size-1)
            {
                int index = binarySearchOnLeft(0,i-1,array,array[i],i);
 
                totalVotes[index] += 1;
 
                totalVotes[i] -= 1;
            }
            else
            {
                int leftIndex = binarySearchOnLeft(0,i-1,array,array[i],i);
                int rightIndex = binarySearchOnRight(i+1,size-1,array,array[i],i);
 
                totalVotes[leftIndex] += 1;
                totalVotes[i] -= 1;
 
                totalVotes[i+1] += 1;
 
                if(rightIndex != size-1)
                    totalVotes[rightIndex+1] -= 1;
            }
        }
 
        result.append(totalVotes[0] + " ");
 
        for(int i = 1;i < size;i++)
        {
            totalVotes[i] = totalVotes[i] + totalVotes[i-1];
 
            result.append(totalVotes[i] + " ");
        }
 
        return result;
    }
 
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
 
        int t = Integer.parseInt(br.readLine());
 
        while(t > 0)
        {
            int size = Integer.parseInt(br.readLine());
 
            String data[] = br.readLine().split(" ");
 
            int array[] = new int[size];
 
            for(int i = 0;i < size;i++)
            {
                array[i] = Integer.parseInt(data[i]);
            }
 
            generateSumArray(array,size);
 
            output.append(countVotes(array,size)).append("\n");
            
            t--;
        }
 
        System.out.println(output.toString());
        
    }
} 

