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
     * 链表翻转
     */
    @Test
    public void reversal() {
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
