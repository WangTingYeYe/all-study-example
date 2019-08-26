package designpatterns.builder;

public class Clinet {

    public static void main(String[] args) {

        // 问题：房子的生产过程和 房子本身偶合在一起

        AbstractHouse bigHouse = new BigHouse();
        AbstractHouse smallHouse = new SmallHouse();

        bigHouse.build();
        smallHouse.build();
    }
}
