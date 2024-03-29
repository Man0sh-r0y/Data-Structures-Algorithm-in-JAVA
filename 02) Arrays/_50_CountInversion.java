public class _50_CountInversion {

    public static void mergeSort(long[]arr, int start, int end, long[] count) {
        if(start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, count); // divide the left part
        mergeSort(arr, mid + 1, end, count); // divide the right part
        merge(arr, start, mid, end, count); // sort and merge the left and right part
    }

    public static void merge(long[] arr, int start, int mid, int end, long[] count) {
        long[] temp = new long[end - start + 1];// storing the long elements in the temp array
        int left = start; // left will point the starting point of the left part of the array
        int right = mid + 1; // right will point the starting point of the right part of the array
        int i = 0; // it will point to the starting point of the temp array

        while(left <= mid && right <= end) {// Two Polonger approach 
            if(arr[left] <= arr[right]) {
                temp[i++] = arr[left++];
            } else {
                temp[i++] = arr[right++];
                count[0] = count[0] + (mid - left + 1);
            }
        }

        // if there are left elements in the left part of the array
        while(left <= mid) {
            temp[i++] = arr[left++];
        }

        // if there are left any elements in the right part of the array
        while(right <= end) {
            temp[i++] = arr[right++];
        }

        int j = start; 

        // Rewrite the original array with the merged and sorted elements
        for(i=0; i<temp.length; i++) {
            arr[j++] = temp[i];
        }
    }

    public static long countInversion(long[] arr) {
        long[] count = new long[1]; // it will count the inversion. It will be stored at 0th index
        mergeSort(arr, 0, arr.length - 1, count);
        return count[0];
    }

    public static void main(String[] args) {
        long[] arr = new long[]{5, 3, 2, 1, 4};
        System.out.println(countInversion(arr));
    }
}
