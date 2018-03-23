package main.java.model.measurement;

public class Quantity {

    private Unit unit;
    private double value;

    public Quantity(double value) {
        this.value = value;
    }

    public Quantity(double value, String u) {
        this.value = value;
        this.unit = new Unit(u);
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String toString() {
        if(this.getUnit() != null) {
            return getValue() + " " + getUnit().getName();
        }
        return "" + getValue();
    }
}
