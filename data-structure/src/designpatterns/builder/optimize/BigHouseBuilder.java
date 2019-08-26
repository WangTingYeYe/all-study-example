package designpatterns.builder.optimize;

public class BigHouseBuilder extends HouseBuilder {


    @Override
    public void buildBasic() {

        System.out.println("大房子 地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("大房子 砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("大房子 封顶");
    }
}
