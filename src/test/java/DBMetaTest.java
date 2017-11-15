import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBMetaTest {
    private Connection connection;
    private Statement statement;
    private String META_COLUMNS = "show columns in city";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/world?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";

    public static void main(String[] args) throws Exception {
        DBMetaTest test = new DBMetaTest();
        test.initConnection(JDBC_DRIVER,
                DB_URL
                , "root"
                , "123456");
        StringBuffer sb = new StringBuffer();
        ResultSet resultSet = test.getMetaDataTables();
        List<String> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(resultSet.getString(1));
        }
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

    public ResultSet getMetaDataTables() throws Exception {
        String sql = "show tables ";
        ResultSet rs = this.statement.executeQuery(sql);
        return rs;
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