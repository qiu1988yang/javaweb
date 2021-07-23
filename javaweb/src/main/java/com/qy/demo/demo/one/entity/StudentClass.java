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
}