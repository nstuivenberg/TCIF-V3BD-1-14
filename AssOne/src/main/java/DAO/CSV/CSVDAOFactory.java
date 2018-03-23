package main.java.DAO.CSV;

import main.java.DAO.DAOFactory;
import main.java.DAO.IPersonDAO;

public class CSVDAOFactory extends DAOFactory{
    public IPersonDAO getPersonDAO() {
        return new CSVPersonDAO();
    }
}
