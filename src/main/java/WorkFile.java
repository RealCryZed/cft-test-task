import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkFile {

    private String filename;

    public boolean fileExists(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            return false;
        }

        return true;
    }

    public ArrayList getArrayList(boolean stringType) {
        ArrayList lines = null;

        if (stringType) {
            lines = new ArrayList<String>();
        } else {
            lines = new ArrayList<Integer>();
        }

        return lines;
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
}
