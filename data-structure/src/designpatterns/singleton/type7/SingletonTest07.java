package designpatterns.singleton.type7;


public class SingletonTest07 {

	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
		
	}

}

/**
 * 通过静态内部类，如果 getInstance 不被执行 内部类SingletonInstance就不会被加载
 */
class Singleton {
	private static volatile Singleton instance;
	
	private Singleton() {}
	
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton(); 
	}
	

	public static synchronized Singleton getInstance() {
		
		return SingletonInstance.INSTANCE;
	}
}