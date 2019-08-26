package designpatterns.prototype;

public class Clinet {
    public static void main(String[] args) throws CloneNotSupportedException {
        ReferenceObject referenceObject = new ReferenceObject();
        referenceObject.setName("引用");
//        Sheep sheep = new Sheep();
//        HardCopySheep sheep = new HardCopySheep();
        HardCopySheep1 sheep = new HardCopySheep1();
        sheep.setAge(10);
        sheep.setName("Tom");
        sheep.setReferenceObject(referenceObject);

//        Sheep sheep1 = (Sheep) sheep.clone();
//        Sheep sheep2 = (Sheep) sheep.clone();
//        Sheep sheep3 = (Sheep) sheep.clone();
//        Sheep sheep4 = (Sheep) sheep.clone();
//        Sheep sheep5 = (Sheep) sheep.clone();

//        HardCopySheep sheep1 = (HardCopySheep) sheep.clone();
//        HardCopySheep sheep2 = (HardCopySheep) sheep.clone();
//        HardCopySheep sheep3 = (HardCopySheep) sheep.clone();
//        HardCopySheep sheep4 = (HardCopySheep) sheep.clone();
//        HardCopySheep sheep5 = (HardCopySheep) sheep.clone();

        HardCopySheep1 sheep1 = (HardCopySheep1) sheep.clone();
        HardCopySheep1 sheep2 = (HardCopySheep1) sheep.clone();
        HardCopySheep1 sheep3 = (HardCopySheep1) sheep.clone();
        HardCopySheep1 sheep4 = (HardCopySheep1) sheep.clone();
        HardCopySheep1 sheep5 = (HardCopySheep1) sheep.clone();

        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);
        System.out.println(sheep1.getReferenceObject().hashCode());
        System.out.println(sheep2.getReferenceObject().hashCode());
    }
}
