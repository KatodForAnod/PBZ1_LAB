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
            insertRows();

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
}
