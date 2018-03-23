package DAO;

import DAO.CSV.CSVDAOFactory;

/*
http://www.oracle.com/technetwork/java/dataaccessobject-138824.html
 */

public abstract class DAOFactory {

    public static final int CSV = 1;

    public abstract IPersonDAO getPersonDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {

        switch(whichFactory) {
            case CSV:
                return new CSVDAOFactory();
            default:
                    return null;
        }
    }

}
