package base_pakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void TestDatabase() {

        Connection c;
        Statement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/testbase", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
            String sql;

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-- All Operations done successfully");
    }

    public static void main(String[] args) {
        WorkWithDatabase a = new WorkWithDatabase();
        // WorkWith2ndDatabase b = new WorkWith2ndDatabase();
    }
}
