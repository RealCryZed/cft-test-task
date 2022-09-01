public class Sort {

    public static Integer[] mergeSort(Integer[] firstArray, Integer[] secondArray) {

        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;

        Integer[] merged = new Integer[firstArrayLength + secondArrayLength];

        int firstArrayPosition, secondArrayPosition, mergedPosition;
        firstArrayPosition = secondArrayPosition = mergedPosition = 0;

        while(firstArrayPosition < firstArrayLength && secondArrayPosition < secondArrayLength) {
            if (firstArray[firstArrayPosition] < secondArray[secondArrayPosition]) {
                merged[mergedPosition++] = firstArray[firstArrayPosition++];
            } else {
                merged[mergedPosition++] = secondArray[secondArrayPosition++];
            }
        }

        while (firstArrayPosition < firstArrayLength) {
            merged[mergedPosition++] = firstArray[firstArrayPosition++];
        }

        while (secondArrayPosition < secondArrayLength) {
            merged[mergedPosition++] = secondArray[secondArrayPosition++];
        }

        return merged;
    }

    public static String[] mergeSort(String[] firstArray, String[] secondArray) {
        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;

        String[] merged = new String[firstArrayLength + secondArrayLength];

        int firstArrayPosition, secondArrayPosition, mergedPosition;
        firstArrayPosition = secondArrayPosition = mergedPosition = 0;

        while(firstArrayPosition < firstArrayLength && secondArrayPosition < secondArrayLength) {
            if (firstArray[firstArrayPosition].compareTo(secondArray[secondArrayPosition]) < 0) {
                merged[mergedPosition++] = firstArray[firstArrayPosition++];
            } else {
                merged[mergedPosition++] = secondArray[secondArrayPosition++];
            }
        }

        while (firstArrayPosition < firstArrayLength) {
            merged[mergedPosition++] = firstArray[firstArrayPosition++];
        }

        while (secondArrayPosition < secondArrayLength) {
            merged[mergedPosition++] = secondArray[secondArrayPosition++];
        }

        return merged;
    }

    public static Integer[] sortByDescendingOrder(Integer[] array) {
        Integer[] sortedArray = new Integer[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[array.length - i - 1] = array[i];
        }

        return sortedArray;
    }

    public static String[] sortByDescendingOrder(String[] array) {
        String[] sortedArray = new String[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[array.length - i - 1] = array[i];
        }

        return sortedArray;
    }
}
