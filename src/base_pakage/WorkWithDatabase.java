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
            databaseTeacherTeachSubjectsInGroups("SELECT personal_number, audience_number " +
                    "FROM teacher_teach_subjects_in_groups " +
                    "WHERE code_number_subject = '18P';");
            databaseSubject("SELECT DISTINCT e.code_number_subject, e.name_subject " +
                    "FROM subject e, teacher_teach_subjects_in_groups y " +
                    "WHERE e.code_number_subject = y.code_number_subject " +
                    "AND y.personal_number = (SELECT personal_number " +
                    "FROM teachers " +
                    "WHERE surname = 'Костин');");
            databaseTeacherTeachSubjectsInGroups("SELECT * " +
                    "FROM teacher_teach_subjects_in_groups " +
                    "WHERE personal_number = (SELECT personal_number " +
                    "FROM teachers " +
                    "WHERE surname = 'Фролов';");
            databaseSubject("SELECT * " +
                    "FROM subject " +
                    "WHERE speciality = 'АСОИ';");
            databaseTeachers("SELECT DISTINCT q.* " +
                    "FROM teachers q, (SELECT e.personal_number " +
                    "FROM teacher_teach_subjects_in_groups e, subject y " +
                    "WHERE e.code_number_subject = y.code_number_subject " +
                    "AND y.speciality = 'АСОИ') r " +
                    "WHERE q.personal_number = r.personal_number;");
            databaseTeachers("SELECT DISTINCT e.* " +
                    "FROM teachers e, teacher_teach_subjects_in_groups y " +
                    "WHERE e.personal_number = y.personal_number " +
                    "AND y.audience_number = 210;");
            databaseSubject("SELECT DISTINCT z.name_group, q.* " +
                    "FROM subject q, (SELECT e.*, y.name_group " +
                    "FROM teacher_teach_subjects_in_groups e, student_group y " +
                    "WHERE e.code_number_group = y.code_number_group " +
                    ") z " +
                    "WHERE q.code_number_subject = z.code_number_subject " +
                    "AND z.audience_number > 100 " +
                    "AND z.audience_number < 200;");
             */
            task15();
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

    private void task1(String sqlCommand) {
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

    private void task2(String sqlCommand) {
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

    private void task3() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT personal_number, audience_number " +
                    "FROM teacher_teach_subjects_in_groups " +
                    "WHERE code_number_subject = '18P';");

            int counter = 1;
            while (rs.next()) {

                String personalNumber = rs.getString("personal_number");
                String audienceNumber = String.valueOf(rs.getInt("audience_number"));

                printTable(counter, personalNumber, audienceNumber);
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

    private void task4() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT e.code_number_subject, e.name_subject " +
                    "FROM subject e, teacher_teach_subjects_in_groups y " +
                    "WHERE e.code_number_subject = y.code_number_subject " +
                    "AND y.personal_number = (SELECT personal_number " +
                    "FROM teachers " +
                    "WHERE surname = 'Костин');");

            int counter = 1;
            while (rs.next()) {

                String codeNumberSubject = rs.getString("code_number_subject");
                String nameSubject = rs.getString("name_subject");

                printTable(counter, codeNumberSubject, nameSubject);
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

    private void task5() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT code_number_subject " +
                    "FROM teacher_teach_subjects_in_groups " +
                    "WHERE personal_number = (SELECT personal_number " +
                    "FROM teachers " +
                    "WHERE surname = 'Фролов';");

            int counter = 1;
            while (rs.next()) {
                String codeNumberSubject = rs.getString("code_number_subject");

                printTable(counter, codeNumberSubject);
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

    private void task6() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * " +
                    "FROM subject " +
                    "WHERE speciality = 'АСОИ';");

            int counter = 1;
            while (rs.next()) {


                String codeNumberSubject = rs.getString("code_number_subject");
                String nameSubject = rs.getString("name_subject");
                String numberOfHours = String.valueOf(rs.getInt("number_of_hours"));
                String speciality = rs.getString("speciality");
                String semester = String.valueOf(rs.getInt("semester"));

                printTable(counter, codeNumberSubject, nameSubject,
                        numberOfHours, speciality, semester);
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

    private void task7() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT q.* " +
                    "FROM teachers q, (SELECT e.personal_number " +
                    "FROM teacher_teach_subjects_in_groups e, subject y " +
                    "WHERE e.code_number_subject = y.code_number_subject " +
                    "AND y.speciality = 'АСОИ') r " +
                    "WHERE q.personal_number = r.personal_number;");

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

    private void task8() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT e.surname " +
                    "FROM teachers e, teacher_teach_subjects_in_groups y " +
                    "WHERE e.personal_number = y.personal_number " +
                    "AND y.audience_number = 210;");

            int counter = 1;
            while (rs.next()) {
                String surname = rs.getString("surname");

                printTable(counter, surname);
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

    private void task9() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT z.name_group, q.name_subject " +
                    "FROM subject q, (SELECT e.*, y.name_group " +
                    "FROM teacher_teach_subjects_in_groups e, student_group y " +
                    "WHERE e.code_number_group = y.code_number_group " +
                    ") z " +
                    "WHERE q.code_number_subject = z.code_number_subject " +
                    "AND z.audience_number > 100 " +
                    "AND z.audience_number < 200;");

            int counter = 1;
            while (rs.next()) {

                String nameGroup = rs.getString("name_group");
                String nameSubject = rs.getString("name_subject");


                printTable(counter, nameGroup, nameSubject);
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

    private void tas10not() {
    }

    private void task11() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUM(number_of_ppl) " +
                    "FROM student_group " +
                    "WHERE speciality = 'ЭВМ';");

            int counter = 1;
            while (rs.next()) {
                String sumNumberOfPpl = String.valueOf(rs.getInt("SUM"));

                printTable(counter, sumNumberOfPpl);
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

    private void task12() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT y.personal_number " +
                    "FROM student_group e, teacher_teach_subjects_in_groups y " +
                    "WHERE e.code_number_group = y.code_number_group " +
                    "AND e.speciality = 'ЭВМ';");

            int counter = 1;
            while (rs.next()) {
                String personalNumber = rs.getString("personal_number");


                printTable(counter, personalNumber);
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

    private void task13not() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("s");

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

    private void task15() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT e.* " +
                    "FROM subject e, (SELECT code_number_subject " +
                    "FROM teacher_teach_subjects_in_groups " +
                    "WHERE personal_number != '221L') y " +
                    "WHERE e.code_number_subject = y.code_number_subject;");

            int counter = 1;
            while (rs.next()) {

                String codeNumberSubject = rs.getString("code_number_subject");
                String nameSubject = rs.getString("name_subject");
                String numberOfHours = String.valueOf(rs.getInt("number_of_hours"));
                String speciality = rs.getString("speciality");
                String semester = String.valueOf(rs.getInt("semester"));

                printTable(counter, codeNumberSubject, nameSubject,
                        numberOfHours, speciality, semester);
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
