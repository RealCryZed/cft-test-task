import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
        MyLogger logger = MyLogger.getLogger();

        boolean ascendingOrder = true;
        boolean stringType = true;

        ArrayList<String> filenames = new ArrayList<>();

        for (String argument : args) {
            if (argument.equals("-d")) {
                ascendingOrder = false;
            } else if (argument.equals("-i")) {
                stringType = false;
            } else if (argument.contains(".")){
                filenames.add(argument);
            }
        }

        logger.log(Level.INFO, "Type: " + stringType + ", ascendingOrder = " + ascendingOrder);

        if (stringType) {
            stringData(filenames, ascendingOrder, filenames.size());
        } else {
            intData(filenames, ascendingOrder, filenames.size());
        }

        // Make program wait till user pushes the button
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void intData(ArrayList<String> filenames, boolean ascendingOrder, int fileNumber) {
        WorkFile file = new WorkFile();

        ArrayList<Integer[]> listOfArrays = new ArrayList<>();
        String finalFileName = filenames.get(0);

        for (int i = 1; i < filenames.size(); i++) {
            if (file.fileExists(filenames.get(i))) {
                listOfArrays.add(file.openAndReadFile(filenames.get(i)));
            }
        }

        Integer[] finalList = null;

        if (fileNumber == 2) {
            if (ascendingOrder) finalList = listOfArrays.get(0);
            else finalList = Sort.sortByDescendingOrder(listOfArrays.get(0));
        } else {
            finalList = file.sortByOrder(listOfArrays, ascendingOrder);
        }

        file.createNewFile(finalFileName, finalList);
    }

    public static void stringData(ArrayList<String> filenames, boolean ascendingOrder, int fileNumber) {
        WorkFile file = new WorkFile();

        ArrayList<String[]> listOfArrays = new ArrayList<>();
        String finalFileName = filenames.get(0);

        for (int i = 1; i < filenames.size(); i++) {
            if (file.fileExists(filenames.get(i))) {
                listOfArrays.add(file.openAndReadFileStringData(filenames.get(i)));
            }
        }

        String[] finalList = null;

        if (fileNumber == 2) {
            if (ascendingOrder) finalList = listOfArrays.get(0);
            else finalList = Sort.sortByDescendingOrder(listOfArrays.get(0));
        } else {
            finalList = file.sortByOrderStringData(listOfArrays, ascendingOrder);
        }

        file.createNewFile(finalFileName, finalList);
    }
}
