public class StepTracker {

    private MonthData[] monthToData;
    private int target = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setTarget(int newTarget) {
        if (newTarget > 0) {
            target = newTarget;
        }
        else {
            System.out.println("Некорректная цель");
        }
    }

    public void setSteps(int m, int d, int count) {
        if (m < 0 || m >= 12 || d < 0 || d >= 30 || count < 0) {
            System.out.println("Некорректные входные данные");
        }
        else {
            monthToData[m].days[d] = count;
        }
    }

    public int bestSeriesDays(int m) {
        MonthData data = monthToData[m];
        int max = 0;
        for (int i = 0; i < data.days.length; i++) {
            if (data.days[i] > target) {
                int count = 0;
                while (i < data.days.length && data.days[i] > target) {
                    count++;
                    i++;
                }
                if (count > max) {
                    max = count;
                }
            }
        }

        return max;
    }

    public void showStatistics(int m) {
        if (m >= 0 && m < 12) {
            MonthData data = monthToData[m];
            int totalSteps = 0; //общее кол-во шагов за месяц
            int max = 0; //макс кол-во шагов
            for (int i = 0; i < data.days.length; i++) {
                System.out.println(i + 1 + " день: " + data.days[i]);

                totalSteps += data.days[i];
                if (data.days[i] > max) {
                    max = data.days[i];
                }
            }

            int averageSteps = totalSteps / data.days.length; //среднее кол-во шагов
            double distance = Converter.convertStepsToKm(totalSteps); //пройденная дистанция (км)
            double calories = Converter.convertStepsToKilocalories(totalSteps); //Количество сожжённых килокалорий
            int best = bestSeriesDays(m);

            System.out.println("Среднее количество шагов = " + averageSteps);
            System.out.println("Пройденная дистанция = " + distance + " км");
            System.out.println("Количество сожжённых килокалорий = " + calories);
            System.out.println("Лучшая серия = " + best);
        }
        else {
            System.out.println("Неверный месяц");
        }
    }

    class MonthData {
        int[] days;

        public MonthData() {
            days = new int[30];
        }
    }
}

