package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author xuhuacheng
 * @email xuhuac@foxmail.com
 * @date 2026-01-14 01:54:52
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
