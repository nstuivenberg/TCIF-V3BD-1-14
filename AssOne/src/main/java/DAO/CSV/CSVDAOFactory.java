package DAO.CSV;

import DAO.DAOFactory;
import DAO.IObservationDAO;
import DAO.IPersonDAO;

public class CSVDAOFactory extends DAOFactory {

    public IPersonDAO getPersonDAO() {
        return new CSVPersonDAO();
    }
    public IObservationDAO getObservationDAO() {
        return new CSVObservationDAO();
    }
}
