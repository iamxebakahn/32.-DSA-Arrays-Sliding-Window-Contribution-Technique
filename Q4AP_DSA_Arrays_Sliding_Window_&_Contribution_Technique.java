/*Problem Description

Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.


Problem Constraints

1 <= len(A) <= 5 x 103
1 <= A[i] <= 103
1 <= B <= 107


Input Format

The first argument given is the integer array A.
The second argument given is an integer B.


Output Format

Return the count of good subarrays in A.


Example Input

Input 1:
A = [1, 2, 3, 4, 5]
B = 4
Input 2:

A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
B = 65


Example Output

Output 1:
6
Output 2:

36


Example Explanation

Explanation 1:
Even length good subarrays = {1, 2}
Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5} 
Explanation 1:
There are 36 good subarrays */
public class Q4AP_DSA_Arrays_Sliding_Window_&_Contribution_Technique     {
    public int solve(int[] A, int B) {
        /*
        //Brute Force; TC: O(N^3)

        int N=A.length;
        int count_of_goodsub=0;
        for(int i=0;i<N;i++)
        {
            for(int j=i;j<N;j++)
            {
                int sub_arr_sum=0;
                int count=0;

                    for(int k=i;k<=j;k++)
                    {
                        sub_arr_sum+=A[k];
                        count++;
                    }

                if(count%2==0 && sub_arr_sum<B)
                {
                    count_of_goodsub++;
                }

                else if(count%2!=0 && sub_arr_sum>B)
                {
                    count_of_goodsub++;
                }
            }

        }


        return count_of_goodsub;
        */

        //O(N^2)

        int N=A.length;
        int[] pref=new int[N];
        pref[0]=A[0];
        for(int i=1;i<N;i++)
            pref[i]=pref[i-1]+A[i];

        int count_of_goodsub=0;
        int counter=0;
        int sum_of_subarr=0;
        for(int i=0;i<N;i++)
        {
            for(int j=i;j<N;j++)
            {
                if(i==0)
                    sum_of_subarr=pref[j];

                else
                    sum_of_subarr=pref[j]-pref[i-1];

                if(((j-i+1)%2==0) && (sum_of_subarr<B))
                    count_of_goodsub++;
                
                else if(((j-i+1)%2!=0) && (sum_of_subarr>B))
                    count_of_goodsub++;

            }
        }

        return count_of_goodsub;


        //TC: O(N)
    }
}
