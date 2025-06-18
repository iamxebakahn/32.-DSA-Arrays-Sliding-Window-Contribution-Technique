/*Problem Description

You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.


Problem Constraints

1 <= A <= 103
1 <= B <= 109
1 <= C[i] <= 106


Input Format

The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.


Output Format

Return a single integer which denotes the maximum sum.


Example Input

Input 1:
A = 5
B = 12
C = [2, 1, 3, 4, 5]
Input 2:

A = 3
B = 1
C = [2, 2, 2]


Example Output

Output 1:
12
Output 2:

0


Example Explanation

Explanation 1:
We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
Explanation 2:

All elements are greater than B, which means we cannot select any subarray.
Hence, the answer is 0.



Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases */
public class Q2_DSA_Arrays_Sliding_Window_&_Contribution_Technique {
    public int maxSubarray(int A, int B, int[] C) {
        //Taking brute force approach where TC: O(N^3)

        /* int ans=0;
        for(int i=0;i<A;i++)
        {
            for(int j=i;j<A;j++)
            {
                int subarray_sum=0;
                for(int k=i;k<=j;k++)
                {
                    subarray_sum=subarray_sum+C[k];
                }

                
                if(subarray_sum<=B)
                    ans=Math.max(ans,subarray_sum);



            }
        }

        return ans;
        */


        //Taking prefix sum array approach for TC:O(N^2)
        
        int[] prefix=new int[A];
        prefix[0]=C[0];
        for(int i=1;i<A;i++)
            prefix[i]=prefix[i-1]+C[i];


        
        int ans=0;

        for(int i=0;i<A;i++)
        {
            int sum=0;
            for(int j=i;j<A;j++)
            {
                if(i==0)
                    sum=prefix[j];
                
                else
                    sum=prefix[j]-prefix[i-1];


                if(sum<=B)
                ans=Math.max(ans,sum);

            }

            
        }

        return ans;
        

        
    }
}
