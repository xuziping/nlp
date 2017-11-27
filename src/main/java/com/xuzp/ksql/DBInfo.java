package com.xuzp.ksql;

import lombok.Data;

import java.util.List;

/**
 * @author za-xuzhiping
 * @Date 2017/11/27
 * @Time 17:42
 */
@Data
public class DBInfo {

    /** 数据库产品名称 */
    private String databaseProductName;

    /** 数据库产品版本号 */
    private String databaseProductVersion;

    /** 数据库用作类别和表名之间的分隔符 */
    private String catalogSeparator;

    /** 驱动版本 */
    private String driverVersion;

    /** 可用的数据库名称列表 */
    private List<String> catalogs;
}
