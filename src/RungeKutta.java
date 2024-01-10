import java.util.concurrent.Callable;

public class RungeKutta implements Callable<Double> {
    private double x0;
    private double y0;
    private final double h;
    private final int n;
    private final Function function;

    public RungeKutta(double x0, double y0, double h, double x, int n, Function function) {
        this.x0 = x0;
        this.y0 = y0;
        this.h = h;
        this.n = n;
        this.function = function;
    }

    @Override
    public Double call() {
        for (int i = 1; i <= n; i++) {
            double k1 = h * function.eval(x0, y0);
            double k2 = h * function.eval(x0 + 0.5 * h, y0 + 0.5 * k1);
            double k3 = h * function.eval(x0 + 0.5 * h, y0 + 0.5 * k2);
            double k4 = h * function.eval(x0 + h, y0 + k3);

            y0 = y0 + (1.0 / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
            x0 = x0 + h;
        }
        return y0;
    }
}
