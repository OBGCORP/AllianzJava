package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class DanceCourseService {

    public DanceCourse createDanceCourse(String name, String address, String founder, String taxNumber, String taxOffice) {

        DanceCourse danceCourse = new DanceCourse();
        danceCourse.setName(name);
        danceCourse.setAddress(address);
        danceCourse.setFounder(founder);
        danceCourse.setTaxNumber(taxNumber);
        danceCourse.setTaxOffice(taxOffice);
        return danceCourse;
    }


    public void createBankAccountToDanceCourse(DanceCourse danceCourse, BankAccount bankAccount) {

        if (danceCourse.getBankAccountList() != null) {
            if (isExistBankAccount(danceCourse, bankAccount)) {
                addAmountToExistBankAccount(danceCourse, bankAccount);
            } else {
                danceCourse.getBankAccountList().add(bankAccount);
            }
        } else {
            /*List<BankAccount> bankAccountList = new ArrayList<>();
            bankAccountList.add(bankAccount);*/
            danceCourse.setBankAccountList(List.of(bankAccount));
        }
    }


    private boolean isExistBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {

        boolean isExist = false;

        for (BankAccount bankAccount1 : danceCourse.getBankAccountList()) {
            if (bankAccount1.getIbanNo().equals(bankAccount.getIbanNo())) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    private void addAmountToExistBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {

        for (BankAccount bankAccount1 : danceCourse.getBankAccountList()) {
            if (bankAccount1.getIbanNo().equals(bankAccount.getIbanNo())) {
                bankAccount1.setAmount(bankAccount1.getAmount().add(bankAccount.getAmount()));
                break;
            }
        }
    }


    public void createBankAccountToDanceCourse(DanceCourse danceCourse, List<BankAccount> bankAccountList) {

        if (danceCourse.getBankAccountList() != null) {
            danceCourse.getBankAccountList().addAll(bankAccountList);
        } else {
            danceCourse.setBankAccountList(bankAccountList);
        }

    }

    public void addInstructorToDanceCourse(DanceCourse danceCourse, Instructor instructor) {

        BankAccountService bankAccountService = new BankAccountService();
        PaymentMovementService paymentMovementService = new PaymentMovementService();

        if (danceCourse.getBankAccountList() != null) {

            BankAccount bankAccount = bankAccountService.getBankAccountWithEnoughMoney(danceCourse, instructor.getSalary());

            if (bankAccount != null) {

                bankAccount.setAmount(bankAccount.getAmount().subtract(instructor.getSalary()));
                PaymentMovement paymentMovement = paymentMovementService.createPaymentMovement(bankAccount, instructor.getName() + " maas odemesi", MovementType.OUTCOME, instructor.getSalary());

                addPaymentMovementToDanceCourse(danceCourse, paymentMovement);

                if (danceCourse.getInstructorList() != null) {

                    danceCourse.getInstructorList().add(instructor);

                } else {

                    danceCourse.setInstructorList(List.of(instructor));

                }

            } else {

                System.err.println("Yeterli bakiyesi olan banka hesabi yok.");

            }

        } else {

            System.err.println("Banka hesabi olmadigi icin ogretmen alinamaz.");

        }

    }

    public void addPaymentMovementToDanceCourse(DanceCourse danceCourse, PaymentMovement paymentMovement) {
        if (danceCourse.getPaymentMovementList() != null) {
            danceCourse.getPaymentMovementList().add(paymentMovement);
        } else {
            danceCourse.setPaymentMovementList(List.of(paymentMovement));
        }
    }

}
