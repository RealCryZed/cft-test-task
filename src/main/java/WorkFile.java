import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WorkFile {

    public boolean fileExists(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            return false;
        }

        return true;
    }

    public ArrayList openAndReadFile(String filename, ArrayList lines) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {

        }

        return lines;
    }

    public void sortByOrder(boolean ascendingOrder) {

    }

    public void createNewFile(ArrayList finalList) {
        //create new file with sorted parameters
    }
}
