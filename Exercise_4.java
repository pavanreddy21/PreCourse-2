// Time Complexity : O(Nlog(N))
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

class MergeSort 
{ 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) 
    {  
       //Your code here  
       int len1 = m - l + 1;
       int len2 = r - m;
        
       int temp1[] = new int[len1];
       int temp2[] = new int[len2];
 
        for (int i = 0; i < len1; i++)
            temp1[i] = arr[l + i];
        for (int i = 0; i < len2; i++)
            temp2[i] = arr[m + 1 + i];
 
        int index1 = 0, index2 = 0;
        int pos = l;
        while (index1 < len1 && index2 < len2) {
            if (temp1[index1] <= temp2[index2]) {
                arr[pos++] = temp1[index1++];
            }
            else {
                arr[pos++] = temp2[index2++];
            }
        }
 
        while (index1 < len1) {
            arr[pos++] = temp1[index1++];
        }
 
        while (index2 < len2) {
            arr[pos++] = temp2[index2++];
        }
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
	//Write your code here
        //Call mergeSort from here 
        if (l < r) {
            int mid =l+ (r-l)/2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 