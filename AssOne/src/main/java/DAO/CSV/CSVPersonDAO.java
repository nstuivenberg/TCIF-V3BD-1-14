package DAO.CSV;

import DAO.DAOFactory;
import DAO.IObservationDAO;
import DAO.IPersonDAO;
import model.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class CSVPersonDAO implements IPersonDAO {

    //AssOne/csv
    private static String FILENAME = "BD_opdr1/AssOne/csv/persons.csv";

    public enum Headers {
        id, name, gender, birthdate, studentnr
    }

    public ArrayList<Person> getAllPerson() {

        ArrayList<Person> aList = new ArrayList<Person>();

        try {
            Reader in = new FileReader(FILENAME);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);
            for (CSVRecord record : records) {

                String id = record.get(Headers.id);
                String name = record.get(Headers.name);
                String gender = record.get(Headers.gender);
                String birthdate = record.get(Headers.birthdate);
                String studentnr = record.get(Headers.studentnr);

                if(!id.equals("") && id != null ) {
                    Person p = new Person(id, name, gender, birthdate, studentnr);

                    aList.add(p);
                }
            }
        } catch (FileNotFoundException i) {
            i.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return aList;
    }

    public ArrayList<Person> getAllPersonsByStudentId(String studentId) {
        ArrayList<Person> aList = new ArrayList<Person>();

        try {
            Reader in = new FileReader(FILENAME);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);

            //System.out.println(records.spliterator().getExactSizeIfKnown());
            for (CSVRecord record : records) {

                String id = record.get(Headers.id);
                String name = record.get(Headers.name);
                String gender = record.get(Headers.gender);
                String birthdate = record.get(Headers.birthdate);
                String studentnr = record.get(Headers.studentnr);

                if(!id.equals("") && id != null && studentnr.equals(studentId)) {
                    Person p = new Person(id, name, gender, birthdate, studentnr);

                    // Het probleem zit hem hier in de dat je meerdere observation types hebt.
                    // Person moet dus een methode krijgen waar je een hele array in kan tieven.
                    // Observation - Measurement - quantity - PhenType
                    //Dit hoort hier niet??
                    String fullName = p.getName().replaceAll("\\s+","");
                    DAOFactory csvFactory = DAOFactory.getDAOFactory(DAOFactory.CSV);
                    IObservationDAO observationDAO = csvFactory.getObservationDAO();
                    p.addMultipleObservation(observationDAO.getAllObservations(studentId ,fullName));


                    aList.add(p);
                }
            }
        } catch (FileNotFoundException i) {
            i.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return aList;
    }
}
