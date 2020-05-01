package Sorting;

import java.util.Arrays;

public class QuickSort{


    /** Let's do int first.
     * Assumptions:
     * (left + right ) /2
     * [3, 10, 5, 6, 2, 8, 7, 9, 1, 0, 4]
    */
    /**
         * We have two markers '|' on the left and right end of the array,
         * Our aim is to put everything smaller than the pivotIndex to the left
         * and everything greater than the pivotIndex to the right.
         * For this purpose we will check every element to the right of the left marker
         * and iterate towards right
         * if it is smaller, keep it in place
         * if it is greater, jump to the right marker, and keep iterating to the left
         * from right to left when you find the value smaller than the pivotIndex swap it with left marker.
         * keep iterating from left again with the above same principle
         * D0,1
         * D2 --> Depth/Recursion Layers
         * D0
         * [|3, 10, 5, 6, 2, 4, 7, 9, 1, 0, |8]
         * [3, | 10, 5, 6, 2, 4, 7, 9, 1, 0, |8]
         * [3, | 10, 5, 6, 2, 4, 7, 9, 1, 0 |, 8]
         * swap
         * [3, 0 |, 5, 6, 2, 4, 7, 9, 1, | 10, 8]
         * [3, 0 , 5, 6, 2, 4, 7,| 9, 1, | 10, 8]
         * [3, 0 , 5, 6, 2, 4, 7,| 9, 1 |, 10, 8]
         * swap
         * [3, 0 , 5, 6, 2, 4, 7, 1 |, | 9, 10, 8]
         * when left marker is equal to the right marker
         * recursively call the left side and right side for arrangament
         * D1--->start left quickSort([3, 0 , 5, 6, 2, 4, 7, 1 |, | 9, 10, 8], left = 0, right = 7)
         * [3, 0 , 5, 6, 2, 4, 7, 1 |, | 9, 10, 8]
         * pivotIndex = (right - left)/2 + 1
         * pivotIndex = 5 ==> pivotElement = 4
         * swap it with the rightEnd = 1
         * [|3, 0 , 5, 6, 2, 1, 7, |4, | 9, 10, 8]
         * [3, 0 , | 5, 6, 2, 1, 7, |4, | 9, 10, 8]
         * [3, 0 , | 5, 6, 2, 1 |, 7, 4, | 9, 10, 8]
         * swap
         * [3, 0 , 1 |, 6, 2, | 5, 7, 4, | 9, 10, 8]
         * [3, 0 , 1 , | 6, 2, | 5, 7, 4, | 9, 10, 8]
         * [3, 0 , 1 , | 6, 2 |, 5, 7, 4, | 9, 10, 8]
         * swap
         * [3, 0 , 1 , 2 |, | 6 , 5, 7, 4, | 9, 10, 8]
         * left marker is equal to the right marker
         * D2---> start left quickSort([3, 0 , 1 , 2 |, | 6 , 5, 7, 4, | 9, 10, 8], left = 0, right = 3)
         * [|3, 0 , 1 , 2 |, | 6 , 5, 7, 4, | 9, 10, 8]
         * pivotIndex = (right - left + 1) / 2
         * pivotIndex = 2 ==> pivotElement = 1
         * swap it with the rightEnd = 2
         * [|3, 0 , 1 , |2 , | 6 , 5, 7, 4, | 9, 10, 8]
         * 3 is greater than 2
         * [|3, 0 , 1 |, 2 , | 6 , 5, 7, 4, | 9, 10, 8]
         * 1 is smaller than 2
         * swap
         * [1,| 0 , | 3 , 2 , | 6 , 5, 7, 4, | 9, 10, 8]
         * [1, 0 | , | 3 , 2 , | 6 , 5, 7, 4, | 9, 10, 8]
         * left marker is equal to the right marker
         * D3---> start left quickSort([1, 0 | , | 3 , 2 , | 6 , 5, 7, 4, | 9, 10, 8], left = 0, right = 1)
         * pivotIndex = (1 - 0 + 1)/2 = 1 ==> pivotElement = 0
         * swap it with the rightEnd ==> right end and marker are the same
         * [|1, | 0  , | 3 , 2 , | 6 , 5, 7, 4, | 9, 10, 8]
         * 1 is greater
         * jump to the right marker,
         * right marker equals to the left marker.
         * swap
         * [0 |, | 1  , | 3 , 2 , | 6 , 5, 7, 4, | 9, 10, 8]
         * left and right markers are the same get out of the loop and swicth to the right quicksort D3
         * D3---> start right quickSort([0, 1 , | 3 , 2 , | 6 , 5, 7, 4, | 9, 10, 8], left = 2, right = 3)
         * pivotIndex = (3 - 2 + 1)/2 = 1 ==> pivotElement = 2
         * swap it with the rightEnd ==> right end and marker are the same
         * [0 , 1, | 3 , | 2, | 6 , 5, 7, 4, | 9, 10, 8]
         * 3 is greater than 2
         * jump to right and iterate left
         * right and left marker are the same
         * swap
         * [0 , 1, 2 |, | 3, | 6 , 5, 7, 4, | 9, 10, 8]
         * left and right markers are equal get out of the loop
         * D2---> start right quickSort([0, 1 , 2 , 3 |, | 6 , 5, 7, 4, | 9, 10, 8], left = 4, right = 7)
         * pivotIndex = (left + right)/2  ==> 11/2 = 5.5 = 6 ==> pivotElement = 7
         * [0 , 1, 2 , 3, | 6 , 5, 7, 4|, | 9, 10, 8]
         * swap pivotElement with rightEndMarker 7 vs. 4
         * [0 , 1, 2 , 3, | 6 , 5, 4, | 7, | 9, 10, 8]
         * start from the left marker iterate right
         * [0 , 1, 2 , 3,  6 , 5, 4 |, | 7, | 9, 10, 8]
         * all elements are smaller than 7 and left and right marker are the same
         * D1--->start right quickSort([3, 0 , 5, 6, 2, 4, 7, 1 |, | 9, 10, 8], left = 8, right = 10)
         */

    public static int[] swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }

    public static int[] quickSort(int[] arr, int left, int right, int depth) {

        System.out.println("D"+depth);
        System.out.println(Arrays.toString(arr));

        if (left <  right){
            int pivotIndex = partition(arr, left, right);

            System.out.println("D"+depth + String.format("%"+ depth *2 +"s", "") + Arrays.toString(arr));
            arr = quickSort(arr, left, pivotIndex - 1, depth++);
            arr = quickSort(arr, pivotIndex + 1, right, depth++);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right) {

         // Pick the pivotIndex and pivotElement
         int pivotIndex = (left + right) / 2;
         int pivotElement = arr[pivotIndex];

         int leftMark = left;
         int rightMark = right - 1;

         // Set the pivotIndex at the right most end of the array partition
         arr = swap(arr, pivotIndex, right);

         while (leftMark <= rightMark){

             while (leftMark <= rightMark && arr[leftMark] <= pivotElement){
                leftMark++;
             }

             while (leftMark <= rightMark && arr[rightMark] >= pivotElement){
                rightMark--;
             }

             if (leftMark < rightMark){
                System.out.println("Before Swap\t: " + Arrays.toString(arr));
                arr = swap( arr, leftMark++, rightMark--);
                System.out.println("After Swap\t: " + Arrays.toString(arr));
             }
         }

         // This last swap is to put the pivotElement to the beginning of the existing partition, such that we can use it again.
         System.out.println("Before Swap\t: " + Arrays.toString(arr));
         arr = swap( arr, leftMark, right);
         System.out.println("After Swap\t: " + Arrays.toString(arr));
         return leftMark;

    }

    public static void main (String[] args){
        int[] arr = {3, 10, 5, 6, 2, 8, 7, 9, 1, 0, 4};
        int left = 0;
        int right = arr.length - 1;

        arr = quickSort(arr, left, right, 1);

    }

}
