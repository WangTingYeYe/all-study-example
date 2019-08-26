package loadbalance.random;

import loadbalance.ServiceIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @program: all-study-example
 * @description: 权重随机算法
 * @author: Micheal.Wang
 * @blog: <a href="http://www.micheal.top">MichealWang</a>
 * @create: 2019-08-26 15:05
 **/
public class RandomLoadBalanceWeight {

    private static final List<String> ALL_SERVICE = new ArrayList<>();

    static {
        for (Map.Entry<String, Integer> weight : ServiceIps.WEIGHT_LIST.entrySet()) {
            String ip = weight.getKey();
            Integer num = weight.getValue();
            for (Integer i = 0; i < num; i++) {
                ALL_SERVICE.add(ip);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getServiceIp2());
        }
    }


    /**
     * 最基础的 方法
     *
     * @return
     */

    private static String getServiceIp() {
        Random random = new Random();
        int poi = random.nextInt(ALL_SERVICE.size());
        return ALL_SERVICE.get(poi);

    }

    /**
     * 通过 距离操作
     *
     *
     * @return
     */
    private static String getServiceIp2() {
        Integer totalCount = ServiceIps.WEIGHT_LIST.values().stream().reduce(0, (v1, v2) -> v1 + v2);

        Random random = new Random();
        int poi = random.nextInt(totalCount);

        for (Map.Entry<String, Integer> weight : ServiceIps.WEIGHT_LIST.entrySet()) {

            if(poi < weight.getValue()){
                return weight.getKey();
            }else {
                poi -= weight.getValue();
            }
        }

        return null;
    }
}
