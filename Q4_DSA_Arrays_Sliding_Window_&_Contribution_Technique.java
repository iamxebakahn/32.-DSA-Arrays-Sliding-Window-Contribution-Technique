/*Problem Description

Given an array A of length N, Find the maximum subarray sum out of all possible subarray of length B.


Problem Constraints

1 <= N <= 105
1 <= A[i] <= 106


Input Format

First argument A is an array of integers.
Second argument B is length of subarray.


Output Format

Return a single integer i.e. max subarray sum


Example Input

Input 1:

A = [6, 7, 8, 2]
B = 2
Input 2:

A = [3, 9, 5, 6, 5, 11]
B = 3


Example Output

Output 1:

15
Output 2:

22


Example Explanation

Explanation 1:

Subarray with maximum sum is [7, 8] with sum 15.
Explanation 2:

Subarray with maximum sum is [6, 5, 11] with sum 22. */
public class Q4_DSA_Arrays_Sliding_Window_&_Contribution_Technique {
    public long solve(int[] A, int B) {

        long sum=0;
        for(int i=0;i<B;i++)
            sum+=A[i];

        int start=1;
        
        int N=A.length;
        long temp=sum;

        while(B<N)
        {
            
            temp=temp+A[B]-A[start-1];
            sum=Math.max(temp,sum);

            start++;
            B++;
        }

        return sum;

    }
}
