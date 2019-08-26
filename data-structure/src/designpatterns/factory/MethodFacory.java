package designpatterns.factory;

public class MethodFacory {


    public static void main(String[] args) {
        /**如果 新增pizz 只需要 该这行代码 并新增相应的实现类即可*/
        PizzOrder pizzOrder = new APizzOrder();
        pizzOrder.createPizz();
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

    interface PizzOrder {

        Pizz createPizz();

    }

    static class APizzOrder implements PizzOrder {
        @Override
        public Pizz createPizz() {
            Pizz pizz = new APizz();
            pizz.preCreate();
            pizz.createIng();
            pizz.postcreate();
            return pizz;
        }
    }

    static class BPizzOrder implements PizzOrder {
        @Override
        public Pizz createPizz() {
            Pizz pizz = new BPizz();
            pizz.preCreate();
            pizz.createIng();
            pizz.postcreate();
            return pizz;
        }
    }
}
