package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author xuhuacheng
 * @email xuhuac@foxmail.com
 * @date 2026-01-14 01:16:26
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
