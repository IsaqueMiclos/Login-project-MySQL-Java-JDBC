package Test;

import Database_Connection.DatabaseConnection;
import Model.AccountModel;
import Service.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountTest {
    public static void main(String[] args) {
        //Login system by Isaque Miclos, for Jesus glory
        UserDAO usrDao = new UserDAO();
        //Functions = login,createNewAccount
        //Login = email + password
        //createNewAccount = Class AccountModel(username + password + email + surname)
        //EX:
        //usrDao.createNewAcrccount(new AccountModel("Name","Password","Email","Surname"));
        //usrDao.login("email here","pass here");
    }
}