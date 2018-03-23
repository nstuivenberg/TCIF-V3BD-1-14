package model.measurement;


import model.Observation;
import model.shared.PhenomonType;

public class Measurement extends Observation {

    private Quantity quantity;

    private PhenomonType phenomonType;

    public Measurement(String phenomonType, double q) {
        super();
        this.phenomonType = new PhenomonType(phenomonType);
        this.quantity = new Quantity(q);
    }

    public Measurement(String phenomonType, double q, String unit) {
        super();
        this.phenomonType = new PhenomonType(phenomonType);
        this.quantity = new Quantity(q, unit);
    }

    public String toString() {
        return super.toString() + phenomonType.getName() + ", waarde: " + quantity.toString();
    }



}
