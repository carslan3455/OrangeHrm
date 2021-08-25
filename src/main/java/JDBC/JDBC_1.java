package JDBC;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JDBC_1 {
    Connection conn;
    Statement stmt;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/deneme1",
                "root",
                "");
        stmt = conn.createStatement();
    }

    @Test
    public void conn_1() throws SQLException {

        ResultSet rs = stmt.executeQuery("SELECT * FROM personel LIMIT 10");

        while (rs.next()) {
//            int a= rs.getInt(0);
//            String b= rs.getString(1);
//            System.out.println(a + " - " +b );
            System.out.println(rs.getString(1) + "\t" +
                    rs.getString("first_name") + "\t" +
                    rs.getString(3)
            );
        }


    }


    @Test
    public void conn_2() throws SQLException {

        ResultSet rs = stmt.executeQuery("SELECT * FROM personel LIMIT 10");

        ResultSetMetaData rsmd = rs.getMetaData();
        int colNum = rsmd.getColumnCount();

        while (rs.next()) {
            for (int i = 0; i < colNum; i++) {

                int n = rsmd.getColumnDisplaySize(i);
                String format = "%-" + n + "s\t";
                System.out.printf(format, rs.getString(i));
//            System.out.println(rs.getString(i),"\t);
            }
        }
    }

    public void test1() throws SQLException {
        List<String> list = getListOf("SELECT first_name, last_name FROM personel LIMIT 10");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);

        }
    }

    public void test2() throws SQLException {


    }

    public void test3() throws SQLException {

        Map<String,String>  map = getMapOf("SELECT first_name, last_name FROM personel LIMIT 10");

        for (Map.Entry<String,String> e: map.entrySet()) {
            String kullanici = e.getKey();
            String sifre = e.getValue();
            System.out.println(kullanici+ " - " + sifre );

        }

    }

    public List<String> getListOf(String sql) throws SQLException {

        ResultSet rs = null;

        List<String> list = new LinkedList<>();

        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return list;
    }

    public List<List<String>> getListOfList(String sql) throws SQLException {

        ResultSet rs = null;

        List<List<String>> mainList = new LinkedList<>();
        List<String> innerList = new LinkedList<>();

        try {
            rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int colNum = rsmd.getColumnCount();

            while (rs.next()) {
                innerList = null;
                innerList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return mainList;
    }

    public Map<String, String> getMapOf(String sql) throws SQLException {

        ResultSet rs = null;

        Map<String, String> map = new HashMap<>();

        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return map;
    }


    @AfterTest
    public void afterTest() throws SQLException {

        stmt.close();
        conn.close();
    }
}
