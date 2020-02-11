package dao;

import entities.Company;
import exceptions.ExistException;
import exceptions.NotExistException;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompanyDBDAO implements CompanyDAO {

    private Connection connection;

    public CompanyDBDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db" + "?user=root"
                    + "&password=root" + "&useUnicode=true" + "&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false" + "&serverTimezone=UTC"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Company getByName(String companyName) {
        Company company = null;

        String sql = "SELECT * FROM COMPANY WHERE NAME = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, companyName);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String password = resultSet.getString(3);
                company = new Company(id, companyName, password);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return company;
    }


    @Override
    public Company getById(long companyId) throws NotExistException {
        Company company = null;

        String sql = "SELECT * FROM COMPANY WHERE ID = ?";

        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setLong(1, companyId);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                company = new Company(companyId, name, password);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        if (company == null) {
            throw new NotExistException(String.format("Company by the id: %d does not exists", companyId));
        }

        return company;
    }



    @Override
    public Company create(Company company) throws ExistException {
        if (getByName(company.getName()) != null) {
            throw new ExistException(String.format("Company by the name %s already exists", company.getName()));
        }

        String sql = "INSERT INTO COMPANY (NAME, PASSWORD) VALUES (? ,?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, company.getName());
            pstmt.setString(2, company.getPassword());

            pstmt.executeUpdate();

            ResultSet resultSet = pstmt.getGeneratedKeys();
            
            if (resultSet.next()) {
                company.setId(resultSet.getLong(1));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return company;

    }

    @Override
    public Company update(Company company) throws NotExistException {
        return null;
    }

    @Override
    public Company delete(long companyId) throws NotExistException {
        return null;
    }

    @Override
    public List<Company> getAll() {
        return null;
    }

    @Override
    public boolean login(String name, String password) {
        return false;
    }
}
