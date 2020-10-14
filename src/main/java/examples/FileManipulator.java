package examples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManipulator {
    String file;

    FileManipulator(String file) {
        this.file = file;
    }

    BufferedReader getFileReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader(this.file));
    }

    public List<String> getLines() {

        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = this.getFileReader();
            String line = reader.readLine();
            lines.add(line);

            while (line != null) {
                line = reader.readLine();
                lines.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
