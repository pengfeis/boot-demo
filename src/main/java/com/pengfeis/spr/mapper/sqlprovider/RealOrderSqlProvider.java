package com.pengfeis.spr.mapper.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

public class RealOrderSqlProvider {
    public String getAllRealOrdersStmt() {
        return new SQL().SELECT("*").FROM("real_order").toString();
    }

    public String insertRealOrderStmt() {
        String sql = new SQL().INSERT_INTO("real_order")
                .VALUES("order_id", "#{orderId}")
                .VALUES("user_id", "#{userId}")
                .VALUES("user_name", "#{userName}")
                .VALUES("raw_price", "#{rawPrice}")
                .VALUES("total_amount", "#{totalAmount}")
                .VALUES("remark", "#{remark}")
                .VALUES("create_date", "#{createDate}")
                .VALUES("update_date", "#{updateDate}")
                .toString();
        return sql;
    }
}
