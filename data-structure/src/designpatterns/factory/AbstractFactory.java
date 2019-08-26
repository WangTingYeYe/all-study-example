package designpatterns.factory;

public class AbstractFactory {
    public static void main(String[] args) {
        PizzFactory pizzFactory = new YPizzFactory();
        PizzOrder pizzOrder = new PizzOrder(pizzFactory);
        pizzOrder.create("B");
    }

    interface Pizz {

        void preCreate();

        void createIng();

        void postcreate();

    }

    static class BPizz implements Pizz {

        @Override
        public void preCreate() {
            System.out.println("B pizz 准备制作");
        }

        @Override
        public void createIng() {
            System.out.println("B pizz 制作中");
        }

        @Override
        public void postcreate() {
            System.out.println("B pizz 制作完成");
        }
    }

    static class APizz implements Pizz {
        @Override
        public void preCreate() {
            System.out.println("A pizz 准备制作");
        }

        @Override
        public void createIng() {
            System.out.println("A pizz 制作中");
        }

        @Override
        public void postcreate() {
            System.out.println("A pizz 制作完成");
        }
    }

    static class PizzOrder {
        PizzFactory pizzFactory;

        public PizzOrder(PizzFactory pizzFactory) {
            this.pizzFactory = pizzFactory;
        }

        Pizz create(String pizzType) {
            return pizzFactory.createPizz(pizzType);
        }

    }

    /**
     * 即使以后 想要Z 地区的 C 披萨 只需要 新增一个 ZPizzFactory 即可，
     */
     interface PizzFactory {

        public Pizz createPizz(String pizzType);
    }


    static class XPizzFactory implements PizzFactory {
        @Override
        public Pizz createPizz(String pizzType) {
            Pizz pizz = null;
            /**
             *   即使以后新增C 也只需要更改这里就行了
             */
            if ("A".equals(pizzType)) {
                pizz = new APizz();
            } else {
                pizz = new BPizz();
            }
            System.out.println("X地区的披萨");
            pizz.preCreate();
            pizz.createIng();
            pizz.postcreate();
            return pizz;
        }
    }
    static class YPizzFactory implements PizzFactory {
        @Override
        public Pizz createPizz(String pizzType) {
            Pizz pizz = null;
            /**
             *   即使以后新增C 也只需要更改这里就行了
             */
            if ("A".equals(pizzType)) {
                pizz = new APizz();
            } else {
                pizz = new BPizz();
            }
            System.out.println("Y地区的披萨");
            pizz.preCreate();
            pizz.createIng();
            pizz.postcreate();
            return pizz;
        }
    }

}
