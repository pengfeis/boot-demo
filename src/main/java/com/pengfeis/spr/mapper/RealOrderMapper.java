package com.pengfeis.spr.mapper;

import com.pengfeis.spr.domain.RealOrder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RealOrderMapper {

    @Select("SELECT * FROM REAL_ORDER")
    List<RealOrder> getAllRealOrders();
}
