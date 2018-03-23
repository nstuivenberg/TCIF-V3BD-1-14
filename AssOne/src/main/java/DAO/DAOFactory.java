package main.java.DAO;

import main.java.DAO.CSV.CSVDAOFactory;

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

