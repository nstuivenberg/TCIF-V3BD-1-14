package DAO.CSV;

import DAO.IObservationDAO;
import model.Observation;
import model.measurement.Measurement;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVObservationDAO implements IObservationDAO {

    public enum HeadersBP {
        timestamp, temperature
    }

    //todo duplicate
    //todo static filename
    public List<Observation> getAllObservations(String studentNumber, String fullName) {
        ArrayList<Observation> arrayList = new ArrayList<Observation>();
        try {
            Reader in = new FileReader("BD_opdr1/AssOne/csv/"+ studentNumber + "/temp."+ fullName +".csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(HeadersBP.class).parse(in);


            for (CSVRecord record : records) {
                String timestamp = record.get(HeadersBP.timestamp);
                String stringTemp = record.get(HeadersBP.temperature);

                if (!timestamp.equals("timestamp") || !stringTemp.equals("temperature")) {
                    double temp = 0.00;

                    if (!stringTemp.equals("")) {
                        temp = Double.parseDouble(record.get(HeadersBP.temperature));
                    }
                    if (!timestamp.equals("")) {
                        Observation o = new Measurement(timestamp, "temperature", temp);
                        arrayList.add(o);
                    }
                }
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return arrayList;
    }
}
