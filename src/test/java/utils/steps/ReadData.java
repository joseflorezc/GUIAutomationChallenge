package utils.steps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {

    public static String [] readData(String file) throws IOException {
        String [] data =  new String[3];

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine = reader.readLine();
        data = currentLine.split(",");

        reader.close();

        return data;
    }


}
