import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args){
        InsertionSort is = new InsertionSort();
        int[] arr1 = {5,2,4,6,1,3};
        System.out.println("original arr1: " + Arrays.toString(arr1));
        is.sortAscending(arr1);
        is.sortDescending(arr1);
    }

    public int[] sortAscending(int[] arr){
        if (arr.length == 0){
            return null;
        }
        if (arr.length == 1){
            return arr;
        }

        for (int j = 1; j < arr.length ; j++){
            int key = arr[j];
            int i = j-1;

            while (i >= 0 && arr[i] > key){
                arr[i+1] = arr[i];
                i = i-1;
            }
            arr[i+1] = key;
        }
        System.out.println("Ascending Insertion Sort: " + Arrays.toString(arr));
        return arr;
    }

    public int[] sortDescending(int[] arr){
        if (arr.length == 0){
            return null;
        }
        if (arr.length == 1){
            return arr;
        }

        for (int j = 1; j < arr.length; j++){
            int key = arr[j];
            int i = j-1;
            while (i >= 0 && arr[i] < key){
                arr[i+1]=arr[i];
                i = i-1;
            }
            arr[i+1]=key;
        }
        System.out.println("Descending Insertion Sort: " + Arrays.toString(arr));
        return arr;
    }
}
