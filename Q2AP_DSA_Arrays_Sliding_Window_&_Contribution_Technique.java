/*Problem Description

Given an array A of size N, find the subarray of size B with the least average.



Problem Constraints

1 <= B <= N <= 105
-105 <= A[i] <= 105


Input Format

First argument contains an array A of integers of size N.
Second argument contains integer B.


Output Format

Return the index of the first element of the subarray of size B that has least average.
Array indexing starts from 0.


Example Input

Input 1:
A = [3, 7, 90, 20, 10, 50, 40]
B = 3
Input 2:

A = [3, 7, 5, 20, -10, 0, 12]
B = 2






Example Output

Output 1:
3
Output 2:

4






Example Explanation

Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average 
among all subarrays of size 3.
Explanation 2:

 Subarray between [4, 5] has minimum average */

public class Q2AP_DSA_Arrays_Sliding_Window_&_Contribution_Technique {
    public int solve(int[] A, int B) {
        int N=A.length;
        int min_sum=0;
        int sub_arr_avg=0;
        for(int i=0;i<B;i++)
            min_sum+=A[i];

        int start=1, end=B;
        int temp=min_sum;
        int i=0;

        while(end<N)
        {
            temp=temp-A[start-1]+A[end];
            if(min_sum>temp)
                {
                    min_sum=temp;
                    i=start;
                }

            start++;
            end++;

        }

        return i;

    }
}
