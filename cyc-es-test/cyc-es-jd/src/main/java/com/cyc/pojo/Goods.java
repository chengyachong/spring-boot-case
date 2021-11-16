package com.cyc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    //图片
    private String img;
    //价格
    private String price;
    //名字
    private String name;
}
