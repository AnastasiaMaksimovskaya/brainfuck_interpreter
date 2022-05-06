package ua.com.test;

public class Main {
    public static void main(String[] args) {
        String hello = ">+++++++++[<++++++++>-]<.";
        Interpreter interpreter = new Interpreter();
        interpreter.interpret(hello);
    }
}
