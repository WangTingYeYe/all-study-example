package consistenthash;

import loadbalance.ServiceIps;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @program: all-study-example
 * @description: 一致哈希算法
 * @author: Micheal.Wang
 * @blog: <a href="http://www.micheal.top">MichealWang</a>
 * @create: 2019-08-26 16:05
 **/
public class ConsistentHashLoadBalance {

    private static final int VIRTUAL_NODES = 160;

    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getServiceIp("client"+i));
        }
    }

    /**
     * 一直has算法
     *
     * @return
     */
    private static String getServiceIp(String str) {
        int hash = getHash(str);
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        Integer nodeIndex = subMap.firstKey();
        if(nodeIndex==null){
            nodeIndex =  virtualNodes.firstKey();
        }

        return virtualNodes.get(nodeIndex);
    }

    static {
        for (String ip : ServiceIps.LIST) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                int hash = getHash(ip + "VN" + i);
                virtualNodes.put(hash, ip);
            }
        }

    }


    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
// 如果为负数则取正
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
}
