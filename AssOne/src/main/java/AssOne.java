package main.java;

import main.java.DAO.DAOFactory;
import main.java.DAO.IPersonDAO;
import main.java.model.Person;

import java.util.List;


public class AssOne {
    public static void main(String[] args) {


        System.out.println("Je moeder");

        DAOFactory csvFactory = DAOFactory.getDAOFactory(DAOFactory.CSV);
        IPersonDAO personDAO = csvFactory.getPersonDAO();
        List<Person> personList = personDAO.getAllPersonsByStudentId("1667775");

        for(int i = 0; personList.size() > i; i++) {
            System.out.println(personList.get(i).toString());
        }
    }
}