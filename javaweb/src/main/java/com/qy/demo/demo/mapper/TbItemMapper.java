package com.qy.demo.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qy.demo.demo.entity.TbItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-07-15
 */
public interface TbItemMapper extends BaseMapper<TbItem> {


    @Select("select * from tb_item where id = #{itemId} limit 1")
    TbItem getByItemId(@Param("itemId") Integer itemId);

    @Select("select count(id) from tb_item where  id in #{itemIds}")
    int countItem( @Param("itemIds") String outerProdId);

   /* @Update("update tz_prod_outer set status = #{status} where id = #{id}")
    int updateOuterProductStatus(@Param("id") Long id, @Param("status") Integer status);*/

    @Select("select * from tb_item where 1 = 1 order by id asc limit #{pageSize} offset #{offset} ")
    List<TbItem> listNormalProd(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

    @Select("select id from tb_item order by id desc limit 1")
    int selectMaxId();


}
