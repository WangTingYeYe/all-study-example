package www.linked;

import org.junit.Test;

/**
 * @author wangting
 * @version 1.0
 * @ClassName: LinkedTest
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019/7/2 0002 上午 11:14
 */
public class LinkedTest {

    /**
     * 删除倒数第n个节点
     */
    @Test
    public void removeNNode() {
        Node node1 = new Node(null, "1");
        Node node2 = new Node(node1, "2");
        Node node3 = new Node(node2, "3");
        Node node4 = new Node(node3, "4");
        Node node5 = new Node(node4, "5");
        Node node6 = new Node(node5, "7");

        Node rootNode = node6;
        //1、倒数n个 表示 正数第 length -n 个 。如果小于 0 则 表示 不存在
        Node curNode = node6;
        int count = 0;
        while (true) {
            count++;
            curNode = curNode.getNext();
            if (curNode == null) {
                break;
            }
        }
        int n = 4;
        if(n > count){
            System.out.println("没有该元素");
            return;
        }
        int index = count - n;
        int lookUpIndex = 0;

        curNode = node6;
        while (true) {
            if(lookUpIndex ==index){
                System.out.println(curNode.getData());
            }
            lookUpIndex++;
            curNode = curNode.getNext();
            if (curNode == null) {
                break;
            }
        }

    }


    /**
     * 两个有序的链表合并
     */
    public void sortedLinkedMerge() {
        Node node1 = new Node(null, "1");
        Node node2 = new Node(node1, "2");
        Node node3 = new Node(node2, "3");
        Node node4 = new Node(node3, "4");
        Node node5 = new Node(node4, "5");
        Node node6 = new Node(node5, "7");


        Node node7 = new Node(null, "1");
        Node node8 = new Node(node7, "2");
        Node node9 = new Node(node8, "3");
        Node node10 = new Node(node9, "4");
        Node node11 = new Node(node10, "5");
        Node node12 = new Node(node11, "6");

        Node curNode = node6;
        while (node6.getNext() != null) {
            Node inserNode = node12;

            while (true) {
                if ((int) curNode.getData() > (int) inserNode.getData()) {
                    curNode.setNext(inserNode);
                    break;
                }
                inserNode = inserNode.getNext();
            }
        }

    }

    /**
     * 链表中环的检测
     */
    @Test
    public void annulusCheck() {
        Node node1 = new Node(null, "1");
        Node node2 = new Node(node1, "2");
        Node node3 = new Node(node2, "3");
        Node node4 = new Node(node3, "4");
        Node node5 = new Node(node4, "5");
        Node node6 = new Node(node5, "6");

        /**
         * 快指针每次 +2
         * 慢指针每次 +1
         * 快指针转两圈 慢指针转一圈 肯定能相遇 只要他两相遇肯定  有环
         *
         */
//        node1.setNext(node4);

        Node fastNode = node6;
        Node slowNode = node6;

        while (true) {
            fastNode = fastNode.getNext();
            slowNode = slowNode.getNext();

            if (fastNode == null || slowNode == null || fastNode.getNext() == null) {
                System.out.println("没有环形");
                return;
            }
            fastNode = fastNode.getNext();

            if (slowNode == fastNode) {
                System.out.println("有环形");
                break;
            }

        }
    }

    /**
     * 单链表翻转
     */
    @Test
    public void reversal1() {
        Node headerNode = null;
        Node node1 = new Node(null, "1");
        Node node2 = new Node(node1, "2");
        Node node3 = new Node(node2, "3");
        Node node4 = new Node(node3, "4");
        Node node5 = new Node(node4, "5");
        Node node6 = new Node(node5, "6");

        headerNode = node6;

        printLinked(headerNode);


        Node preNode = null;
        Node curNode = node6;
        Node nextNode = null;
        while (true) {


            nextNode = curNode.getNext();

            curNode.setNext(preNode);

            if (nextNode == null) {
                headerNode = curNode;
                break;
            }
            preNode = curNode;
            curNode = nextNode;
        }


        printLinked(headerNode);

    }

    /**
     * 打印单链表
     *
     * @param headerNode 头节点
     */
    private void printLinked(Node headerNode) {
        Node curNode = headerNode;
        while (true) {

            System.out.println(curNode.getData());

            //如果没有元素了 则 跳出
            if (curNode.getNext() == null) {
                break;
            }
            curNode = curNode.getNext();
        }
    }


    /**
     * 链表节点
     */
    class Node {
        private Node next;

        private Node pre;

        private Object data;

        public Node(Node pre, Node next, Object data) {
            this.next = next;
            this.pre = pre;
            this.data = data;
        }

        public Node(Node next, Object data) {
            this.next = next;
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
