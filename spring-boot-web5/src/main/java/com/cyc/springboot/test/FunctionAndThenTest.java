package com.cyc.springboot.test;

import java.util.function.Function;

public class FunctionAndThenTest {
    public static void main(String[] args) {
          test(mag ->{
              return Integer.parseInt(mag);
          },msg2->{
              return msg2*10;
          });
    }
   public static void test(Function<String ,Integer> f1 , Function<Integer,Integer> f2) {
        Integer i1= f1.apply("6666");
        Integer i2 = f2.apply(i1);
        Integer t1 = f1.andThen(f2).apply("444");
       System.out.println(t1);
       System.out.println(i2);
   }
}
