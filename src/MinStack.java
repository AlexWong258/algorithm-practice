import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 */
public class MinStack {
    private Stack<Integer> valueStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(Integer num) {
        int minVaule;

        if (valueStack.size() == 0) {
            minVaule = num;
        } else {
            int minStackPeek = minStack.peek();
            minVaule = minStackPeek < num ? minStackPeek : num;
        }

        valueStack.push(num);
        minStack.push(minVaule);
    }

    public Integer pop() {
        minStack.pop();
        return valueStack.pop();
    }

    public Integer top() {
        return valueStack.peek();
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(3);
        minStack.push(7);
        minStack.push(8);
        minStack.push(1);
        minStack.push(4);

        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
