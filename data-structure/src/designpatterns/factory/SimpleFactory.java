package designpatterns.factory;

public class SimpleFactory {


    public static void main(String[] args) {
        PizzFactory pizzFactory = new PizzFactory();
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

    static class PizzFactory {

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
            pizz.preCreate();
            pizz.createIng();
            pizz.postcreate();
            return pizz;
        }
    }

}
