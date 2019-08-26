package designpatterns.builder;

public class BigHouse extends AbstractHouse {

    @Override
    protected void buildBase() {
        System.out.println("大房子大打地基 ！");
    }

    @Override
    protected void buildWalls() {
        System.out.println("大房子砌墙");
    }

    @Override
    protected void roofed() {

        System.out.println("大房子封顶");
    }
}
