import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача Лягушка");
        System.out.println("+N - прыгни на N шагов направо");
        System.out.println("-N - прыгни на N шагов налево");
        System.out.println("<< - Undo (отмени последнюю команду)");
        System.out.println(">> - Redo (повтори отменённую команду)");
        System.out.println("!! - повтори последнюю команду");
        System.out.println("0 - выход");

        Frog frog = new Frog();

        Scanner scanner = new Scanner(System.in);

        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        while (true) {
            //считываем ввод и конструируем комманду, если
            //пользователь не хотел выйти
            String inputCommand = scanner.nextLine();

            if (inputCommand.equalsIgnoreCase("0")) {
                break;
            } else if (inputCommand.equalsIgnoreCase("<<")) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (inputCommand.equalsIgnoreCase(">>")) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего отменять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).doit();
                }
            } else if (inputCommand.equalsIgnoreCase("!!")) {
                if (commands.size()  == 0) {
                    System.out.println("Нечего повторять!");
                } else {
                    commands.get(commands.size() - 1).doit();
                }
            } else { //пользователь ввёл новое движение для лягушки
                if (curCommand != commands.size() - 1)
                    for (int i = commands.size() - 1; i > curCommand ; i--)
                        commands.remove(curCommand);
                int step = Integer.parseInt(inputCommand);
                FrogCommand cmd = FrogCommands.jumpRightCommand(frog, step);
                curCommand++;
                commands.add(cmd);
                cmd.doit();
                }
            System.out.println(frog.position);
            }


        }
}
