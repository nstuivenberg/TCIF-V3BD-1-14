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

    public enum HeadersTemp {
        timestamp, temperature
    }

    public enum HeadersHR {
        timestamp, heartrate
    }
    public enum HeadersBP {
        timestamp, systolic, diastolic
    }

    //todo duplicate
    //todo static filename
    public List<Observation> getAllObservations(String studentNumber, String fullName) {
        ArrayList<Observation> arrayList = new ArrayList<Observation>();
        try {
            Reader in = new FileReader("AssOne/csv/"+ studentNumber + "/temp."+ fullName +".csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(HeadersTemp.class).parse(in);


            for (CSVRecord record : records) {
                String timestamp = record.get(HeadersTemp.timestamp);
                String stringTemp = record.get(HeadersTemp.temperature);

                if (!timestamp.equals("timestamp") || !stringTemp.equals("temperature")) {
                    double temp = 0.00;

                    if (!stringTemp.equals("")) {
                        temp = Double.parseDouble(record.get(HeadersTemp.temperature));
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

        try {
            Reader in = new FileReader("AssOne/csv/" + studentNumber + "/hr." +
                fullName + ".csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader((HeadersHR.class)).parse(in);

            for (CSVRecord record : records) {
                String timestamp = record.get(HeadersHR.timestamp);
                String stringHeartrate = record.get(HeadersHR.heartrate);

                if(!timestamp.equals("timestamp") || !stringHeartrate.equals("heartrate")) {
                    int hr = 0;

                    if(!stringHeartrate.equals("heartrate")) {
                        hr = Integer.parseInt((record.get(HeadersHR.heartrate)));
                    }
                    if(!timestamp.equals("")) {
                        Observation o = new Measurement(timestamp, "heartrate", hr);
                        arrayList.add(o);
                    }
                }
            }
        } catch(FileNotFoundException f) {
            f.printStackTrace();
        } catch(IOException i) {
            i.printStackTrace();
        }

        try {
            Reader in = new FileReader("AssOne/csv/" + studentNumber + "/bp." +
                fullName + ".csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader((HeadersBP.class)).parse(in);
            for(CSVRecord record : records) {
                String timestamp = record.get(HeadersBP.timestamp);
                String stringSystolic = record.get(HeadersBP.systolic);
                String stringDiastolic = record.get(HeadersBP.diastolic);

                if (!timestamp.equals("timestamp") || !stringSystolic.equals("systolic")
                            || !stringDiastolic.equals("diastolic")) {
                    double systolic = 0;
                    double diastolic = 0;
                    if(!stringSystolic.equals("systolic")) {
                        systolic = Double.parseDouble((record.get(HeadersBP.systolic)));
                    }
                    if(!stringDiastolic.equals("diastolic")) {
                        diastolic = Double.parseDouble((record.get(HeadersBP.diastolic)));
                    }
                    if(!timestamp.equals("")) {
                        Observation o1 = new Measurement(timestamp, "systolic", systolic);
                        Observation o2 = new Measurement(timestamp, "diastolic", diastolic);
                        arrayList.add(o1);
                        arrayList.add(o2);
                    }

                }
            }

        } catch(FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }

        return arrayList;
    }
}
