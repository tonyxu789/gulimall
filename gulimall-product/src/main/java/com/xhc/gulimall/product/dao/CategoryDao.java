package com.xhc.gulimall.product.dao;

import com.xhc.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xuhuacheng
 * @email xuhuac@foxmail.com
 * @date 2026-01-13 18:50:27
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
