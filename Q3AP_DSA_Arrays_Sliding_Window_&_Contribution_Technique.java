/*Problem Description

Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
We may assume that there is no overflow.



Problem Constraints

1 <= N <= 5 x 103


1 <= A[i] <= 1000

1 <= B <= 107




Input Format

First argument is an integer array A.

Second argument is an integer B.



Output Format

Return an integer denoting the number of subarrays in A having sum less than B.



Example Input

Input 1:

 A = [2, 5, 6]
 B = 10
Input 2:

 A = [1, 11, 2, 3, 15]
 B = 10


Example Output

Output 1:

 4
Output 2:

 4


Example Explanation

Explanation 1:

 The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
Explanation 2:

 The subarrays with sum less than B are {1}, {2}, {3} and {2, 3} */
public class Q3AP_DSA_Arrays_Sliding_Window_&_Contribution_Technique {
    public int solve(int[] A, int B) {
          /*
        //O(N^3)
        int N=A.length;
        int count_of_subarr_less_than_B=0;
        for(int i=0;i<N;i++)
        {
            for(int j=i;j<N;j++)
            {
                int sub_arr_sum=0;
                for(int k=i;k<=j;k++)
                {
                    sub_arr_sum+=A[k];
                }

                if(sub_arr_sum<B)
                    count_of_subarr_less_than_B++;

            }
        }

        return count_of_subarr_less_than_B;

        */
        
        //O(N^2)
        int N=A.length;
        int count=0;

        int[] pref=new int[N];
        pref[0]=A[0];
        for(int i=1;i<N;i++)
            pref[i]=pref[i-1]+A[i];

        int sum_of_subarr=0;

        for(int i=0;i<N;i++)
        {
            for(int j=i;j<N;j++)
            {
                if(i==0)
                    sum_of_subarr=pref[j];

                else
                    sum_of_subarr=pref[j]-pref[i-1];
                
                if(sum_of_subarr<B)
                    count++;
            }
        }

        return count;
    }
}
