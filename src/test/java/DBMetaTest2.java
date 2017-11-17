import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.*;


@Slf4j
public class DBMetaTest2 {

    static Connection con = null;

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/test?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8";
            Properties props = new Properties();
            props.setProperty("user", "root");
            props.setProperty("password", "123456");
            props.put("remarksReporting", "true");
            props.setProperty("remarks", "true"); //设置可以获取remarks信息
            props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
            con = DriverManager.getConnection(url, props);

            PreparedStatement pst = con
                    .prepareStatement("drop table if exists user;");

            pst.execute();

            pst = con
                    .prepareStatement("create table user(id int auto_increment primary key comment '主键啊',name varchar(20) not"
                            + " null comment '名称啊',age int default 18 comment '年龄啊',salary float(8,2) comment '薪水啊',rq date,sj time,rj timestamp);");

            pst.execute();

            String sql = "insert into user (name,age,salary,rq,sj,rj) values (?,?,?,?,?,?)";

            pst = con.prepareStatement(sql);

            for (int i = 1; i <= 10; i++) {

                pst.setString(1, "zs" + i);

                pst.setInt(2, 17 + i);

                pst.setFloat(3, 2600 + i * 100.0f);

                long time = System.currentTimeMillis();

                pst.setDate(4, new java.sql.Date(time));

                pst.setTime(5, new java.sql.Time(time));

                pst.setTimestamp(6, new java.sql.Timestamp(time));

                pst.addBatch();

            }

            pst.executeBatch();

            pst.close();

        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * DatabaseMetaData一些用法
     *
     * @throws Exception
     */
    public static void getDBInfo() throws Exception {

        DatabaseMetaData dbmd = con.getMetaData();

        System.out.println(dbmd.getDatabaseProductName());//获取数据库产品名称  

        System.out.println(dbmd.getDatabaseProductVersion());//获取数据库产品版本号  

        System.out.println(dbmd.getCatalogSeparator());//获取数据库用作类别和表名之间的分隔符   如test.user  

        System.out.println(dbmd.getDriverVersion());//获取驱动版本  

        System.out.println("*******************可用的数据库列表*********************");
        ResultSet rs = dbmd.getCatalogs();//取可在此数据库中使用的类别名,在mysql中说白了就是可用的数据库名称，只有一列  

        while (rs.next()) {
            System.out.println(rs.getString(1));
        }

        System.out.println("********************所有表********************************");
        /**
         * catalog 类别名称 
         * schemaPattern 用户方案模式， 
         * tableNamePattern 表 
         * types 类型 
         * 获取所有表 
         * dbmd.getTables(catalog, schemaPattern, tableNamePattern, types) 
         */
        rs = dbmd.getTables(null, "%", "user", new String[]{"TABLE"});

        while (rs.next()) {
            System.out.println("=========================");
            System.out.println(rs.getString(3) + "->" + rs.getString(4));//打印表类别,表模式,表名称，列名称，


            log("TABLE_CAT", rs);
            log("TABLE_SCHEM", rs);
            log("TABLE_NAME", rs);
            log("TABLE_TYPE", rs);
            log("REMARKS", rs);
            log("TYPE_CAT", rs);
            log("TYPE_SCHEM", rs);
            log("TYPE_NAME", rs);
            log("SELF_REFERENCING_COL_NAME", rs);
            log("REF_GENERATION", rs);

        }


        System.out.println("##############################################################");

        /**
         * catalog 类别名称 
         * schema 用户方案名称 
         * table 表名 
         * 获取指定表的主键信息 
         * dbmd.getPrimaryKeys(catalog, schema, table) 
         *
         */
        rs = dbmd.getPrimaryKeys("test", null, "user");

        while (rs.next()) {

            /**
             *  所有列信息如下: 
             *  TABLE_CAT String => 表类别（可为 null）  
             TABLE_SCHEM String => 表模式（可为 null）
             TABLE_NAME String => 表名称
             COLUMN_NAME String => 列名称
             KEY_SEQ short => 主键中的序列号（值 1 表示主键中的第一列，值 2 表示主键中的第二列）。
             PK_NAME String => 主键的名称（可为 null）

             */
            System.out.println("=========================");
            log("TABLE_CAT", rs);
            log("TABLE_SCHEM", rs);
            log("TABLE_NAME", rs);
            log("COLUMN_NAME", rs);
            logShort("KEY_SEQ", rs);
            log("PK_NAME", rs);

//            System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + ","
//                    + rs.getString(4) + "," + rs.getShort(5) + "," + rs.getString(6));

        }


        System.out.println("##############################################################");

        /**
         * catalog 类别名称 
         * schemaPattern 用户方案，模式 
         * tableNamePattern 表 
         * columnNamePattern 列 
         * 获取表的列信息 
         * dbmd.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern) 
         */
        rs = dbmd.getColumns("test", null, "user", "%");

        while (rs.next()) {
//            System.out.println(rs.getString("COLUMN_NAME") + " 类型=" + rs.getInt("DATA_TYPE") + " 列大小=" + rs.getInt("COLUMN_SIZE") +
//                    " 注释=" + rs.getString("REMARKS") +
//                    " 是否允许为NULL=" + rs.getInt("NULLABLE"));
            System.out.println("=========================");

            log("TABLE_CAT", rs);
            log("TABLE_SCHEM", rs);
            log("TABLE_NAME", rs);
            log("COLUMN_NAME", rs);
            logInt("DATA_TYPE", rs);
            log("TYPE_NAME", rs);
            logInt("COLUMN_SIZE", rs);
            logInt("DECIMAL_DIGITS", rs);
            logInt("NUM_PREC_RADIX", rs);
            logInt("NULLABLE", rs);
            log("REMARKS", rs);
            log("COLUMN_DEF", rs);
            logInt("CHAR_OCTET_LENGTH", rs);
            logInt("ORDINAL_POSITION", rs);
            log("IS_NULLABLE", rs);
            log("SCOPE_SCHEMA", rs);
            log("SCOPE_TABLE", rs);
            log("SOURCE_DATA_TYPE", rs);
            log("IS_AUTOINCREMENT", rs);
            /**
             * 所有列如下： 
             * TABLE_CAT String => 表类别（可为 null）  
             TABLE_SCHEM String => 表模式（可为 null）
             TABLE_NAME String => 表名称
             COLUMN_NAME String => 列名称
             DATA_TYPE int => 来自 java.sql.Types 的 SQL 类型
             TYPE_NAME String => 数据源依赖的类型名称，对于 UDT，该类型名称是完全限定的
             COLUMN_SIZE int => 列的大小。
             BUFFER_LENGTH 未被使用。
             DECIMAL_DIGITS int => 小数部分的位数。对于 DECIMAL_DIGITS 不适用的数据类型，则返回 Null。
             NUM_PREC_RADIX int => 基数（通常为 10 或 2）
             NULLABLE int => 是否允许使用 NULL。
             columnNoNulls - 可能不允许使用 NULL 值
             columnNullable - 明确允许使用 NULL 值
             columnNullableUnknown - 不知道是否可使用 null
             REMARKS String => 描述列的注释（可为 null）
             COLUMN_DEF String => 该列的默认值，当值在单引号内时应被解释为一个字符串（可为 null）
             SQL_DATA_TYPE int => 未使用
             SQL_DATETIME_SUB int => 未使用
             CHAR_OCTET_LENGTH int => 对于 char 类型，该长度是列中的最大字节数
             ORDINAL_POSITION int => 表中的列的索引（从 1 开始）
             IS_NULLABLE String => ISO 规则用于确定列是否包括 null。
             YES --- 如果参数可以包括 NULL
             NO --- 如果参数不可以包括 NULL
             空字符串 --- 如果不知道参数是否可以包括 null
             SCOPE_CATLOG String => 表的类别，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null）
             SCOPE_SCHEMA String => 表的模式，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null）
             SCOPE_TABLE String => 表名称，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null）
             SOURCE_DATA_TYPE short => 不同类型或用户生成 Ref 类型、来自 java.sql.Types 的 SQL 类型的源类型（如果 DATA_TYPE 不是 DISTINCT 或用户生成的 REF，则为 null）
             IS_AUTOINCREMENT String => 指示此列是否自动增加
             YES --- 如果该列自动增加
             NO --- 如果该列不自动增加
             空字符串 --- 如果不能确定该列是否是自动增加参数

             */

        }

        rs = dbmd.getExportedKeys("test", null, "user");

        while (rs.next()) {
            System.out.println("=========================");

            log("PKTABLE_CAT", rs);
            log("PKTABLE_SCHEM", rs);
            log("PKTABLE_NAME", rs);
            log("PKCOLUMN_NAME", rs);
            log("FKTABLE_CAT", rs);
            log("FKTABLE_SCHEM", rs);
            log("FKTABLE_NAME", rs);
            log("FKCOLUMN_NAME", rs);
            logShort("KEY_SEQ", rs);
            logShort("UPDATE_RULE", rs);
            logShort("DELETE_RULE", rs);
        }
    }

    public static void log(String col, ResultSet rs) throws Exception{
        log.info("{}:{}", col, rs.getString(col));
    }

    public static void logShort(String col, ResultSet rs) throws Exception{
        log.info("{}:{}", col, rs.getShort(col));
    }

    public static void logInt(String col, ResultSet rs) throws Exception{
        log.info("{}:{}", col, rs.getInt(col));
    }

    /**
     * ResultSetMetaData一些用法
     *
     * @throws Exception
     */
    public static void getRsInfo() throws Exception {

        PreparedStatement pst = con.prepareStatement("select * from user");

        ResultSet rs = pst.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();//结果集元  

        System.out.println("下面这些方法是ResultSetMetaData中方法");

        System.out.println("获得1列所在的Catalog名字 : " + rsmd.getCatalogName(1));

        System.out.println("获得1列对应数据类型的类 " + rsmd.getColumnClassName(1));

        System.out.println("获得该ResultSet所有列的数目 " + rsmd.getColumnCount());

        System.out.println("1列在数据库中类型的最大字符个数" + rsmd.getColumnDisplaySize(1));

        System.out.println(" 1列的默认的列的标题" + rsmd.getColumnLabel(1));

        //System.out.println("1列的模式" + rsmd.GetSchemaName(1));  

        System.out.println("1列的类型,返回SqlType中的编号 " + rsmd.getColumnType(1));

        System.out.println("1列在数据库中的类型，返回类型全名" + rsmd.getColumnTypeName(1));

        System.out.println("1列类型的精确度(类型的长度): " + rsmd.getPrecision(1));

        System.out.println("1列小数点后的位数 " + rsmd.getScale(1));

        System.out.println("1列对应的模式的名称（应该用于Oracle） " + rsmd.getSchemaName(1));

        System.out.println("1列对应的表名 " + rsmd.getTableName(1));

        System.out.println("1列是否自动递增" + rsmd.isAutoIncrement(1));

        System.out.println("1列在数据库中是否为货币型" + rsmd.isCurrency(1));

        System.out.println("1列是否为空" + rsmd.isNullable(1));

        System.out.println("1列是否为只读" + rsmd.isReadOnly(1));

        System.out.println("1列能否出现在where中" + rsmd.isSearchable(1));


        rs.close();

        pst.close();

    }

    public static void main(String[] args) throws Exception {


        try {
//            List list = getTableInfo("user");
//            System.out.println(list);
            getRsInfo();
            getDBInfo();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static List getTableInfo(String table) {

        List result = new ArrayList();
        DatabaseMetaData dbmd = null;

        try {

            dbmd = con.getMetaData();
            ResultSet resultSet = dbmd.getTables(null, "%", table, new String[]{"TABLE"});

            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                System.out.println(tableName);

                if (tableName.equals(table)) {
                    ResultSet rs = con.getMetaData().getColumns(null, getSchema(), tableName.toUpperCase(), "%");

                    while (rs.next()) {

                        //System.out.println("字段名："+rs.getString("COLUMN_NAME")+"--字段注释："+rs.getString("REMARKS")+"--字段数据类型："+rs.getString("TYPE_NAME"));
                        Map map = new HashMap();
                        String colName = rs.getString("COLUMN_NAME");
                        map.put("code", colName);

                        String remarks = rs.getString("REMARKS");
                        if (remarks == null || remarks.equals("")) {
                            remarks = colName;
                        }
                        map.put("name", remarks);

                        String dbType = rs.getString("TYPE_NAME");
                        map.put("dbType", dbType);

                        map.put("valueType", changeDbType(dbType));
                        result.add(map);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    //其他数据库不需要这个方法 oracle和db2需要
    private static String getSchema() throws Exception {
        String schema;
        schema = con.getMetaData().getUserName();
        if ((schema == null) || (schema.length() == 0)) {
            throw new Exception("ORACLE数据库模式不允许为空");
        }
        return schema.toUpperCase().toString();

    }

    private static String changeDbType(String dbType) {
        dbType = dbType.toUpperCase();
        switch (dbType) {
            case "VARCHAR":
            case "VARCHAR2":
            case "CHAR":
                return "1";
            case "NUMBER":
            case "DECIMAL":
                return "4";
            case "INT":
            case "SMALLINT":
            case "INTEGER":
                return "2";
            case "BIGINT":
                return "6";
            case "DATETIME":
            case "TIMESTAMP":
            case "DATE":
                return "7";
            default:
                return "1";
        }
    }
} 