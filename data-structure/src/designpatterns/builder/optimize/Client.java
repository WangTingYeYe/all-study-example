package designpatterns.builder.optimize;

public class Client {

    public static void main(String[] args) {


        HouseDirector director = new HouseDirector(new BigHouseBuilder());
        House house = director.constructHouse();

    }
}
