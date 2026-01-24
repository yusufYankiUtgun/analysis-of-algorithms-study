public class InsertionSort {

    public static void sort (int[] A) {

        for (int i = 0; i < A.length - 1; i++) {
            int key = A[i + 1]; //left is sorted so we have to look at one index left
            int j = i; //not forget the original i value. We will use it to know form to which index our array is sorted

            //if key is smaller than the previous element move the previous element to the right to crate space for key
            while(j >= 0 && A[j] > key) { //when reached 0 stop there is nothing to sort anymore
                A[j + 1] = A[j];
                j--; // after the shift we will check if the current previous element (A[j - 1]) smaller
            }
            A[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int[] arr = {9, 7 ,3 , 2, 5, 7, 6, 10, 31, 91, 1, 100, 0};
        sort(arr);

        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}
