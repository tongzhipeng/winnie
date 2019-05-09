public class Dog {

    String breed;  //成员变量
    int age;//成员变量
    String color;//成员变量
    public static int total_cnt = 0;// 类变量 用static修饰
    Dog()
    {
        total_cnt++;
    }
    protected void finalize()
    {
        total_cnt--;
    }

    public static Dog Test()//类方法 用static修饰
    {
        System.out.println('total_cnt =' + Dog.total_cnt);

        Dog d = new Dog();//d为局部变量, 是Dog类(class)实例化出来的一个对象(object)
        d.age = 20;
        Dog e = new Dog();
        e.age = 10;
        return d;
    }

    void barking()//成员方法
    {

    }
    void hungry(){

    }
    void sleeping(){

    }
}
