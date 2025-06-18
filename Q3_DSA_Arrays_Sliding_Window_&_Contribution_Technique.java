/*Problem Description

Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having sum C and 0 otherwise



Problem Constraints

1 <= N <= 105

1 <= A[i] <= 104

1 <= B <= N

1 <= C <= 109



Input Format

First argument A is an array of integers.

The remaining arguments B and C are integers



Output Format

Return 1 if such a subarray exist and 0 otherwise


Example Input

Input 1:


A = [4, 3, 2, 6, 1]
B = 3
C = 11
Input 2:

A = [4, 2, 2, 5, 1]
B = 4
C = 6




Example Output

Output 1:
1
Output 2:

0


Example Explanation

Explanation 1:


The subarray [3, 2, 6] is of length 3 and sum 11.


Explanation 2:


There are no such subarray.


 */
public class Q3_DSA_Arrays_Sliding_Window_&_Contribution_Technique {
    public int solve(int[] A, int B, int C) {
         /* 
        //TC O(N) and SC O(N)
        int N=A.length;
        int[] pref=new int[N];
        pref[0]=A[0];

        for(int i=1;i<N;i++)
            pref[i]=pref[i-1]+A[i];
        
        int start=0, end=B-1;
        int sum=0;
       
       while(end<N)
       {
          if(start==0)
            sum=pref[end];
          else
            sum=pref[end]-pref[start-1];
           if(sum==C)
                return 1;

           start++;
           end++;
       }

       return 0;
       */

        //TC: O(N) and SC: O(1)
        int sum=0;
        for(int i=0;i<B;i++)
            sum+=A[i];

        int start=0, end=B-1;
        int N=A.length;
        

        while(end<N)
        {
            if(sum==C)
                return 1;
            else
                sum=sum+A[end]-A[start];

            start++;
            end++;
        }

        return 0;


        
    }
}
