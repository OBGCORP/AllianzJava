package util;

public enum Grade {
    F("F", 0),
    D("D", 1),
    C("C", 2),
    B("B", 3),
    A("A", 4);

    private String stringValue;
    private int numericValue;

    Grade(String stringValue, int numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    @Override
    public String toString() {
        return "Grade " + this.stringValue +
                " corresponds to numeric grade " +
                this.numericValue + '.';
    }
}
