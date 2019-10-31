package alg.array;

public class SearchMedianFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = (m+n)/2;
        boolean needCalculate = (m+n)%2 == 0;
        
        return m <= n ? findKthSsortedArrarys(nums1, m, nums2, n, k, needCalculate)
            : findKthSsortedArrarys(nums2, n, nums1, m, k, needCalculate);
    }
	
	public double findMedianFromSortedArrarys(int[] nums1, int m, int[] nums2, int n, int k, boolean needCalculate) {
        int p = m;
        int q = k - p;
        
        
        while (true) {
            p--;
            q++;
        }
        
        
        
    }
    
    public double findKthSsortedArrarys(int[] nums1, int m, int[] nums2, int n, int k, boolean needCalculate) {
        int p = m;
        int q = k - p;
        while (p < m && q < n) {
            if (nums1[p] <= nums2[q]) {
                if (p < m - 1) {
                    if (nums1[p + 1] >= nums2[q]) {
                        if (needCalculate) {
                            return (nums1[p] + nums2[q]) / 2;
                        } else {
                            return nums2[q];
                        }
                    }
                } else {
                    if (needCalculate) {
                        return ((nums1[p] >= nums2[q-1] ? nums1[p] : nums2[q-1] ) + nums2[q]) / 2;
                    } else {
                        return nums2[q];
                    }
                }
                
                p++;
                q--; 
            } else {
                
            }
        }
        
        return 0;
    }
}
