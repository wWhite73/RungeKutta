<h1 align="center">Метод RungeKutta реализованный через потоки</h1>


**Main.java:**
---
Это основной класс, который запускает приложение.

**Function.java:**
---
Этот класс определяет интерфейс для функции, которую интегрирую.

**RungeKutta.java:**
---
Этот класс реализует метод Рунге-Кутты для решения дифференциального уравнения.

**RungeKuttaCalculator.java:**
---
Этот класс использует класс RungeKutta для вычисления и возвращает результат.
Здесь же происходит разделение на потоки метода Рунге-Кутты.

**RungeKuttaGUI.java:**
---
Этот класс отвечает за графический интерфейс пользователя приложения.

**RungeKuttaTest.java:**
--- 
Этот класс содержит тесты для проверки корректности кода.

**InputHandler.java:**
--- 
Этот класс отвечает за обработку ввода пользователя.
