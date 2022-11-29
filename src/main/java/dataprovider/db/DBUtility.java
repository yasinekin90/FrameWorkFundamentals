package dataprovider.db;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {


    ResultSetMetaData rsmd;
    private String url;
    private String username;
    private String password;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String sql;

    public DBUtility(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<List<String>> getData(String sql){
        List<List<String>> lists = new ArrayList<>();
        try {
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                List<String> rowList = new ArrayList<>();

                for (int i = 1; i <= columnCount; i++) {
                    rowList.add(rs.getString(i));
                }

                lists.add(rowList);
            }
            return lists;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getDataWithHeaders(String sql){
        try {
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <=columnCount ; i++) {
                System.out.printf("%-20s",rsmd.getColumnName(i));
            }
            System.out.println();
            while (rs.next()){
                for (int i = 1; i <=columnCount ; i++) {
                    System.out.printf("%-20s",rs.getObject(i));
                }
                System.out.println();
            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close(){
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
