package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    ProposalService proposalService = new ProposalService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();
    public Customer createCustomer(String name, CustomerType customerTypeEnum) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerTypeEnum(customerTypeEnum);
        return customer;
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount) {
        if (customer.getBankAccountList() != null) {
            customer.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountList = new ArrayList<>();
            bankAccountList.add(bankAccount);
            customer.setBankAccountList(bankAccountList);
        }
    }

    public void addVehicleToCustomer(Customer customer, Vehicle vehicle) {
        if (customer.getVehicleList() != null) {
            customer.getVehicleList().add(vehicle);
        } else {
            ArrayList<Vehicle> vehicleList = new ArrayList<>();
            vehicleList.add(vehicle);
            customer.setVehicleList(vehicleList);
        }
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest) {
        if (customer.getInsuranceRequestList() != null) {
            customer.getInsuranceRequestList().add(insuranceRequest);
        } else {
            ArrayList<InsuranceRequest> insuranceRequestList = new ArrayList<>();
            insuranceRequestList.add(insuranceRequest);
            customer.setInsuranceRequestList(insuranceRequestList);
        }
    }

    public void addPolicyToCustomer(Customer customer, Policy policy) {
        if (customer.getPolicyList() != null) {
            customer.getPolicyList().add(policy);
        } else {
            ArrayList<Policy> policyList = new ArrayList<>();
            policyList.add(policy);
            customer.setPolicyList(policyList);
        }
    }

    public void addPaymentMovementToCustomer(Customer customer, PaymentMovement paymentMovement) {
        if (customer.getPaymentMovementList() != null) {
            customer.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovementList = new ArrayList<>();
            paymentMovementList.add(paymentMovement);
            customer.setPaymentMovementList(paymentMovementList);
        }
    }

    public void acceptProposal(Customer customer, Proposal proposal, InsuranceRequest insuranceRequest){
        List<InsuranceRequest> insuranceRequestList = customer.getInsuranceRequestList();
        for (InsuranceRequest insuranceRequest1: insuranceRequestList) {
            if (insuranceRequest1.equals(insuranceRequest)){
                for (Proposal proposal1 : insuranceRequest1.getProposalList()) {
                    if (proposal1.equals(proposal)) {
                        BankAccount bankAccount = checkBankAccount(customer, proposalService.calculateDiscountedPrice(proposal));
                        if (bankAccount != null) {
                           bankAccount.setAmount(bankAccount.getAmount().subtract(proposalService.calculateDiscountedPrice(proposal)));

                        }
                        proposal1.setApproved(true);
                    }
                }
            }
        }
    }

    public BankAccount checkBankAccount(Customer customer, BigDecimal amount){
        List<BankAccount> bankAccountList = customer.getBankAccountList();
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }
}
