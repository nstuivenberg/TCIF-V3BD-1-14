package DAO;

import model.Observation;

import java.util.List;

public interface IObservationDAO {
    List<Observation> getAllObservations(String studentNumber, String fullName);
}
