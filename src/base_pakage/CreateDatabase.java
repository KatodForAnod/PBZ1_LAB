package base_pakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
    private Connection c;
    private Statement stmt;

    public CreateDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndDatabase", "postgres", "12345678");


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private void createTable() {
        try {
            String sql;
            stmt = c.createStatement();
            sql = "CREATE TABLE SUPPLIERS " +
                    "(P               TEXT PRIMARY KEY     NOT NULL," +
                    " NAME_P          TEXT     NOT NULL, " +
                    " STATUS          INT      NOT NULL, " +
                    " CITY            TEXT     NOT NULL)";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE DETAILS " +
                    "(D               TEXT PRIMARY KEY     NOT NULL," +
                    " NAME_D          TEXT     NOT NULL, " +
                    " COLOR           TEXT     NOT NULL, " +
                    " SIZE            INT      NOT NULL," +
                    " CITY            TEXT     NOT NULL)";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE PROJECTS " +
                    "(PR               TEXT PRIMARY KEY     NOT NULL," +
                    " NAME_PR          TEXT     NOT NULL, " +
                    " CITY             TEXT     NOT NULL)";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE SUPPLIER_DETAIL_PROJECT_AMOUNT " +
                    "(P         TEXT      NOT NULL," +
                    " D         TEXT      NOT NULL, " +
                    " PR        TEXT      NOT NULL," +
                    " S         INT NOT NULL)";
            stmt.executeUpdate(sql);

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private void insertRows() {
        try {
            String sql;
            stmt = c.createStatement();
            sql = "INSERT INTO  (CODE_NUMBER_GROUP,CODE_NUMBER_SUBJECT,PERSONAL_NUMBER,AUDIENCE_NUMBER) VALUES ('10G', '12P', '222L', 210);";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
