package com.pengfeis.spr.mapper;

import com.pengfeis.spr.domain.RealOrder;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public interface RealOrderMapper {

    @SelectProvider(type = RealOrderSqlProvider.class, method = "insertRealOrderStmt")
    List<RealOrder> getAllRealOrders();

    @InsertProvider(type = RealOrderSqlProvider.class, method = "insertRealOrderStmt")
    List<RealOrder> insertRealOrder(RealOrder realOrder);
}

class RealOrderSqlProvider {
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
