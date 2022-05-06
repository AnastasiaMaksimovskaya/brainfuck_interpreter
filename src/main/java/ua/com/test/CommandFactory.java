package ua.com.test;

import java.util.*;

public class CommandFactory {

    private Map<Character, Command> commandStorage = new HashMap<>();
    private Deque<ArrayList<Command>> stack = new ArrayDeque<>();

    public CommandFactory(Memory memory) {
        stack.push(new ArrayList<>());
        commandStorage.put('>', () -> stack.peek().add(() -> memory.setPosition(memory.getPosition() + 1)));
        commandStorage.put('<', () -> stack.peek().add(() -> memory.setPosition(memory.getPosition() - 1)));
        commandStorage.put('+', () -> stack.peek().add(() -> memory.getBytes()[memory.getPosition()]++));
        commandStorage.put('-', () -> stack.peek().add(() -> memory.getBytes()[memory.getPosition()]--));
        commandStorage.put('.', () -> stack.peek().add(() -> System.out.println((memory.getBytes()[memory.getPosition()]))));
        commandStorage.put('[', () -> stack.push(new ArrayList<>()));
        commandStorage.put(']', () ->{
            while ( memory.getBytes()[memory.getPosition()]!=0){
                stack.peek().forEach(Command::execute);
            }
            stack.pop();
        });
    }

    public Map<Character, Command> getCommandStorage() {
        return commandStorage;
    }

    public Deque<ArrayList<Command>> getStack() {
        return stack;
    }

    public int changePosition(Deque<ArrayList<Command>> stack) {
        Deque<ArrayList<Command>> arrayListDeque = new ArrayDeque<>(stack);
        int position = 0;
        while (arrayListDeque.size() != 0) {
            position += arrayListDeque.peek().size();
            arrayListDeque.pop();
        }
        return position;
    }
}
