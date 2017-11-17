package com.xuzp.ksql;

import lombok.Data;

import java.util.List;

@Data
public class DBTable {

    private String tableName;

    private String remark;



    private List<DBColumn> columns;

}
