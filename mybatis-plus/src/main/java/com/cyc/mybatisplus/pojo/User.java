package com.cyc.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type=IdType.NONE)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
     @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @Version
    private Integer version;
    @TableLogic
    private Integer deleteFlag;
}
