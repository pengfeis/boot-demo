package com.pengfeis.spr.mapper;

import com.pengfeis.spr.domain.RealOrder;
import com.pengfeis.spr.mapper.sqlprovider.RealOrderSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface RealOrderMapper {

    @SelectProvider(type = RealOrderSqlProvider.class, method = "getAllRealOrdersStmt")
    List<RealOrder> getAllRealOrders();

    @InsertProvider(type = RealOrderSqlProvider.class, method = "insertRealOrderStmt")
    List<RealOrder> insertRealOrder(RealOrder realOrder);
}
