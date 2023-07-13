package service;

import model.BankAccount;
import model.DanceCourse;
import model.Instructor;

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

        if(danceCourse.getBankAccountList()!=null) {
            if (danceCourse.getInstructorList()!= null) {
                BankAccount bankAccount = bankAccountService.getBankAccountWithEnoughMoney(danceCourse, instructor.getSalary());

                if(bankAccount != null) {

                } else {
                    System.err.println("Yeterli bakiyesi olan banka hesabi yok.");
                }

            } else {

            }

        } else {
            System.err.println("Banka hesabi olmadigi icin ogretmen alinamaz.");
        }

    }

}
