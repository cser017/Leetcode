/*
    If Read heavy, better to make popMax/pop O(1)
*/

class Node {
    int val;
    Node pre, next;
    public Node(int v){val = v;}
}

// to maintain stack structure
class DoubleLinkedList {
    Node head, tail;
    
    public DoubleLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
    }
    
    // to tail
    public Node add(int val){
        Node cur = new Node(val);
        cur.next = tail;
        cur.pre = tail.pre;
        tail.pre.next = cur;
        tail.pre = cur;
        return cur;
    }
    
    // remove tail
    public int pop(){
        return unlink(tail.pre).val;
    }
    
    public int peek(){
        return tail.pre.val;
    }
    
    public Node unlink(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }
}                                 

class MaxStack {
    // keep sorted order
    TreeMap<Integer, List<Node>> tmap;
    // keep insert order
    DoubleLinkedList dl;

    /** initialize your data structure here. */
    public MaxStack() {
        tmap = new TreeMap();
        dl = new DoubleLinkedList();
    }
    
    public void push(int x) {
        Node n = dl.add(x);
        if(!tmap.containsKey(x)){
            tmap.put(x, new ArrayList<Node>());
        }
        tmap.get(x).add(n);
    }
    
    public int pop() {
        int val = dl.pop();
        List<Node> li = tmap.get(val);
        li.remove(li.size() - 1);
        if(li.isEmpty()){
            tmap.remove(val);
        }
        return val;
    }
    
    public int top() {
        return dl.peek();
    }
    
    public int peekMax() {
        return tmap.lastKey();
    }
    
    public int popMax() {
        int max = peekMax();
        List<Node> li = tmap.get(max);
        Node node = li.remove(li.size() - 1);
        if(li.isEmpty()){
            tmap.remove(max);
        }
        // unlink node from list
        dl.unlink(node);
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */