package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.javafx.binding.StringFormatter;
import jdk.nashorn.internal.parser.JSONParser;

public class JsonTest {



    public static void Test()
    {
 //       System.out.println("JsonTest.Test");
//        CreateJsonObject();
//        CreateEmbedJsonObject();
//      CreateJsonArray();
//      CreateJsonObjectArray();
        ParseObject();
//        ParseObjectWithJsonString();
    }

    static void CreateJsonObject()
    {
        JSONObject obj = new JSONObject();
        obj.put("name", "百度");
        obj.put("url", "http://www.baidu.com");//字符串
        obj.put("reg_money", 1000 * 10000);//整数
        obj.put("IPO", true);//布尔值
        obj.put("address", "中国北京海淀区上地十街百度大厦");
        System.out.println(obj.toString(SerializerFeature.PrettyFormat));
    }

    static void CreateEmbedJsonObject()
    {
        JSONObject obj = new JSONObject();
        obj.put("name", "百度");
        obj.put("url", "http://www.baidu.com");
        obj.put("reg_money", 1000 * 10000);
        obj.put("IPO", true);
        JSONObject address = new JSONObject();
        address.put("street", "上地十街百度大厦");
        address.put("block", "海淀区");
        address.put("city", "北京");
        address.put("country", "中国");
        obj.put("address", address);
        System.out.println(obj.toString(SerializerFeature.PrettyFormat));
    }

    static void CreateJsonArray()
    {
        JSONArray array = new JSONArray();
        for (int i = 0; i < 10; i++)
        {
            array.add(i);
        }
        System.out.println(array);
    }

    static void CreateJsonObjectArray()
    {
        JSONArray array = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("name", "李雷");
        obj.put("grade", "三年级");
        array.add(obj);
        JSONObject obj2 = new JSONObject();
        obj2.put("name", "韩梅梅");
        obj2.put("grade", "三年级");
        array.add(obj2);
        System.out.println(array.toString(SerializerFeature.PrettyFormat));
    }

    static void ParseObject()
    {

        String response = "{\"address\":{\"country\":\"中国\",\"city\":\"北京\",\"street\":\"上地十街百度大厦\",\"block\":\"海淀区\"},\"reg_money\":10000000,\"name\":\"百度\",\"IPO\":true,\"url\":\"http://www.baidu.com\"}";
        //如果输入字符串是数组形式[0, 1, 2 ,3]  就要用 JSONArray.parseArray
        System.out.println("ParseObject response=" +response);
        //response(序列、字符串) -> obj (对象)
        JSONObject obj = JSONObject.parseObject(response);
        String name = obj.getString("name");
        JSONObject address = obj.getJSONObject("address");//address是嵌套的json对象
        //对象 -> 序列(字符串)  使用toJSONString或者toString
        String address_string = address.toJSONString();
        System.out.println("address_string=" + address_string);
        obj.put("address", address_string);
        System.out.println("obj=" + obj.toJSONString());
        String country = address.getString("country");
        String city = address.getString("city");
        int reg_money = obj.getIntValue("reg_money");
        Boolean ipo = obj.getBoolean("IPO");
        String info = String.format("name=%s, country=%s, city=%s, 注册资金:%d, 是否上市:%b", name, country, city, reg_money, ipo);//format 是字符串格式化
        System.out.println(info);
    }

    static void ParseObjectWithJsonString()
    {
        String response = "{\"address\":\"{\\\"country\\\":\\\"中国\\\",\\\"city\\\":\\\"北京\\\",\\\"street\\\":\\\"上地十街百度大厦\\\",\\\"block\\\":\\\"海淀区\\\"}\",\"reg_money\":10000000,\"name\":\"百度\",\"IPO\":true,\"url\":\"http://www.baidu.com\"}";
        System.out.println("ParseObjectWithJsonString response=" +response);
        JSONObject obj = JSONObject.parseObject(response);//parseObject将一个字符串转化成对象
        String name = obj.getString("name");
        String address_string = obj.getString("address");
        System.out.println("address_string=" + address_string);
        JSONObject address = JSON.parseObject(address_string);
        String country = address.getString("country");
        String city = address.getString("city");
        int reg_money = obj.getIntValue("reg_money");
        Boolean ipo = obj.getBoolean("IPO");
        String info = String.format("name=%s, country=%s, city=%s, 注册资金:%d, 是否上市:%b", name, country, city, reg_money, ipo);
        System.out.println(info);
    }
}
