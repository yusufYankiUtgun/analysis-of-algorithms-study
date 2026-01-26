public class MergeSort {

    public static void sort(int[] A) {
        int[] aux = new int[A.length]; //use just one big array instead of creating an array for every merge call
        sort(A, aux, 0, A.length - 1);
    }

    public static void sort(int[] A, int[] aux, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;

        sort(A, aux, low, mid);
        sort(A, aux, mid + 1, high);

        merge(A, aux, low, mid, high);
    }

    public static void merge(int[] A, int[] aux, int low, int mid, int high) {
        int p1 = low; //mid - low | high - mid + 1 | high - low + 1
        int p2 = mid + 1;

        int a = 0;

        for (int i = low; i <= high; i++) { //we fill the aux array, and we have high - low + 1 elements

            //with the help of these if statements we decide from which array we should get the next element for aux
            if (p1 > mid) { //no elements left in first array
                aux[a++] = A[p2++];
            } else if (p2 > high) { // no elements left in second array
                aux[a++] = A[p1++];
            } else if (A[p1] < A[p2]) {
                aux[a++] = A[p1++];
            } else {
                aux[a++] = A[p2++];
            }
        }

        a = 0;
        for(int i = low; i <= high; i++) {
            A[i] = aux[a++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 7 ,3 , 2, 5, 0, 7, 6, 10, 31, 91, 1, 100, 0};

        sort(arr);

        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}