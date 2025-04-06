public class A4_MedianOfTwoSortedArray {
    //require for O(log(m+n))
    public static void main(String[] args) {
        
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        A4_MedianOfTwoSortedArray solution = new A4_MedianOfTwoSortedArray();
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + result);
        
        // Test case 2
        int[] nums1_2 = {1, 2}; 
        int[] nums2_2 = {3, 4};
        double result_2 = solution.findMedianSortedArrays(nums1_2, nums2_2);
        System.out.println("Median: " + result_2);
    }

    //Leetcode offical solution
    /* by finding median of both arrays
    * that is, the max of both left part should not be greater than the min of both right part
    * and by modify the median location to solve this problem
     */ 
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        double result = 0.0;

        //swap that make sure nums2 always >= nums1
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int totalLeft = (m + n + 1) / 2;

        //divide the array into two parts, left and right
        //left part is nums1[0..i] and nums2[0..j]
        int left = 0;
        int right = m;

        while(left < right){
            // i and j are the divide index
            int i = left + (right - left + 1) / 2; //nums1's divide index
            int j = totalLeft - i;  //nums2's divide index

            //specifying the correct index that obey the left parts always smaller than right parts.
            if(nums1[i - 1] > nums2[j]){ //if the nums1-left-index is larger than the nums2-right-index

                right = i - 1;   //move 1 nums2' divide index left

            }else{ //left <= right case 

                left = i; //if not left equals to next index
            }
        }
        //after iteration, left contains value that maximum sufficient median index

        int i = left;
        int j = totalLeft - i;

        //Ternary Operator that is used to check if the index is out of bound
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1]; //if i == 0, means nums1 left is empty
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];    // i = m means nums 1 right is empty
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1]; // same for nums2,  these Ternary operator are preventing extreme situation from not processing
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        //after finding array dividing, choose the correct median number
        if (((m+n)%2) ==1){
            result = Math.max(nums1LeftMax, nums2LeftMax);
            
        } else {
            result = (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
        }

        return result;
    }
}
