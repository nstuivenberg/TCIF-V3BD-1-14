package DAO;

import model.Person;

import java.util.ArrayList;

public interface IPersonDAO {
   ArrayList<Person> getAllPerson();
   ArrayList<Person> getAllPersonsByStudentId(String studentId);

}
