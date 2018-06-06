package DAO.SQL;

import DAO.IPersonDAO;
import model.CatObs.CategoryObservation;
import model.Observation;
import model.Person;
import model.measurement.Measurement;
import model.measurement.Quantity;
import model.shared.PhenomonType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLPersonDAO implements IPersonDAO {


    public SQLPersonDAO() {

    }

    public ArrayList<Person> getAllPerson() {
        return null;
    }

    public ArrayList<Person> getAllPersonsByStudentId(String studentId) {
        return null;
    }

    public void insertAllPersons(List<Person> personList) {

        List<Person> aList = personList;

        for(Person p : personList) {
            try {
                insertAPerson(p);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void insertAPerson(Person person) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        String insertTableSQL = "INSERT INTO person"
                + "(name, gender, birthdate, studentNr) VALUES"
                + "(?,?,?,?)";

        try {
            conn = SQLDAOFactory.getDBConnection();
            ps = conn.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, person.getName());
            ps.setString(2, person.getGender());
            ps.setString(3, person.getBirthDate());
            ps.setString(4, person.getStudentnr());

            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();

            if(resultSet.next()) {
                int personId =  Integer.parseInt(resultSet.getString(1));
                List<Observation> observations = person.getObservations();

                if(observations.size() > 0) {
                    insertAllObservations(personId, observations);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }

            if (conn != null) {
                conn.close();
            }
        }


    }

    private void insertAllObservations(int personId, List<Observation> obsList) throws SQLException {
        for(Observation o : obsList) {
            try {
                insertObservation(personId, o);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void insertObservation(int personId, Observation o) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Object objectToUse = new Object();

        String insertTableSQL = "";

        if(o instanceof Measurement) {
            insertTableSQL = "INSERT INTO observation"
                    + "(userid, phenTypeId, quantityId, timestamp) VALUES"
                    + "(?,?,?,?)";
            //Observation obs = new Measurement(o.getTimestamp());

            //((Measurement) o).toString();

            objectToUse = o;
        }
        if(o instanceof CategoryObservation) {
            // Not needed for this assignment
        }

        try {
            conn = SQLDAOFactory.getDBConnection();
            ps = conn.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, personId);
            ps.setInt(2,insertAPhenType(((Measurement) objectToUse).getPhenomonType())); //todo
            ps.setInt(3, 2); //todo
            ps.setString(4, o.getTimestamp());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int insertAPhenType(PhenomonType phenomonType) throws SQLException {

        int opgehaaldeId = hasPhenType(phenomonType);

        if(opgehaaldeId != 0) {
            Connection conn = null;
            PreparedStatement ps = null;

            String insertTableSQL = "INSERT INTO phenomenontype (name) VALUES (?)";

            try{
                conn = SQLDAOFactory.getDBConnection();
                ps = conn.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, phenomonType.getName());
                ps.executeUpdate();


                ResultSet resultSet = ps.getGeneratedKeys();
                if(resultSet.next()) {
                    opgehaaldeId = Integer.parseInt(resultSet.getString(1));
                }

            } catch(SQLException s) {
                s.printStackTrace();
            }
        }
        return opgehaaldeId;
    }

    private int hasPhenType(PhenomonType phenomonType) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        String insertTableSQL = "SELECT * FROM phenomenontype WHERE name = ?";

        try {
            conn = SQLDAOFactory.getDBConnection();
            ps = conn.prepareStatement(insertTableSQL);

            ps.setString(1, phenomonType.getName());
            //Sysrem
            ResultSet rs = ps.executeQuery(insertTableSQL);

            while(rs.next()) {
                    return rs.getInt("pTypeId");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    private void insertQuantity(Quantity quantity) {

    }
}
