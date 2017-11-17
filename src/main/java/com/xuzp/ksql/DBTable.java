package com.xuzp.ksql;

import lombok.Data;

import java.util.List;

/**
 * @author za-xuzhiping
 * @Date 2017/11/15
 * @Time 18:23
 * @Copyright @2017 Zhongan.com All right reserved
 */
@Data
public class DBTable {

    private String tableName;

    private String remark;



    private List<DBColumn> columns;

}
