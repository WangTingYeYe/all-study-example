package www.linked;

import org.junit.Test;

/**
 * @author wangting
 * @version 1.0
 * @ClassName: StatckTest
 * Function: 栈的 测试
 * Date:     2019/7/4 0004 上午 11:41
 */
public class StatckTest {

    @Test
    public void simulationStatckForArray(){
        Statck statck = new Statck(10);

        for (int i =1 ; i< 11 ; i++){
            boolean put = statck.put(i);
            System.out.println(put);
        }
        for (int i =1 ; i< 11 ; i++){
            Object out = statck.out();
            System.out.println(out);
        }

    }

    class Statck{
        private int count = 0;
        private int capacity ;

        private Object[] arrays ;

        public Statck(int capacity) {
            this.capacity = capacity;
            arrays = new Object[capacity];
        }

        public boolean put(Object o){
            //如果 容量不够了
            if(count == capacity){
                return false;
            }
            arrays[count] = o;
            count++;
            return true;
        }

        public Object out(){
            if(count == 0){
                throw new RuntimeException("没有元素了");
            }
            Object returnObj = arrays[count-1];
            count--;
            return returnObj;

        }

    }
}
