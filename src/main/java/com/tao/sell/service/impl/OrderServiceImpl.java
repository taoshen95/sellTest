package com.tao.sell.service.impl;

import com.tao.sell.dataobject.OrderDetail;
import com.tao.sell.dataobject.OrderMaster;
import com.tao.sell.dataobject.ProductInfo;
import com.tao.sell.dto.CartDTO;
import com.tao.sell.dto.OrderDTO;
import com.tao.sell.enums.OrderStatusEnum;
import com.tao.sell.enums.PayStatusEnum;
import com.tao.sell.enums.ResultEnums;
import com.tao.sell.exception.SellException;
import com.tao.sell.repsonsitory.OrderDetailRepsonsitory;
import com.tao.sell.repsonsitory.OrderMasterRepsonsitory;
import com.tao.sell.service.OrderService;
import com.tao.sell.service.ProductService;
import com.tao.sell.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepsonsitory orderDetailRepsonsitory;

    @Autowired
    private OrderMasterRepsonsitory orderMasterRepsonsitory;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        //创建订单的时候已经生成的orderId
        String orderId =KeyUtil.genUniqueKey();
        BigDecimal orderAmout=new BigDecimal(BigInteger.ZERO);
//        List<CartDTO> cartDTOList=new ArrayList<>();

        //1.查询商品（数量，价格） 先查一个 ProductService有查询一个的方法
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if(productInfo==null){
               throw  new SellException(ResultEnums.PRODUCT_NOT_EXIST);
            }
            //2.计算总价
            orderAmout =productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmout);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);//productInfo 属性拷贝到orderDetail
            orderDetailRepsonsitory.save(orderDetail);

//             CartDTO cartDTO=new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);
        }

        //3.写入订单到数据库（ordermaster /orderdetail）
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmout);//订单总价
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepsonsitory.save(orderMaster);

        //4.下单成功，扣库存
        //java8特性,注释掉的也可以用
        List<CartDTO> cartDTOList=
        orderDTO.getOrderDetailList().stream().map(e ->
                    new CartDTO(e.getProductId(),e.getProductQuantity()))
                        .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderid) {
        OrderMaster orderMaster = orderMasterRepsonsitory.findById(orderid).orElse(null);
        if (orderMaster==null){
         throw  new SellException(ResultEnums.ORDER_NOT_EXIST);
        }

        List<OrderDetail> orderDetailList = orderDetailRepsonsitory.findByOrderId(orderid);
        if (CollectionUtils.isEmpty(orderDetailList)){
            throw  new SellException(ResultEnums.ORDERDETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        //设置订单详情的列表
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyeropenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO canel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
