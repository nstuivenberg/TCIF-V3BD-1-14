package assignments.one.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    private String csvFile;

    public CSVReader(String fileName) {
        this.csvFile = fileName;

    }
    public String getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }

    public void testOutput() {
        BufferedReader br;
        String line;
        String cvsSplit = ",";

        try {
        br = new BufferedReader(new FileReader(getCsvFile()));
        int counter = 0;
            while((line = br.readLine()) != null) {
                String[] aLine = line.split(cvsSplit);

                System.out.println("aLine0: " + aLine[0]);
                String aString = aLine[0];
                if(!aString.equals("") || aString != null) {
                    String s = counter + ": ";
                    for(int i = 0; aLine.length > i; i++) {
                        s += ", " + i + " " + aLine[i];
                    }
                    System.out.println(s);
                    counter++;
                }


            }
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException i) {
            i.printStackTrace();
        }
    }
}
