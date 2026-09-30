package edu.princeton.cs.algs4;

public class QueueUsingTwoStacks {

    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    private void moveIfNeeded() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public int dequeue() {
        moveIfNeeded();

        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.pop();
    }

    public int peek() {
        moveIfNeeded();

        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.peek();
    }

    public void print() {
        System.out.println("Front = " + peek());
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.print();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(40);
        queue.enqueue(50);

        queue.print();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}