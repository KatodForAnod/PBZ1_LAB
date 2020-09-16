package base_pakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WorkWith2ndDatabase {
    private Connection c;
    private Statement stmt;

    public WorkWith2ndDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndDatabase", "postgres", "12345678");
            task26();

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

            sql = "INSERT INTO SUPPLIERS (P,NAME_P,STATUS,CITY) VALUES " +
                    "('P1','Петров',20,'Москва')," +
                    "('P2','Синицин',10,'Таллинн')," +
                    "('P3','Федоров',30,'Таллинн')," +
                    "('P4','Чаянов',20,'Минск')," +
                    "('P5','Крюков',30,'Киев');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO DETAILS (D,NAME_D,COLOR,SIZE,CITY) VALUES " +
                    "('D1','Болт','Красный',12,'Москва')," +
                    "('D2','Гайка','Зеленый',17,'Минск')," +
                    "('D3','Диск','Черный',17,'Вильнюс')," +
                    "('D4','Диск','Черный',14,'Москва')," +
                    "('D5','Корпус','Красный',12,'Минск')," +
                    "('D6','Крышки','Красный',19,'Москва');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO PROJECTS (PR,NAME_PR,CITY) VALUES " +
                    "('PR1','ИПР1','Минск')," +
                    "('PR2','ИПР2','Таллинн')," +
                    "('PR3','ИПР3','Псков')," +
                    "('PR4','ИПР4','Псков')," +
                    "('PR5','ИПР5','Москва')," +
                    "('PR6','ИПР6','Саратов')," +
                    "('PR7','ИПР7','Москва');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO SUPPLIER_DETAIL_PROJECT_AMOUNT (P,D,PR,S) VALUES " +
                    "('P1','D1','PR1',200)," +
                    "('P1','D1','PR2',700)," +
                    "('P2','D3','PR1',400)," +
                    "('P2','D2','PR2',200)," +
                    "('P2','D3','PR3',200)," +
                    "('P2','D3','PR4',500)," +
                    "('P2','D3','PR5',600)," +
                    "('P2','D3','PR6',400)," +
                    "('P2','D3','PR7',800)," +
                    "('P2','D5','PR2',100)," +
                    "('P3','D3','PR1',200)," +
                    "('P3','D4','PR2',500)," +
                    "('P4','D6','PR3',300)," +
                    "('P4','D6','PR7',300)," +
                    "('P5','D2','PR2',200)," +
                    "('P5','D2','PR4',100)," +
                    "('P5','D5','PR5',500)," +
                    "('P5','D5','PR7',100)," +
                    "('P5','D6','PR2',200)," +
                    "('P5','D1','PR2',100)," +
                    "('P5','D3','PR4',200)," +
                    "('P5','D4','PR4',800)," +
                    "('P5','D5','PR4',400)," +
                    "('P5','D6','PR4',500);";
            stmt.executeUpdate(sql);

            stmt.close();
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

    private void task29() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pr " +
                    "FROM SUPPLIER_DETAIL_PROJECT_AMOUNT " +
                    "EXCEPT " +
                    "(SELECT pr " +
                    "FROM SUPPLIER_DETAIL_PROJECT_AMOUNT " +
                    "WHERE p != 'P1');");

            int counter = 1;
            while (rs.next()) {

                String pr = rs.getString("pr");

                printTable(counter, pr);
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

    private void task1() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * " +
                    "FROM projects;");

            int counter = 1;
            while (rs.next()) {

                String pr = rs.getString("pr");
                String namePR = rs.getString("name_pr");
                String city = rs.getString("city");

                printTable(counter, pr, namePR, city);
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
            ResultSet rs = stmt.executeQuery("SELECT SUPPLIER_DETAIL_PROJECT_AMOUNT.d " +
                    "FROM suppliers, SUPPLIER_DETAIL_PROJECT_AMOUNT " +
                    "WHERE suppliers.p = SUPPLIER_DETAIL_PROJECT_AMOUNT.p " +
                    "AND suppliers.city = 'Лондон';");

            int counter = 1;
            while (rs.next()) {

                String d = rs.getString("d");

                printTable(counter, d);
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

    private void task18() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d, pr " +
                    "FROM SUPPLIER_DETAIL_PROJECT_AMOUNT " +
                    "WHERE s > (SELECT AVG(s) FROM SUPPLIER_DETAIL_PROJECT_AMOUNT);");

            int counter = 1;
            while (rs.next()) {

                String d = rs.getString("d");
                String pr = rs.getString("pr");
                printTable(counter, d, pr);
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

    private void task19() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p, pr " +
                    "FROM SUPPLIER_DETAIL_PROJECT_AMOUNT " +
                    "WHERE p = 'P1';");

            int counter = 1;
            while (rs.next()) {

                String p = rs.getString("p");
                String pr = rs.getString("pr");
                printTable(counter, p, pr);
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

    private void task23() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT a.p " +
                    "FROM details, SUPPLIER_DETAIL_PROJECT_AMOUNT a " +
                    "WHERE details.d = a.d " +
                    "AND details.color = 'Красный';");

            int counter = 1;
            while (rs.next()) {
                String p = rs.getString("p");

                printTable(counter, p);
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

    private void task25() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT pr,city " +
                    "FROM projects " +
                    "WHERE city = (SELECT city " +
                    "FROM projects " +
                    "ORDER BY city " +
                    "LIMIT 1);");

            int counter = 1;
            while (rs.next()) {

                String p = rs.getString("city");
                String pr = rs.getString("pr");
                printTable(counter, p, pr);
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
            ResultSet rs = stmt.executeQuery("SELECT * " +
                    "FROM SUPPLIER_DETAIL_PROJECT_AMOUNT " +
                    "WHERE s BETWEEN 300 AND 750;");

            int counter = 1;
            while (rs.next()) {
                String p = rs.getString("p");
                String pr = rs.getString("pr");
                String s = rs.getString("s");

                printTable(counter, p, pr, s);
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

    private void task26() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT a.pr " +
                    "FROM (SELECT d, pr,  " +
                    "AVG(s) as avg " +
                    "FROM SUPPLIER_DETAIL_PROJECT_AMOUNT " +
                    "WHERE d = 'D1' " +
                    "GROUP BY d, pr) a " +
                    "WHERE a.avg > (SELECT MAX(s) as max " +
                    "FROM SUPPLIER_DETAIL_PROJECT_AMOUNT " +
                    "WHERE pr = 'PR1');");

            int counter = 1;
            while (rs.next()) {

                String pr = rs.getString("pr");

                printTable(counter, pr);
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
