import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RungeKuttaCalculator {
    private final Function function;
    private final double x0;
    private final double y0;
    private final double h;
    private final double x;

    public RungeKuttaCalculator(Function function, double x0, double y0, double h, double x) {
        this.function = function;
        this.x0 = x0;
        this.y0 = y0;
        this.h = h;
        this.x = x;
    }

    public double calculate() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        int n = (int)Math.round((x - x0) / h);
        int interval = n / 4;// Здесь вычисляется количество шагов для каждого из четырех подинтервалов.
        Future<Double>[] futures = new Future[4];// Создается массив futures для хранения результатов вычислений, выполняемых в отдельных потоках.
        double y = y0;
        for (int i = 0; i < 4; i++) {
            double xStart = x0 + i * interval * h;
            double xEnd = i == 3 ? x : x0 + (i + 1) * interval * h;//Вычисляется конечное значение x для текущего подинтервала. Если это последний подинтервал,
            // то xEnd равно x, иначе оно вычисляется как начальное значение следующего подинтервала.
            int steps = i == 3 ? n - i * interval : interval;// Вычисляется количество шагов для текущего подинтервала.
            RungeKutta rungeKutta = new RungeKutta(xStart, y, h, xEnd, steps, function);
            futures[i] = executor.submit(rungeKutta);//Задача rungeKutta отправляется на выполнение в пул потоков
            y = futures[i].get();  // Обновляем y для следующего подинтервала
        }

        executor.shutdown();

        return y;
    }
}