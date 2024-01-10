import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RungeKuttaGUI extends JFrame {
    private final JTextField x0Field = new JTextField();
    private final JTextField y0Field = new JTextField();
    private final JTextField hField = new JTextField();
    private final JTextField xField = new JTextField();
    private final JLabel resultLabel = new JLabel();

    public RungeKuttaGUI() {
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Enter x0:"));
        add(x0Field);
        add(new JLabel("Enter y0:"));
        add(y0Field);
        add(new JLabel("Enter h:"));
        add(hField);
        add(new JLabel("Enter x:"));
        add(xField);
        add(new JLabel("Result:"));
        add(resultLabel);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this::calculateAction);
        add(calculateButton);

        pack();
        setSize(500, 500);  // Устанавливаем размер окна
        setLocationRelativeTo(null);  // Размещаем окно в центре экрана
    }

    private void calculateAction(ActionEvent e) {
        new Thread(() -> {
            try {
                double x0 = Double.parseDouble(x0Field.getText());
                double y0 = Double.parseDouble(y0Field.getText());
                double h = Double.parseDouble(hField.getText());
                double x = Double.parseDouble(xField.getText());

                Function function = (xVal, yVal) -> yVal - xVal * xVal + 1;
                RungeKuttaCalculator calculator = new RungeKuttaCalculator(function, x0, y0, h, x);
                double y = calculator.calculate();

                SwingUtilities.invokeLater(() -> {
                    resultLabel.setText(String.valueOf(y));
                });
            } catch (NumberFormatException ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}