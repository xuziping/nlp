import com.google.common.collect.Lists;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.List;


public class DBMetaTest {
    private Connection connection;
    private Statement statement;


    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/world?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
    private static final String USERNAME = "root";
    private static final String PWD = "123456";

    private static final String QUERY_TABLE_COMMENT = "show create table {0}";
    private static final String QUERY_ALL_TABLE = "show tables";
    private static final String QUERY_TABLE_METAMETA_COLUMNS = "show columns in {0}";

    public static void main(String[] args) throws Exception {
        DBMetaTest test = new DBMetaTest();
        test.initConnection(JDBC_DRIVER, DB_URL, USERNAME, PWD);
        List<String> list = test.getMetaDataTables();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\n" + "table:" + list.get(0) + "\n");
            test.displayMetaData(test.getMetaDataFromTable("sys_user"));
        }
    }

    public void initConnection(String driverClass, String dbUrl, String username, String password) throws Exception {
        Class.forName(driverClass);
        this.connection = DriverManager.getConnection(dbUrl, username, password);
        this.statement = this.connection.createStatement();
    }

    public List<String> getMetaDataTables() throws Exception {
        List<String> list = Lists.newArrayList();
        try(ResultSet rs = this.statement.executeQuery(QUERY_ALL_TABLE)){
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        }
        return list;
    }


    public String getTableComments() throws Exception {
        String comment = null;
        try(ResultSet rs = this.statement.executeQuery(QUERY_TABLE_COMMENT)){
            if (rs.next()) {
                comment = rs.getString(2);
            }
        }
        return comment;
    }

    public static String parseComment(String all) {
        String comment = null;
        int index = all.indexOf("COMMENT='");
        if (index < 0) {
            return "";
        }
        comment = all.substring(index + 9);
        comment = comment.substring(0, comment.length() - 1);
        try {
            comment = new String(comment.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return comment;
    }

    public ResultSetMetaData getMetaDataFromTable(String tableName) throws Exception {
        String sql = "SELECT * FROM " + tableName.toUpperCase() + " WHERE 1 != 1";
        ResultSet rs = this.statement.executeQuery(sql);
        return rs.getMetaData();
    }


    public void displayMetaData(ResultSetMetaData metaData) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            sb.append("\n");
            sb.append(metaData.getTableName(i + 1));
            sb.append(".");
            sb.append(metaData.getColumnName(i + 1));
            sb.append("|");
            sb.append(metaData.getColumnType(i + 1));
            sb.append("|");
            sb.append(metaData.getColumnTypeName(i + 1));
            sb.append("|");
            sb.append(metaData.getColumnDisplaySize(i + 1));
            sb.append("|");
        }
        System.out.println(sb.toString());
    }
}