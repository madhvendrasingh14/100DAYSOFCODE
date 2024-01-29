import java.util.Stack;
import java.util.Scanner;

class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        shiftStacks();
        return stack2.pop();
    }

    public int peek() {
        shiftStacks();
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command (push, pop, peek, empty, or quit): ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("quit")) {
                break;
            }

            switch (command) {
                case "push":
                    System.out.print("Enter value to push: ");
                    int value = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    queue.push(value);
                    System.out.println("Value pushed");
                    break;
                case "pop":
                    int popped = queue.pop();
                    System.out.println("Popped value: " + popped);
                    break;
                case "peek":
                    int peeked = queue.peek();
                    System.out.println("Front value: " + peeked);
                    break;
                case "empty":
                    System.out.println("Queue is empty: " + queue.empty());
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
