package designpatterns.prototype;

/**
 * 这种是通过Object的clone方法进行的软拷贝，
 * 软拷贝: 基础数据类型及其包装类型和String类型会被重新创建并复制过去，普通引用类型只会讲地址复制过去，并不会重新在堆里创建对象
 * 硬拷贝： 如果拷贝的对象中的属性用到了引用类型，会将引用类型的对象在堆里拷贝一份。再赋值
 *
 * 硬拷贝方式：1、所有可达的应用对象都实现clone方方法
 * 2、拷贝对象 clone方法中通过序列化方式 但注意所有应用类型的对象必须 实现 Serializable接口
 *
 */
public class Sheep implements Cloneable{

    private String name;

    private Integer age;


    private ReferenceObject referenceObject;


    public ReferenceObject getReferenceObject() {
        return referenceObject;
    }

    public void setReferenceObject(ReferenceObject referenceObject) {
        this.referenceObject = referenceObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
