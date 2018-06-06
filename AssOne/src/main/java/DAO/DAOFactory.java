package DAO;

import DAO.CSV.CSVDAOFactory;
import DAO.SQL.SQLDAOFactory;

/*
http://www.oracle.com/technetwork/java/dataaccessobject-138824.html
 */

public abstract class DAOFactory {

    public static final int CSV = 1;
    public static final int SQL = 2;

    public abstract IPersonDAO getPersonDAO();
    public abstract IObservationDAO getObservationDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {

        switch(whichFactory) {
            case CSV:
                return new CSVDAOFactory();
            case SQL:
                return new SQLDAOFactory();
            default:
                    return null;
        }
    }

}
