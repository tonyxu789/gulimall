package com.xhc.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhc.common.utils.PageUtils;
import com.xhc.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author xuhuacheng
 * @email xuhuac@foxmail.com
 * @date 2026-01-13 18:50:27
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> list);
}

