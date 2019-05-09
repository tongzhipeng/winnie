public class Puppy {

    int puppyAge;
    String name;

    public Puppy(String name){
        System.out.println("dog's name is:" + name);
        this.name = name;
        puppyAge = 0;
    }

    public void setAge(int age){
        puppyAge = age;
    }

    public int getAge(){
        System.out.println("小狗的年龄为 :" +  puppyAge);
        return puppyAge;
    }



    public static void main(String[] args){
        Puppy myPuppy = new Puppy("tommy");

        myPuppy.setAge(2);

        myPuppy.getAge();

        System.out.println("变量值 :" + myPuppy.puppyAge);
    }


}

class Kitty{
    int age;
    public void Talk()
    {
        System.out.println("喵喵喵？");
    }
}
