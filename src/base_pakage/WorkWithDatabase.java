package base_pakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.stream.Stream;

public class WorkWithDatabase {
    private Connection c;
    private Statement stmt;

    public WorkWithDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/testbase", "postgres", "12345678");

            //getInformationAboutAllTeachers();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private void printTable(int counter, String... strings) {
        System.out.print("\n" + counter);
        for (String i : strings) {
            System.out.print("| " + i + " | ");
        }
    }

    private void getInformationAboutAllTeachers() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teachers;");

            int counter = 1;
            while (rs.next()) {

                String personalNumber = rs.getString("personal_number");
                String surname = rs.getString("surname");
                String position = rs.getString("position");
                String department = rs.getString("department");
                String speciality = rs.getString("speciality");
                String homeNumber = String.valueOf(rs.getInt("home_number"));

                printTable(counter, personalNumber, surname, position, department,
                        speciality, homeNumber);
                counter++;
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
}
