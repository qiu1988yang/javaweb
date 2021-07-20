package com.qy.demo.demo.one.mapper;

import com.qy.demo.demo.one.entity.TbItemOne;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-07-17
 */

public interface TbItemOneMapper extends BaseMapper<TbItemOne> {

    @Select("select * from tb_item_one where id = #{id} limit 1")
    TbItemOne getByProdId(@Param("id") Integer prodId);

    @Delete("DELETE FROM tb_item_one WHERE id = #{id}")
    void delRelationByProdId(@Param("id") Integer prodId);


    TbItemOne getByBizUserId(@Param("bizUserId") Integer bizUserId);


    String getUserIdByUnionId(@Param("bizUserId") Integer bizUserId);

}
