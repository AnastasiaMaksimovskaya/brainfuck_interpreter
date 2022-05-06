package ua.com.test;

public class Interpreter {

    Memory memory = new Memory();
    CommandFactory commandFactory = new CommandFactory(memory);

    public String interpret(String input) {
        for (int j = 0; j < input.length(); j++) {
            commandFactory.getCommandStorage().get(input.charAt(j)).execute();
            if (commandFactory.getStack().size() == 1 && input.charAt(j)!=']') {
                commandFactory.getStack().peek().get(commandFactory.getStack().peek().size() - 1).execute();
            }
        }
        return commandFactory.getOutput().toString();
    }
}
