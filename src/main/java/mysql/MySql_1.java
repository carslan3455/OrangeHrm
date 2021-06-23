package mysql;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class MySql_1 {

    Connection conn;
    Statement stmt;
    String strSQL;


    @BeforeClass
    public void beforeClass() {
        try {

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/deneme", "root", ""
            );

            stmt = conn.createStatement();


        } catch (Exception e) {     // todo spesifik Exeption SQLExeption
            e.printStackTrace();
        }

    }

    @Test
    public void sql_1() {

        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM personel");

            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        } catch (Exception e) {     // todo spesifik Exeption SQLExeption
            e.printStackTrace();
        }

    }

    @Test
    public void sql_2() {

        try {


            strSQL = "SELECT age, " +
                    "country, " +
                    "AVG(age) AS ort, " +
                    "MIN(age) AS min, " +
                    "MAX(age) AS max " +
                    "FROM (SELECT country, ROUND(DATEDIFF(current_date(), DATE(birt_date))/365) AS age FROM personel) AS tableAge " +
                    "GROUP BY country " +
                    "ORDER BY country " +
                    "LIMIT 1000;";

            ResultSet rs = stmt.executeQuery(strSQL);

            while (rs.next()) {
                System.out.println(rs.getString(1) + ", " +
                        "" + rs.getString(2) + ", " +
                        "" + rs.getString(3) + ", " +
                        "" + rs.getString(4) + ", " +
                        "" + rs.getString(5)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sql_3() {

        try {

            strSQL = "SELECT * FROM personel;";
            ResultSet rs = stmt.executeQuery(strSQL);

            ResultSetMetaData m = rs.getMetaData();

            int colNum = m.getColumnCount();
            System.out.println(colNum);
            System.out.println("-----------------------");

            while (rs.next()) {
                for (int i = 1; i <= colNum; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void preparedStatement() {
        try {
            PreparedStatement pStmt = conn.prepareStatement("INSERT INTO personel(id,first_name) VALUES(?,?)");

            pStmt.setInt(1,100);
            pStmt.setString(2,"Michael");
            pStmt.executeUpdate();

            System.out.println("Islem Basarili...");
            strSQL = "SELECT * FROM personel";

            ResultSet rs = stmt.executeQuery(strSQL);
            while (rs.next())
                System.out.println(rs.getString(2));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
