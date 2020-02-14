package run;

import dao.CompanyDAO;
import dao.CompanyDBDAO;
import entities.Company;
import exceptions.ExistException;


public class Main {

    public static void main(String[] args) {

        Company company = new Company("Gorvex", "123");
        CompanyDAO dao = new CompanyDBDAO();

        try {
            company = dao.create(company);

            System.out.println(company);


        } catch (ExistException e) {
            System.out.println(e.getMessage());
        }
    }
}
