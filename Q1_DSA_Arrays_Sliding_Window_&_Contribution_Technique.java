/*Problem Description

You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.

Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes.



Problem Constraints

1 <= N <= 105
1 <= Ai <= 10 4


Input Format

The first argument is the integer array A.


Output Format

Return a single integer denoting the sum of all subarray sums of the given array.


Example Input

Input 1:
A = [1, 2, 3]
Input 2:

A = [2, 1, 3]


Example Output

Output 1:
20
Output 2:

19


Example Explanation

Explanation 1:
The different subarrays for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20
Explanation 2:

The different subarrays for the given array are: [2], [1], [3], [2, 1], [1, 3], [2, 1, 3].
Their sums are: 2 + 1 + 3 + 3 + 4 + 6 = 19 */
public class Q1_DSA_Arrays_Sliding_Window_&_Contribution_Technique {
    public long subarraySum(int[] A) {
        //Brute force
        /*
        int total_sum=0;
        for(int i=0;i<A.length;i++)
        {
            for(int j=i;j<A.length;j++)
            {
                for(int k=i;k<=j;k++)
                {
                    total_sum+=A[k];
                }
            }
        }

        return total_sum;
        */

        //O(N^2)
        /*
        int[] prefix_sum=new int[A.length];
        prefix_sum[0]=A[0];
        for(int i=1;i<A.length;i++)
        {
            prefix_sum[i]=prefix_sum[i-1]+A[i];
        }

        int total_sum=0;
        for(int i=0;i<A.length;i++)
        {
            int sum=0;
            for(int j=i;j<A.length;j++)
            {
                if(i==0)
                    sum=prefix_sum[j];

                else
                    sum=prefix_sum[j]-prefix_sum[i-1];
            
                total_sum+=sum;
            }
        }

        return total_sum;

        */

        //O(N)

        long all_sub_array_sum=0;
        int N=A.length;

        for(int i=0;i<N;i++)
        {
            long freq=(long)(i+1)*(N-i);
            all_sub_array_sum+=freq*A[i];
        }

        return all_sub_array_sum;

    }
}
