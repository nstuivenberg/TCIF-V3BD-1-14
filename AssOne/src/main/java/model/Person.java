package model;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String id;
    private String name;
    private String gender;
    private String birthDate;
    private String studentnr;
    private List<Observation> observations;


    public Person(String id, String name, String gender, String birthDate, String studentnr) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.studentnr = studentnr;
        observations = new ArrayList<Observation>();
    }

    public String getName() {
        return this.name;
    }

    public String getStudentnr() {
        return studentnr;
    }

    public String toString() {

        String s = "Dit is: " + this.getName();
        if(hasObservation()) {
            s+= "\nHij heeft " + observations.size() + " observaties.";
        }
        return s;
    }

    public void addMultipleObservation(List<Observation> oList) {
        System.out.print("OBS: " + oList.size());
        for(int i = 0; i < oList.size(); i++) {
            this.addObservation(oList.get(i));
        }
    }

    public void addObservation(Observation o) {
        this.observations.add(o);
    }

    public boolean hasStudentNumber(String number) {
        if(number.equals(this.getStudentnr()))
        {
            return true;
        }
        return false;
    }

    public boolean hasObservation() {
        if(this.observations.size() > 0) {
            return true;
        }
        return false;
    }
}
