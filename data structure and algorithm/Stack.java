public class Stack {
    
    List<Integer> array = new ArrayList<Integer>();

    // 压入新元素
    public void push(int x) {
        array.add(x);
    }

    // 栈顶元素弹出
    public void pop() {
        if (!isEmpty()) {
            array.remove(array.size() - 1);
        }
    }

    // 返回栈顶元素
    public int top() {
        return array.get(array.size() - 1);
    }

    // 判断是否是空栈
    public boolean isEmpty() {
        return array.size() == 0;
    }
}
