package com.tao.sell.repsonsitory;

import com.tao.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepsonsitory extends JpaRepository<OrderDetail,String>
{
    // master 表的orderID 对应 detail表的多条记录
 List<OrderDetail> findByOrderId(String orderId);
}
