package designpatterns.builder;

public abstract class AbstractHouse {

    /**
     * 构建
     */
    public void build(){

        buildBase();
        buildWalls();
        roofed();
    }

    /**
     * 地基
     */
    protected abstract void buildBase();

    /**
     * 砌墙
     */
    protected abstract void buildWalls();

    /**
     * 封顶
     */
    protected abstract void roofed();


}
