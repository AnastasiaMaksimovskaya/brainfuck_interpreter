package ua.com.test;

import java.util.*;

public class CommandFactory {

    private Map<Character, Command> commandStorage = new HashMap<>();
    private Deque<ArrayList<Command>> stack = new ArrayDeque<>();
    private StringBuilder output = new StringBuilder();

    public CommandFactory(Memory memory) {
        stack.push(new ArrayList<>());
        commandStorage.put('>', () -> stack.peek().add(() -> memory.setPosition(memory.getPosition() + 1)));
        commandStorage.put('<', () -> stack.peek().add(() -> memory.setPosition(memory.getPosition() - 1)));
        commandStorage.put('+', () -> stack.peek().add(() -> memory.getBytes()[memory.getPosition()]++));
        commandStorage.put('-', () -> stack.peek().add(() -> memory.getBytes()[memory.getPosition()]--));
        commandStorage.put('.', () -> stack.peek().add(() -> output.append((char) (memory.getBytes()[memory.getPosition()]))));
        commandStorage.put('[', () -> stack.push(new ArrayList<>()));
        commandStorage.put(']', () -> {
            while (memory.getBytes()[memory.getPosition()] > 0) {
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

    public StringBuilder getOutput() {
        return output;
    }
}
