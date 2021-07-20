package com.qy.demo.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author jobob
 * @since 2021-07-15
 */
@TableName("tb_item")
@Data
@EqualsAndHashCode()
public class TbItem {

    private static final long serialVersionUID = 1L;

    @TableId(type= IdType.AUTO)		//主见注解，数据库ID自增
    private Long id;				//商品id
    /**
     * 商品标题
     */
    @NotBlank(message = "姓名不能为null")
    private String title;

    /**
     * 商品卖点
     */
    private String sellPoint;
    /**
     * 商品价格，单位为：分
     */
    private Long price;
    /**
     * 库存数量
     */
    private Integer num;
    /**
     * 商品条形码
     */
    private String barcode;
    /**
     * 商品图片
     */
    private String image;
    /**
     * 所属类目，叶子类目
     */
    private Long cid;
    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    private LocalDateTime created;
    /**
     * 更新时间
     */
    private LocalDateTime updated;

}
