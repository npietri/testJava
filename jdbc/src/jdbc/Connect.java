package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/Ecole";
            String user = "postgres";
            String passwd = "manolo";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection succeded !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}