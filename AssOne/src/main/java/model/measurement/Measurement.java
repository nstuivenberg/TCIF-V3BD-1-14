package model.measurement;


import model.Observation;
import model.shared.PhenomonType;

public class Measurement extends Observation {

    private Quantity quantity;

    private PhenomonType phenomonType;

    public Measurement(String timestamp, String phenomtype, double q) {
        super(timestamp);
        this.phenomonType = new PhenomonType(phenomtype);
        this.quantity = new Quantity(q);
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public PhenomonType getPhenomonType() {
        return phenomonType;
    }

    public String toString() {
        return super.toString() + phenomonType.getName() + ", waarde: " + quantity.toString();
    }



}
