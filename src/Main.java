import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {


    private static Type taskType;
    private static TaskMetod taskMetod;

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            addTask(taskMetod, scanner);
                            break;
                        case 2:
                            removeTask(taskMetod, scanner);
                            break;
                        case 3:
                            getTaskByDay(taskMetod, scanner);
                            break;
                        case 4:
//                            getAllTaskFromTaskList(taskMetod,scanner);
//                            break;
//                        case 5:
//                            editTask(taskMetod,scanner);
//                            break;
//                        case 6:
//                            getDeletedTask();
//                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        scanner.next();
        System.out.print("Введите описание задачи: ");
        String distription = scanner.next();
        System.out.print("Введите дату задачи: дд.мм.гггг: ");
        String date = scanner.next();
        LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("Введите время задачи: ЧЧ.мм: ");
        String time = scanner.next();
        LocalTime tasktime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime resultDate = LocalDateTime.of(taskDate, tasktime);
        System.out.println("Введите вид задачи: личная (1), рабочая(2) ");
        int type = scanner.nextInt();
        if (type == 1) {
            taskType = Type.PERSONAL;
        } else {
            taskType = Type.WORK;
        }
        System.out.println("Введите повторяемость задачи");
        System.out.println("Не требует повторения -0");
        System.out.println("Повторяется каждый день- 1");
        System.out.println("Повторяется каждую неделю- 2");
        System.out.println("Повторяется каждый месяц- 3");
        System.out.println("Повторяется каждый год- 4");
        int typeTask = scanner.nextInt();
        switch (typeTask) {
            case 0:
                taskMetod.add(new Task(taskName, distription, type, resultDate));
                break;
            case 1:
                taskMetod.add(new DailyTask(taskName, distription, type, resultDate));
                break;
            case 2:
                taskMetod.add(new WeekTask(taskName, distription, type, resultDate));
                break;
            case 3:
                taskMetod.add(new WeekTask(taskName, distription, type, resultDate));
                break;
            case 4:
                taskMetod.add(new MonthTask(taskName, distription, type, resultDate));
                break;
            case 5:
                taskMetod.add(new YearTask(taskName, distription, type, resultDate));
                break;
        }
    }

    private static void addTask(TaskMetod taskMetod, Scanner scanner) {
    }

    private static void removeTask(TaskMetod taskMetod, Scanner scanner) {
    }

    private static void getTaskByDay(TaskMetod taskMetod, Scanner scanner) {
        System.out.print("Введите дату задачи: дд.мм.гггг: ");
        String date = scanner.next();
        LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        var allTaskBodyDay = taskMetod.getAllByDate(taskDate.atStartOfDay());
        System.out.println("Задачи на день:");
        for (Task task : allTaskBodyDay) {
            System.out.println(task);
        }
    }
    private static void  printMenu(){
        System.out.println(
                "                 1. Добавить задачу\n" +
                "                        2. Удалить задачу\n" +
                "                        3. Получить задачу на указанный день\n" +
                "                        0. Выход\n" );
    }
}