package assignments.one.model;

import model.measurement.Measurement;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private int id;
    private String Name;
    private boolean isMale;
    private String birthdate;
    private String studentNumber;

    private List<Observation> observations;

    public Person() {
        observations = new ArrayList<>();
    }

    public void addObservation(Observation o) {
        this.observations.add(o);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public String toString() {

        String s = "";
        s += "Dit is " + this.getName() + ".\n";
        s += "Aantal observaties: " + this.getObservations().size();

        if (this.getObservations() != null && this.getObservations().size() > 0) {
            for(int i = 0; i < this.getObservations().size(); i ++) {
                Object o;
                if (this.getObservations().get(i) instanceof Measurement) {
                    o = this.getObservations().get(i);

                    s +=  "\n" + i + ": " + o.toString();
                }
            }
        }
        return s;
    }
}
