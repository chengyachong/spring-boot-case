package com.cyc.springboot;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@DisplayName("测试junit5")
public class Junit5Test {
    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    void testParamterized(int i){
        System.out.println(i);
    }


    @DisplayName("测试前置条件")
    @Test
    void testAssumptions(){

    }


    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));

    }
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){


    }
  int cal(int i,int j){
        return i+j;
  }
    @DisplayName("测试displayName")
    @Test
    void  test01(){
        System.out.println("测试displayName");
    }
    @DisplayName("测试方法2")
    @Test
    void test02() {
        System.out.println("2");
    }
    @BeforeEach
    void testBeforEach(){
        System.out.println("测试就要开始了。。。。");
    }
    @AfterEach
    void afterEach(){
        System.out.println("测试结束了。。。。");
    }

    @BeforeAll
    static  void BeforAll(){
        System.out.println("所有测试就要开始了");
    }
    @AfterAll
    static  void afterAll(){
        System.out.println("所有的测试结束了");
    }
    @Timeout(value = 500 ,unit = TimeUnit.MILLISECONDS)
    @Test
    void  testTimeOut() throws InterruptedException {
       Thread.sleep(600);
    }


}
