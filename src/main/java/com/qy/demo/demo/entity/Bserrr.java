package com.qy.demo.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.annotation.security.DenyAll;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@ToString
public class Bserrr {
    @NotBlank(message = "请输入名称")
    @Length(message = "名称不能超过个 {max} 字符", max = 10)
    private String name;

    @NotBlank(message = "请输入名称")
    @Length(message = "名称不能超过个 {max} 字符", max = 10)
    private Integer age;

    @Size(max=10,min=5,message = "字段长度要在5-10之间")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",message = "不满足邮箱正则表达式")
    private String email;

    @AssertTrue(message = "字段为true才能通过")
    private boolean isSave;
    @Future(message = "时间在当前时间之后才可以通过")
    private Date date;


}
