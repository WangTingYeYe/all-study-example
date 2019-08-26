package designpatterns.builder;

public class SmallHouse extends AbstractHouse {

    @Override
    protected void buildBase() {
        System.out.println("小房子大打地基 ！");
    }

    @Override
    protected void buildWalls() {
        System.out.println("小房子砌墙");
    }

    @Override
    protected void roofed() {

        System.out.println("小房子封顶");
    }
}
