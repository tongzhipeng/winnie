package com.java.learn;

import org.testng.annotations.Test;

public class TestNG_Demo2 {
    @Test
    public void test1(){
        System.out.println("TestNG_Demo2 Hello");
    }
    @Test
    public void test2(){
        System.out.println("TestNG_Demo2 TestNG, token=" + TestNG_Demo1.token_);
    }
}
