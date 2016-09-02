package com.wtech.answeringcall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Created by weldis on 31/08/16.
 */
public class BD {
    private static final String url = "jdbc:mysql://<server>:<port>/<database>";
    private static final String user = "<username>";
    private static final String pass = "<password>";

    public void testDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            /* System.out.println("Databaseection success"); */

            String result = "Database connection success\n";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from table_name");
            ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()) {
                result += rsmd.getColumnName(1) + ": " + rs.getInt(1) + "\n";
                result += rsmd.getColumnName(2) + ": " + rs.getString(2) + "\n";
                result += rsmd.getColumnName(3) + ": " + rs.getString(3) + "\n";
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}


