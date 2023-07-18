import model.*;
import service.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        AgencyService agencyService = new AgencyService();
        Agency agency = agencyService.createAgency("MOM");
        System.out.println(agency.toString());

        BankAccountService bankAccountService = new BankAccountService();
        BankAccount bankAccount = bankAccountService.createBankAccount("Ziraat Bankasi", "TR20300000048476353", BigDecimal.ZERO);

        agencyService.addBankAccountToAgency(agency, bankAccount);
        System.out.println(agency.toString());

        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
        InsuranceCompany insuranceCompany = insuranceCompanyService.createInsuranceCompany("Allianz", "727384849",
                "Ankara", "Ankara/ Cankaya", new BigDecimal(8));

        InsuranceService insuranceService = new InsuranceService();
        Insurance insurance = insuranceService.createInsurance("compulsory traffic insurance", InsuranceType.COMPULSORY_TRAFFIC_INSURANCE);
        insuranceCompanyService.addInsuranceToInsuranceCompany(insuranceCompany, insurance);
        BankAccount allianzBankAccount = bankAccountService.createBankAccount("Yapi Kredi Bankasi", "TR20300000048476353", new BigDecimal(1000000));
        insuranceCompanyService.addBankAccountToInsuranceCompany(insuranceCompany, allianzBankAccount);

        CustomerService customerService = new CustomerService();
        Customer customer = customerService.createCustomer("Sinem", CustomerType.CORPORATE);

        BankAccount customerBankAccount = bankAccountService.createBankAccount("Is Bankasi",
                "TR139128309183907", new BigDecimal(10000));

        customerService.addBankAccountToCustomer(customer, customerBankAccount);
        agencyService.addInsuranceCompanyToAgency(agency, insuranceCompany);
        agencyService.addCustomerToAgency(agency, customer);

        VehicleService vehicleService = new VehicleService();
        Vehicle vehicle = vehicleService.createVehicle("Ford", "Focus",
                2010, "34cd474", "2345", ColorTypeEnum.BLACK);

        customerService.addVehicleToCustomer(customer, vehicle);
        System.out.println(customer);
    }
}