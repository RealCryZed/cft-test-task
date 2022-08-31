public class MergeSort {

    public static int[] mergeSort(int[] firstArray, int[] secondArray) {

        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;

        int[] merged = new int[firstArrayLength + secondArrayLength];

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
}
