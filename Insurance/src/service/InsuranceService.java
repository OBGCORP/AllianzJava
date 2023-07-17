package service;

import model.*;

public class InsuranceService {
    public Insurance createInsurance(String name, InsuranceType insuranceTypeEnum) {
        Insurance insurance = new Insurance();
        insurance.setName(name);
        insurance.setInsuranceTypeEnum(insuranceTypeEnum);
        return insurance;
    }
}