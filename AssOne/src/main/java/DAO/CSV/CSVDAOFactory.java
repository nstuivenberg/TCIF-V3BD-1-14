package DAO.CSV;

import DAO.DAOFactory;
import DAO.IPersonDAO;

public class CSVDAOFactory extends DAOFactory {

    public IPersonDAO getPersonDAO() {
        return new CSVPersonDAO();
    }
}
