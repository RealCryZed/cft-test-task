import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
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

        if (stringType) {
            stringData(filenames, ascendingOrder);
        } else {
            intData(filenames, ascendingOrder);
        }
    }

    public static ArrayList createNewArrayListByType(boolean stringType, boolean arrayListOfArrays) {
        ArrayList lines = null;

        if (arrayListOfArrays) {
            if (stringType) {
                lines = new ArrayList<String[]>();
            } else {
                lines = new ArrayList<Integer[]>();
            }
        } else {
            if (stringType) {
                lines = new ArrayList<String>();
            } else {
                lines = new ArrayList<Integer>();
            }
        }

        return lines;
    }

    public static void intData(ArrayList<String> filenames, boolean ascendingOrder) {
        WorkFile file = new WorkFile();

        ArrayList<Integer[]> listOfArrays = new ArrayList<>();
        String finalFileName = filenames.get(0);

        for (int i = 1; i < filenames.size(); i++) {
            if (file.fileExists(filenames.get(i))) {
                listOfArrays.add(file.openAndReadFile(filenames.get(i)));
            }
        }

        Integer[] finalList = file.sortByOrder(listOfArrays, ascendingOrder);

//        for (int i = 0; i < finalList.length; i++) {
//            System.out.println(finalList[i]);
//        }

        file.createNewFile(finalFileName, finalList);
    }

    public static void stringData(ArrayList<String> filenames, boolean ascendingOrder) {
//        WorkFile file = new WorkFile();
//
//        ArrayList listOfArrays = createNewArrayListByType(stringType, true);
//        String finalFileName = filenames.get(0);
//
//        for (int i = 1; i < filenames.size(); i++) {
//            if (file.fileExists(filenames.get(i))) {
//                ArrayList tempList = createNewArrayListByType(stringType, false);
//                listOfArrays.add(file.openAndReadFile(filenames.get(i), tempList));
//            }
//        }
//
//        ArrayList finalList = file.sortByOrder(listOfArrays, ascendingOrder);
//        file.createNewFile(finalFileName, finalList);
    }
}
