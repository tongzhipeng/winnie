
package com.java.learn;


import org.testng.annotations.*;

public class TestNG_Demo1 {
    public static String token_ = "";

    @BeforeClass
    public void setUp(){
        System.out.println("启动测试的前提条件准备，一般放这个方法中");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("测试运行结束后的步骤，一般是恢复环境到测试开始之前的状态");
    }


    @Test
    @Parameters({"Browser", "Server"})
    public void test1(@Optional("Chrome") String browser, @Optional("http://www.default.com") String server){
        System.out.println("Hello");
        System.out.println("这次启动浏览器是： "+browser+" 测试服务器地址是： "+server);
        token_ = "123456";
    }

    @Test
    public void test2(){
        System.out.println("TestNG");
    }

}
