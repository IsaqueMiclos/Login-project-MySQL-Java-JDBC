package Service;

import Database_Connection.DatabaseConnection;
import Model.AccountModel;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class UserDAO {
    public void createNewAcrccount(AccountModel accountModel) {
        String sql = "INSERT INTO users (username,password,email,surname) values (?,?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setString(1,accountModel.getUsername());
            ps.setString(2,accountModel.getPassword());
            ps.setString(3,accountModel.getEmail());
            ps.setString(4,accountModel.getSurname());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.out.println("ERROR, please check the infos and try again! " + e.getMessage());
            return;
        }
        System.out.println("Welcome " + accountModel.getUsername());
    }

    public void login(String email,String password) {
        try {
            ResultSet resultSetUsers = DatabaseConnection.getConnection().createStatement().executeQuery("SELECT * FROM users");
            while (resultSetUsers.next()) {
                if (resultSetUsers.getString("email").equals(email) && resultSetUsers.getString("password").equals(password)) {
                    System.out.println("login successful!");
                    System.out.println("Welcome back " + resultSetUsers.getString("username"));
                    return;
                }
            }
            System.out.println("Login unsuccessful, please check the email or password!");
        } catch (SQLException ex) {
            System.out.println("ERROR " + ex.getMessage());
        }
    }
}
