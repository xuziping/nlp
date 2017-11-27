package com.xuzp.ksql;

import lombok.Data;

import java.util.List;

@Data
public class DBTable {

    /** 表名 */
    private String tableName;

    /** 表注释 */
    private String remark;

    /** 表所属数据库名 */
    private String tableCat;

    /** 表模式 */
    private String tableScheme;

    /** 表类型，可选值：TABLE */
    private String tableType;

    private String tableTypeName;

    private String tableTypeCat;

    private String tableTypeScheme;

    private String refGeneration;

    private String selfReferencingColName;

    private List<DBColumn> columns;

}
