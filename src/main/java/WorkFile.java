import java.io.*;
import java.util.ArrayList;

public class WorkFile {

    public boolean fileExists(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            return false;
        }

        return true;
    }

    public Integer[] openAndReadFile(String filename) {
        ArrayList<Integer> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        } catch (IOException e) {

        }

        return lines.toArray(new Integer[0]);
    }

    public Integer[] sortByOrder(ArrayList<Integer[]> list, boolean ascendingOrder) {
        Integer[] array = null;
        for (int i = 0; i < list.size()-1; i++) {
            if (i == 0) {
                array = Sort.mergeSort(list.get(i), list.get(i + 1));
            } else {
                array = Sort.mergeSort(array, list.get(i+1));
            }
        }

        if (!ascendingOrder) {
            array = Sort.sortByDescendingOrder(array);
        }

        return array;
    }

    public void createNewFile(String filename, Integer[] finalList) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename);
            for (Integer integer : finalList) {
                writer.write(integer + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createNewFile(String filename, String[] finalList) {

    }
}
