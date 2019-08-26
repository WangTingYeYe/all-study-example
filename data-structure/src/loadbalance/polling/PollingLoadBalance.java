package loadbalance.polling;

import loadbalance.ServiceIps;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: all-study-example
 * @description: 轮询
 * @author: Micheal.Wang
 * @blog: <a href="http://www.micheal.top">MichealWang</a>
 * @create: 2019-08-26 15:18
 **/
public class PollingLoadBalance {

    private static Integer poi = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getSmoothWeghitServiceIp());
        }
    }

    /**
     * 简单 轮询
     * @return
     */
    private static String getServiceIp() {

        synchronized (poi) {

            if (poi == ServiceIps.LIST.size()) {
                poi = 0;
            }
            String ip = ServiceIps.LIST.get(poi);
            poi++;
            return ip;
        }
    }

    /**
     * 加权轮询
     * @return
     */
    private static String getWeghitServiceIp() {

        Integer totalCount = ServiceIps.WEIGHT_LIST.values().stream().reduce(0, (v1, v2) -> v1 + v2);
        String ip = null;
        synchronized (poi) {

            if (poi .equals(totalCount) ) {
                poi = 0;
            }
            Integer index = poi;

            for (Map.Entry<String, Integer> weight : ServiceIps.WEIGHT_LIST.entrySet()) {

                if(index < weight.getValue()){
                    ip =  weight.getKey();
                    break;
                }else {
                    index -= weight.getValue();
                }
            }
            poi++;
            return ip;
        }
    }

    /**
     * 平滑 加权 轮询
     */
    private static String getSmoothWeghitServiceIp(){
        Integer weghitSum = WEIGHT_LIST.values().stream().reduce(0, (v1, v2) -> v1 + v2);
        Weghit currentWeghit = null;
        for (Weghit value : ALL_WEGHIT.values()) {
            if(currentWeghit==null ||value.getCurrentWeghit()>currentWeghit.getCurrentWeghit()){
                currentWeghit = value;
            }
        }

        currentWeghit.setCurrentWeghit(currentWeghit.getCurrentWeghit()-weghitSum);
        for (Weghit value : ALL_WEGHIT.values()) {
            value.setCurrentWeghit(value.getCurrentWeghit()+value.weghit);
        }
        return currentWeghit.getIp();

    }

    /**
     * [A,5]
     * [B,1]
     * [C,1]
     *
     * int currentWeight =0
     * [0, 0, 0]
     *
     * currentWeight += wehit                 max(current)          max(current) -= sum(weghit)
     * [5,1,1]                                  5 A                     [-2,1,1]
     * [3,2,2]                                  3 A                     [-4,2,2]
     * [1,3,3]                                  3 B                     [1,-4,3]
     * [6,-3,4]                                 6 A                     [-1,-3,4]
     * [4,-2,5]                                 5 C                     [4,-2,-2]
     * [9,-1,-1]                                9 A                     [2,-1,-1]
     * [7,0,0]                                  7 A                     [0, 0 ,0 ]
     *
     *
     */


    public static final Map<String, Integer> WEIGHT_LIST = new HashMap<String, Integer>();
    static {
        WEIGHT_LIST.put("A", 5);
        WEIGHT_LIST.put("B", 1);
        WEIGHT_LIST.put("C", 1);
    }


    private static Map<String, Weghit> ALL_WEGHIT = new HashMap();
    static {
        for (Map.Entry<String, Integer> entry :WEIGHT_LIST.entrySet()){
            Integer weghit = entry.getValue();
            String ip = entry.getKey();
            ALL_WEGHIT.put(ip, new Weghit(weghit,weghit,ip));
        }

    }

    static class Weghit{
        Integer currentWeghit = 0;
        Integer weghit = 0;
        String ip;

        public Weghit(Integer currentWeghit, Integer weghit, String ip) {
            this.currentWeghit = currentWeghit;
            this.weghit = weghit;
            this.ip = ip;
        }

        public Integer getCurrentWeghit() {
            return currentWeghit;
        }

        public void setCurrentWeghit(Integer currentWeghit) {
            this.currentWeghit = currentWeghit;
        }

        public Integer getWeghit() {
            return weghit;
        }

        public void setWeghit(Integer weghit) {
            this.weghit = weghit;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }
    }

}
