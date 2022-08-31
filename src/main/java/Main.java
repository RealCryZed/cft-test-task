import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
        WorkFile file = new WorkFile();

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

        ArrayList listOfArrays = getArrayList(stringType);
        String finalFileName = filenames.get(0);

        for (int i = 1; i < filenames.size(); i++) {
            if (file.fileExists(filenames.get(i))) {
                ArrayList tempList = new ArrayList();
                listOfArrays.add(file.openAndReadFile(filenames.get(i), tempList));
            }
        }

        file.sortByOrder(ascendingOrder);
    }

    public static ArrayList getArrayList(boolean stringType) {
        ArrayList lines = null;

        if (stringType) {
            lines = new ArrayList<String[]>();
        } else {
            lines = new ArrayList<Integer[]>();
        }

        return lines;
    }
}
