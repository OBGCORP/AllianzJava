package model;

public class Insurance {
    private InsuranceType insuranceTypeEnum;
    private String name;

    public Insurance(InsuranceType insuranceTypeEnum, String name) {
        this.insuranceTypeEnum = insuranceTypeEnum;
        this.name = name;
    }

    public Insurance() {

    }

    public InsuranceType getInsuranceTypeEnum() {
        return insuranceTypeEnum;
    }

    public void setInsuranceTypeEnum(InsuranceType insuranceTypeEnum) {
        this.insuranceTypeEnum = insuranceTypeEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
