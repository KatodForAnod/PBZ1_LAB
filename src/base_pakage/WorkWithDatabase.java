package base_pakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class WorkWithDatabase {
    private Connection c;
    private Statement stmt;

    public void WorkWithDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/testbase", "postgres", "12345678");
            //c.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
