package com.xhc.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhc.common.utils.PageUtils;
import com.xhc.gulimall.coupon.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author xuhuacheng
 * @email xuhuac@foxmail.com
 * @date 2026-01-13 22:55:54
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

