
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RungeKuttaTest {
    @Test
    public void testRungeKutta1() {
        double x0 = 1;
        double y0 = 50;
        double h = 0.1;
        double x = 1;
        int n = (int)Math.round((x - x0) / h);

        Function function = (xVal, yVal) -> yVal - xVal * xVal + 1;
        RungeKutta rungeKutta = new RungeKutta(x0, y0, h, x, n, function);
        double result = rungeKutta.call();
        assertEquals(50, result, 0.01);  // Замените expectedValue на ожидаемое значение
    }

    @Test
    public void testRungeKutta2() {
        double x0 = 0.0000001;
        double y0 = 0.2;
        double h = 0.0000001;
        double x = 0.02;
        int n = (int)Math.round((x - x0) / h);

        Function function = (xVal, yVal) -> yVal - xVal * xVal + 1;
        RungeKutta rungeKutta = new RungeKutta(x0, y0, h, x, n, function);
        double result = rungeKutta.call();
        assertEquals(0.22423880555443892, result, 0.01);  // Замените expectedValue на ожидаемое значение
    }

    @Test
    public void testRungeKutta3() {
        double x0 = 0.1;
        double y0 = 50.40;
        double h = 0.01;
        double x = 1.4;
        int n = (int)Math.round((x - x0) / h);

        Function function = (xVal, yVal) -> yVal - xVal * xVal + 1;
        RungeKutta rungeKutta = new RungeKutta(x0, y0, h, x, n, function);
        double result = rungeKutta.call();
        assertEquals(186.25270306024615, result, 0.01);  // Замените expectedValue на ожидаемое значение
    }

    @Test
    public void testRungeKutta4() {
        double x0 = 0;
        double y0 = 50;
        double h = 0.1;
        double x = 1;
        int n = (int)Math.round((x - x0) / h);

        Function function = (xVal, yVal) -> yVal - xVal * xVal + 1;
        RungeKutta rungeKutta = new RungeKutta(x0, y0, h, x, n, function);
        double result = rungeKutta.call();
        assertEquals(137.19570405887578, result, 0.01);  // Заменить expectedValue на ожидаемое значение
    }

    @Test
    public void testRungeKutta5() {
        double x0 = -70;
        double y0 = 50;
        double h = 0.1;
        double x = -30;
        int n = (int)Math.round((x - x0) / h);

        Function function = (xVal, yVal) -> yVal - xVal * xVal + 1;
        RungeKutta rungeKutta = new RungeKutta(x0, y0, h, x, n, function);
        double result = rungeKutta.call();
        assertEquals(-1.1088659817548229E21, result, 0.01);  // Замените expectedValue на ожидаемое значение
    }
}
