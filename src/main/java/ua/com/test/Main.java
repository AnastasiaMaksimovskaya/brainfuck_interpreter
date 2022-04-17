package ua.com.test;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Interpreter interpreter = new Interpreter();
        System.out.println(interpreter.interpret(reader.read()));
    }
}
