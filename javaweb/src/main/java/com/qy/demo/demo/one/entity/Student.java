package com.qy.demo.demo.one.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "student")
public class Student {
    @TableId(value = "Id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "SName",exist = true,select = true)
    private String name;
    @TableField(value = "Age")
    private int age;

    @TableField(value = "Cid")
    private int c_id;

    @TableField(value = "ClassId")
    private Integer classId;
    @TableField(exist = false)
    private StudentClass studentClass;

    @TableField(exist = false)
    private List<StudentClass> studentClassList;

    @TableField(exist = false)
    private List<StudentClass> studentClassList2;
}