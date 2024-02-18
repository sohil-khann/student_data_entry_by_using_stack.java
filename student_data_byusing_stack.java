import java.util.Scanner;

class Node {
    String name;
    int marks;
    Node next;

    public Node(String name, int marks) {
        this.name = name;
        this.marks = marks;
        this.next = null;
    }
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(String name, int marks) {
        Node newNode = new Node(name, marks);
        newNode.next = top;
        top = newNode;
        System.out.println("Student added to stack.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot remove student.");
        } else {
            System.out.println("Removed student: " + top.name);
            top = top.next;
        }
    }

    public void displayAllStudents() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            Node current = top;
            System.out.println("Students in the stack:");
            while (current != null) {
                System.out.println("Name: " + current.name + ", Marks: " + current.marks);
                current = current.next;
            }
        }
    }

    public void displayTop3Positions() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No positions to display.");
            return;
        }

        Node first = null, second = null, third = null;

        Node current = top;
        while (current != null) {
            if (first == null || current.marks > first.marks) {
                third = second;
                second = first;
                first = current;
            } else if (second == null || current.marks > second.marks) {
                third = second;
                second = current;
            } else if (third == null || current.marks > third.marks) {
                third = current;
            }

            current = current.next;
        }

        System.out.println("Top 3 positions based on marks:");
        if (first != null) {
            System.out.println("1. Name: " + first.name + ", Marks: " + first.marks);
        }
        if (second != null) {
            System.out.println("2. Name: " + second.name + ", Marks: " + second.marks);
        }
        if (third != null) {
            System.out.println("3. Name: " + third.name + ", Marks: " + third.marks);
        }
    }

    private boolean isEmpty() {
        return top == null;
    }
}

public class student_data_byusing_stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a student to Stack");
            System.out.println("2. Remove a Student from the Stack");
            System.out.println("3. Display all students of Stack");
            System.out.println("4. Display the top 3 positions of students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter marks: ");
                    int marks = scanner.nextInt();
                    stack.push(name, marks);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.displayAllStudents();
                    break;
                case 4:
                    stack.displayTop3Positions();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
