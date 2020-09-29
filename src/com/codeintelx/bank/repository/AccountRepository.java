package com.codeintelx.bank.repository;
import com.codeintelx.bank.models.Account;

import java.sql.*;
import java.util.UUID;

public class AccountRepository {
    public Account createAccount(String accountID, String accountType, String customerName, double balance) throws SQLException {
        UUID uuid = UUID.randomUUID();
        String accountId =
                Long.toString(uuid.getMostSignificantBits()).substring(1, 11).replace("-", " ");


        String url="jdbc:mysql://localhost:3306/mysql";
        String user="root";
        String password="Hunting123";

        Connection myConn=DriverManager.getConnection(url,user,password);
        Statement myStmt=myConn.createStatement();
        String sql= "insert into Accounts Values ('"+accountID +"','"+ customerName+"',"+accountType+" ' ,"+ balance;
        ResultSet rs= myStmt.executeQuery(sql);

        return null;
    }

}

