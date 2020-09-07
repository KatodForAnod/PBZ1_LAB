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
/*
            //-------------- CREATE TABLE ---------------
            stmt = c.createStatement();
            sql = "CREATE TABLE TEACHER_TEACH_SUBJECTS_IN_GROUPS " +
                    "(CODE_NUMBER_GROUP        TEXT PRIMARY KEY     NOT NULL," +
                    " CODE_NUMBER_SUBJECT      TEXT     NOT NULL, " +
                    " PERSONAL_NUMBER          TEXT     NOT NULL, " +
                    " AUDIENCE_NUMBER          INT      NOT NULL)";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            System.out.println("-- Table created successfully");

            //--------------- INSERT ROWS ---------------
            stmt = c.createStatement();
            sql = "INSERT INTO TEACHER_TEACH_SUBJECTS_IN_GROUPS (CODE_NUMBER_GROUP,CODE_NUMBER_SUBJECT,PERSONAL_NUMBER,AUDIENCE_NUMBER) VALUES ('10G', '12P', '222L', 210);";
            stmt.executeUpdate(sql);

            stmt = c.createStatement();
            sql = "INSERT INTO TEACHER_TEACH_SUBJECTS_IN_GROUPS (CODE_NUMBER_GROUP,CODE_NUMBER_SUBJECT,PERSONAL_NUMBER,AUDIENCE_NUMBER) VALUES ('10G', '22P', '110L', 210);";
            stmt.executeUpdate(sql);



            stmt.close();
            c.commit();
            System.out.println("-- Records created successfully");


            //-------------- UPDATE DATA ------------------
            stmt = c.createStatement();
            sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();

            System.out.println("-- Operation UPDATE done successfully");


            //--------------- SELECT DATA ------------------
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println(String.format("ID=%s NAME=%s AGE=%s ADDRESS=%s SALARY=%s", id, name, age, address, salary));
            }
            rs.close();
            stmt.close();
            c.commit();
            System.out.println("-- Operation SELECT done successfully");


            //-------------- DELETE DATA ----------------------
            stmt = c.createStatement();
            sql = "DELETE from COMPANY where ID=2;";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            System.out.println("-- Operation DELETE done successfully");


            c.close();
*/
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-- All Operations done successfully");
    }

    public static void main(String[] args) {
        WorkWithDatabase a = new WorkWithDatabase();
    }
}
