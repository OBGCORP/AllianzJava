import model.BankAccount;
import model.Branch;
import model.DanceCourse;
import service.BankAccountService;
import service.BranchService;
import service.DanceCourseService;
import service.InitialDataService;

import java.math.BigDecimal;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {


        DanceCourseService danceCourseService = new DanceCourseService();
        BankAccountService bankAccountService = new BankAccountService();
        BranchService branchService = new BranchService();

        List<Branch> branchList = InitialDataService.loadInitialDataForBranch();

        System.out.println(branchList);


        DanceCourse danceCourse = danceCourseService.createDanceCourse("Özçakır Dance School", "Eskişehir",
                "Tuğçe Özçakır", "98728998789", "Eskişehir");

        System.out.println(danceCourse.toString());

        BankAccount bankAccount = bankAccountService.createBankAccount("T.C. ZİRAAT BANKASI",
                "ÖZÇAKIR LİMİTED ŞİRKETİ", "TR1200002902343", new BigDecimal(100000));

        danceCourseService.createBankAccountToDanceCourse(danceCourse, bankAccount);
        System.out.println(danceCourse);

        BankAccount bankAccount1 = bankAccountService.createBankAccount("T.C. ZİRAAT BANKASI",
                "ÖZÇAKIR LİMİTED ŞİRKETİ", "TR1200002902343", new BigDecimal(200000));


        danceCourseService.createBankAccountToDanceCourse(danceCourse, bankAccount1);
        System.out.println(danceCourse);

        branchService.createBranchToBranchPool(branchList, "Halayy");


        System.out.println(branchList);


    }

}