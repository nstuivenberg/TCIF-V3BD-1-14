package DAO;

import model.Person;

import java.util.ArrayList;
import java.util.List;

public interface IPersonDAO {
   ArrayList<Person> getAllPerson();
   ArrayList<Person> getAllPersonsByStudentId(String studentId);

   void insertAllPersons(List<Person> personList);

}
