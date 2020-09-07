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
            /*
            databaseTeachers("SELECT * FROM teachers;");
            databaseStudentGroup("SELECT * FROM student_group " +
                    "WHERE speciality = 'ЭВМ';");
            */
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

    private void databaseTeachers(String sqlCommand) {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sqlCommand);

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

    private void databaseStudentGroup(String sqlCommand) {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sqlCommand);

            int counter = 1;
            while (rs.next()) {

                String codeNumberGroup = rs.getString("code_number_group");
                String nameGroup = rs.getString("name_group");
                String numberOfPpl = String.valueOf(rs.getInt("number_of_ppl"));
                String speciality = rs.getString("speciality");
                String surnameOfHeadman = rs.getString("surname_of_headman");

                printTable(counter, codeNumberGroup, nameGroup, numberOfPpl,
                        speciality, surnameOfHeadman);
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

    private void databaseSubject(String sqlCommand) {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sqlCommand);

            int counter = 1;
            while (rs.next()) {

                String codeNumberSubject = rs.getString("code_number_subject");
                String nameSubject = rs.getString("name_subject");
                String numberOfHours = String.valueOf(rs.getInt("number_of_hours"));
                String speciality = rs.getString("speciality");
                String semester = String.valueOf(rs.getInt("semester"));

                printTable(counter, codeNumberSubject, nameSubject, numberOfHours,
                        speciality, semester);
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

    private void databaseTeacherTeachSubjectsInGroups(String sqlCommand) {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sqlCommand);

            int counter = 1;
            while (rs.next()) {

                String codeNumberGroup = rs.getString("code_number_group");
                String codeNumberSubject = rs.getString("code_number_subject");
                String personalNumber = rs.getString("personal_number");
                String audienceNumber = String.valueOf(rs.getInt("audience_number"));

                printTable(counter, codeNumberGroup, codeNumberSubject,
                        personalNumber, audienceNumber);
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
