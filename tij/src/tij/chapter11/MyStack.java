package tij.chapter11;

import java.util.ArrayDeque;

public class MyStack {
    static class Stack<T> {
        ArrayDeque<T> deque = new ArrayDeque<T>();

        public void push(T element) {
            deque.push(element);
        }

        public T peek() {
            return deque.peek();
        }

        public T pop() {
            return deque.pop();
        }

        public int size() {
            return deque.size();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
