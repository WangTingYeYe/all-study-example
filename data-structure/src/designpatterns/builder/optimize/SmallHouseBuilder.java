package designpatterns.builder.optimize;

public class SmallHouseBuilder extends HouseBuilder {

    @Override
    public void buildBasic() {

        System.out.println("小房子 地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("小房子 砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("小房子 封顶");
    }
}
