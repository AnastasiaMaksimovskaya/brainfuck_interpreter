import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ua.com.test.Interpreter;

public class InterpreterTest {

    private final String HELLO_WORLD = "Hello World!";
    private final Interpreter interpreter = new Interpreter();

    @Test
    @Order(1)
    public void shouldBeFirstHelloWorld() {
        String hello = "+++++++++++++++++++++++++++++++++++++++++++++" +
                "+++++++++++++++++++++++++++.+++++++++++++++++" +
                "++++++++++++.+++++++..+++.-------------------" +
                "---------------------------------------------" +
                "---------------.+++++++++++++++++++++++++++++" +
                "++++++++++++++++++++++++++.++++++++++++++++++" +
                "++++++.+++.------.--------.------------------" +
                "---------------------------------------------" +
                "----.-----------------------.";
        Assertions.assertEquals(HELLO_WORLD, interpreter.interpret(hello));
    }

    @Test
    @Order(2)
    public void shouldBeSecondHelloWorld() {
        String hello = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++" +
                ".>+.+++++++..+++.>++.<<+++++++++++++++.>.+++." +
                "------.--------.>+.>.";
        Assertions.assertEquals(HELLO_WORLD, interpreter.interpret(hello));
    }

    @Test
    @Order(3)
    public void shouldBeThirdHelloWorld() {
        String hello = ">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++.>>>++++++++[<++++>-]<" +
                ".>>>++++++++++[<+++++++++>-]<---.<<<<.+++.------.--------.>>+.>++++++++++.";
        Assertions.assertEquals(HELLO_WORLD, interpreter.interpret(hello));
    }
}
