public class Main {
    public static void main(String[] args) {
        int[] array = {3, 4, 2, 5, 1};

        System.out.println("Array: " + stringArray(array));

        int[] sortedArray = insertionSort(array);

        System.out.println("Sorted Array: " + stringArray(sortedArray));
    }

    // sort an array using the insertion sort algorithm
    public static int[] insertionSort(int[] array) {
        int[] sortedArray = array.clone(); // copy array so we don't modify the original

        // loop through array starting at second element
        for (int i = 1; i < sortedArray.length; i++) {
            int current = sortedArray[i]; // element we are sorting
            int j = i; // index of current position

            // while position is > 0 and the current element is less than the previous element
            while (j > 0 && current < sortedArray[j - 1]) {
                sortedArray[j] = sortedArray[j - 1]; // set element at pos to the element at pos - 1
                j--;
            }

            sortedArray[j] = current; // set element at pos to the element we are sorting
        }

        return sortedArray;
    }

    // convert array to string for easier printing
    public static String stringArray(int[] array) {
        String s = "[";
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                s += array[i] + ", ";
            } else {
                s += array[i] + "]";
            }
        }
        return s;
    }
}