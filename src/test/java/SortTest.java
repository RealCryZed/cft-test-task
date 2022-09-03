import org.junit.Test;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void mergeSortIntegerArray() {
        Integer[] array1 = new Integer[]{1,4,6,8,15,25};
        Integer[] array2 = new Integer[]{2,5,7,22,23,29};

        Integer[] result = Sort.mergeSort(array1, array2);
        Integer[] expected = new Integer[]{1,2,4,5,6,7,8,15,22,23,25,29};
        assertArrayEquals(expected, result);
    }

    @Test
    public void mergeSortStringArray() {
        String[] array1 = new String[]{"Alphabet", "Google", "Youtube", "Zoom"};
        String[] array2 = new String[]{"Apple", "LG", "Samsung", "Tesla"};

        String[] result = Sort.mergeSort(array1, array2);
        String[] expected = new String[]{"Alphabet", "Apple", "Google", "LG", "Samsung", "Tesla", "Youtube", "Zoom"};
        assertArrayEquals(expected, result);
    }
}