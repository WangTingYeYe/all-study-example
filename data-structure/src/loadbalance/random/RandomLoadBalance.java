package loadbalance.random;

import loadbalance.ServiceIps;

import java.util.Random;

/**
 * @program: all-study-example
 * @description: 随机算法
 * @author: Micheal.Wang
 * @blog: <a href="http://www.micheal.top">MichealWang</a>
 * @create: 2019-08-26 14:55
 **/
public class RandomLoadBalance {



    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getServiceIp());
        }
    }

    private static String getServiceIp() {

        Random random = new Random();
        int poi = random.nextInt(ServiceIps.LIST.size());
        return ServiceIps.LIST.get(poi);
    }
}
