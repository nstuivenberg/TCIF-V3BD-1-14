package main.java.DAO.CSV;

import main.java.DAO.IPersonDAO;
import main.java.model.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class CSVPersonDAO implements IPersonDAO {

    //TODO Change pathname
    private static String FILENAME = "F:\\HU\\projects\\AssOne\\src\\main\\resources\\csv\\persons.csv";

    public enum Headers {
        id, name, gender, birthdate, studentnr
    }

    public ArrayList<Person> getAllPerson() {
        ArrayList<Person> personList = new ArrayList<Person>();

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
                    personList.add(p);
                }
            }

        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }

        return personList;

    }

    public ArrayList<Person> getAllPersonsByStudentId(String studentId) {
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

                if(!id.equals("") && id != null && studentnr.equals(studentId)) {
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
}
