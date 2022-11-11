import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        StepTracker tracker = new StepTracker();

        while (userInput != 4) {
            if (userInput == 1) {
                System.out.print("Введите номер месяца: ");
                int m = scanner.nextInt();
                System.out.print("Введите номер дня: ");
                int d = scanner.nextInt();
                System.out.print("Введите кол-во шагов: ");
                int steps = scanner.nextInt();

                tracker.setSteps(m, d, steps);
            }
            else if (userInput == 2) {
                System.out.print("Введите номер месяца: ");
                int m = scanner.nextInt();

                tracker.showStatistics(m);
            }
            else if (userInput == 3) {
                System.out.print("Введите новую цель: ");
                int target = scanner.nextInt();
                tracker.setTarget(target);
            }
            else {
                System.out.println("Неизвестная команда");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("1.Ввести количество шагов за определённый день");
        System.out.println("2.Напечатать статистику за определённый месяц");
        System.out.println("3.Изменить цель по количеству шагов в день");
        System.out.println("4.Выйти из приложения");
    }

}
