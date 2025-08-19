package atm.simulator.system;

import java.sql.*;

public class Con {
    Connection connection;
    Statement statement;
    String url = "jdbc:mysql://localhost:3306/atm_simulator";
    public Con() {
        try {
            connection = DriverManager.getConnection(url,"root","KALIHACKER(7988)@.eagle.com.in");
            statement = connection.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
