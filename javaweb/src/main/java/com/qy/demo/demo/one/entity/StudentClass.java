package com.qy.demo.demo.one.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "stuClass")
public class StudentClass {
    @TableId(value = "ClassId",type = IdType.AUTO)
    private Integer classId;
    @TableField(value = "ClassName")
    private String className;


   /* @TableField(exist = false)
    @OneToOne //一对一默认为立即加载，即@Lazy(false)或此时不标注
    @JoinColumn(name = "lao_gong_id", referencedColumnName = "man_id")
    private Man laoGong;
    */


}