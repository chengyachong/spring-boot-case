package com.cyc.springboot;

import com.cyc.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

/**
 * SpringBoot单元测试
 *
 * 可以在测试期间
 */
@SpringBootTest
class SpringbootHelloworldQuickApplicationTests {

    @Test
    void contextLoads() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

}
