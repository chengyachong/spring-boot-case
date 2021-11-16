package com.cyc.springboot.test;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * 函数式接口 没有参数有返回值
 */
public class SupplierTest {
    public static void main(String[] args) {
        fun1(()->{
            int array[] = {22,33,55,66};
            Arrays.sort(array);
            return array[array.length-1];
        });
    }
    private  static void fun1(Supplier<Integer> supplier){
        Integer max = supplier.get();
        System.out.println("max="+max);
    }
}
