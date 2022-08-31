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

        ArrayList allValues = file.getArrayList(stringType);
        file.setFilename(filenames.get(0));

        for (int i = 1; i < filenames.size(); i++) {
            if (file.fileExists(filenames.get(i))) {
                allValues.addAll(file.openAndReadFile(filenames.get(i), file.getArrayList(stringType)));
            }
        }

        file.sortByOrder(ascendingOrder);
    }
}
