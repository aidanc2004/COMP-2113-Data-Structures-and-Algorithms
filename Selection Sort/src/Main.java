public class Main {
    public static void main(String[] args) {
        int[] array = {3, 4, 2, 5, 1};

        System.out.println("Array: " + stringArray(array));

        int[] sortedArray = selectionSort(array);

        System.out.println("Sorted Array: " + stringArray(sortedArray));
    }

    // sort an array using the selection sort algorithm
    public static int[] selectionSort(int[] array) {
        int[] sortedArray = array.clone(); // copy array so we don't modify the original

        // loop through array starting at first element, i = walker
        for (int i = 0; i < sortedArray.length; i++) {
            int min = i; // index of the smallest element in sub array of j to sortedArray.length

            // loop through sub array of j to sortedArray.length
            for (int j = i; j < sortedArray.length; j++) {
                // if element at index j is smaller than min
                if (sortedArray[j] < sortedArray[min]) {
                    min = j;
                }
            }

            // swap i and min elements
            int temp = sortedArray[i];
            sortedArray[i] = sortedArray[min];
            sortedArray[min] = temp;
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