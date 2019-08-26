package lastlive;

import java.util.*;

/**
 * @program: all-study-example
 * @description: 最小活跃次数
 * @author: Micheal.Wang
 * @blog: <a href="http://www.micheal.top">MichealWang</a>
 * @create: 2019-08-26 16:18
 **/
public class LastLiveLoadBalance {

    public static final Map<String, Integer> ACTIVITY_LIST = new LinkedHashMap<String, Integer>();


    static {
        ACTIVITY_LIST.put("192.168.0.1", 2);
        ACTIVITY_LIST.put("192.168.0.2", 0);
        ACTIVITY_LIST.put("192.168.0.3", 1);
        ACTIVITY_LIST.put("192.168.0.4", 3);
        ACTIVITY_LIST.put("192.168.0.5", 1);
        ACTIVITY_LIST.put("192.168.0.6", 1);
        ACTIVITY_LIST.put("192.168.0.7", 4);
        ACTIVITY_LIST.put("192.168.0.8", 2);
        ACTIVITY_LIST.put("192.168.0.9", 7);
        ACTIVITY_LIST.put("192.168.0.10", 3);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

            System.out.println(getServiceIp());
        }
    }

    private static String getServiceIp() {

        Optional<Integer> minValue =
                ACTIVITY_LIST.values().stream().min(Comparator.naturalOrder());

        List<String> minActiveServerIps= new ArrayList<>();
        if (minValue.isPresent()) {
            //如果存在最小活跃  找到所有的最小活跃
            for (Map.Entry<String, Integer> entry : ACTIVITY_LIST.entrySet()) {
                if(entry.getValue() == minValue.get()){
                    minActiveServerIps.add(entry.getKey());
                }
            }

            if(minActiveServerIps.size()>1){
                //通过权重或者 随机。。。。
            }else {
                return minActiveServerIps.get(0);
            }
        }

        return null;
    }
}
