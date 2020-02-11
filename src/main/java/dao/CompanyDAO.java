package dao;

import entities.Company;
import exceptions.ExistException;
import exceptions.NotExistException;

import java.util.List;

public interface CompanyDAO {

    Company getById(long companyId) throws NotExistException;

    Company create(Company company) throws ExistException;

    Company update(Company company) throws NotExistException;

    Company delete(long companyId) throws NotExistException;

    List<Company> getAll();

    boolean login(String name, String password);
}
