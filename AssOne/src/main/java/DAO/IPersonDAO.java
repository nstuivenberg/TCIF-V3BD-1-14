package main.java.DAO;

import main.java.model.Person;
import java.util.ArrayList;

public interface IPersonDAO {
    ArrayList<Person> getAllPerson();
    ArrayList<Person> getAllPersonsByStudentId(String studentId);
}
