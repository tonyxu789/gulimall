package com.xhc.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhc.common.utils.PageUtils;
import com.xhc.gulimall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author xuhuacheng
 * @email xuhuac@foxmail.com
 * @date 2026-01-13 18:50:27
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

