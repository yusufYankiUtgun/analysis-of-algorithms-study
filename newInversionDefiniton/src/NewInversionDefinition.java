public class NewInversionDefinition {
    public static int findNumberOfInversions(int[] A, int[] B) {
        int[] aux = new int[B.length]; //used B's length because we are sorting and merging the array B
        int[] lookup = new int[1000000];

        for (int i = 0; i < A.length; i++) {
            lookup[A[i]] = i + 1; //create lookup table in case of unsorted array A
        }

        int[] newB = new int[B.length]; //create new array to not overwrite B array

        for (int i = 0; i < B.length; i++) {
            newB[i] = lookup[B[i]]; //decide the numbers of the elements from lookup table
        }

        return findNumberOfInversions(newB, aux, 0, B.length - 1); //passed B's length
    }

    public static int findNumberOfInversions(int[] B, int[] aux, int low, int high) {
        if (low >= high) {
            return 0; //array size of one cannot have any inversions
        }
        int mid = (low + high) / 2;

        int h1 = findNumberOfInversions(B, aux, low, mid); //inversions from the first half
        int h2 = findNumberOfInversions(B, aux, mid + 1, high); //inversions from second half

        int t = merge(B, aux, low, mid, high); //occurred inversions from the merge of first and second half

        return h1 + h2 + t;
    }

    public static int merge(int[] A, int[] aux, int low, int mid, int high) {

        int total = 0;
        int rightCounter = mid + 1;

        // for each element in the first array compare with the doubles of the elements of second array
        for (int i = low; i <= mid; i++) {

            // find inversion number for each element at the index i of first array
            while (rightCounter <= high && A[i] > 2 * A[rightCounter]) {
                rightCounter++;
            }
            // as A[i] is greater than its predecessor A[i-1]
            // it must also be greater than any element A[i-1] was already compared to
            // so we don't reset 'rightCounter', maintaining O(n) complexity
            total += (rightCounter - (mid + 1));
        }

        int a = 0;
        int p1 = low; //mid - low | high - mid + 1 | high - low + 1
        int p2 = mid + 1;

        for (int i = low; i <= high; i++) { //we fill the aux array, and we have high - low + 1 elements
            //with the help of these if statements we decide from which array we should get the next element for aux

            if (p1 > mid) { //no elements left in first array
                aux[a++] = A[p2++];
            } else if (p2 > high) { //no elements left in second array
                aux[a++] = A[p1++];
            } else if (A[p1] <= A[p2]) {
                aux[a++] = A[p1++];
            } else {
                aux[a++] = A[p2++];
            }

        }
        a = 0;
        for(int i = low; i <= high; i++) {
            A[i] = aux[a++];
        }

        return total;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40, 50};
        int[] arr2 = {20, 10, 40, 30, 50};

        int n = findNumberOfInversions(arr1, arr2);

        System.out.println(n);
    }

}










