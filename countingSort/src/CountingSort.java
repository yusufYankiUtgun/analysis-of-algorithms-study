public class CountingSort {

    public static int[] sort(int[] A, int k) {
        int[] B = new int[A.length];
        int[] C = new int[k + 1];

        // store the occurrences of each value in C
        for (int i = 0; i < A.length; i++) {
            C[A[i]]++;
        }

        // calculate the rank of every integer's last occurrence
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }

        // put the integers from A to B according to their ranks
        // decrease rank for every integer has been put
        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i]] - 1] = A[i]; // C[A[i]] - 1 converts the 1 based rank to 0 based array indexing
            C[A[i]]--;
        }

        return B;
    }

    public static void main(String[] args) {

        int[] arr = {9, 7, 3, 2, 5, 7, 6, 10, 31, 91, 1, 100, 0, 0, 1, 31, 92, 31, 0, 0};
        int[] sorted = sort(arr, 100);

        for (int num: sorted) {
            System.out.print(num + " ");
        }
    }
}
