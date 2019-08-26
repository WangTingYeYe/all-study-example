package designpatterns.singleton.type4;


public class SingletonTest04 {

	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
	}

}

/**
 * 多线程可用，但效率不高
 */
class Singleton {
	private static Singleton instance;
	
	private Singleton() {}
	
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}