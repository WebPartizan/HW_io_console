import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader miniJShell = new BufferedReader(new InputStreamReader(System.in));
            ShellMetods metods = new ShellMetods();
            System.out.print("$>");
            String comReader = miniJShell.readLine();
            String[] arg = comReader.split("\\s");
            switch (arg[0]) {
                case ("touch"):
                    if (arg.length > 1) {
                        metods.newFile(arg[1]);
                    } else {
                        System.out.println("Не указано имя файла");
                    }
                    break;
                case ("mkdir"):
                    if (arg.length > 1) {
                        metods.newDir(arg[1]);
                        break;
                    } else {
                        System.out.println("Не указано имя папки");
                    }
                    break;
                case ("cp"):
                    metods.cP(arg[1], arg[2]);
                    break;
                case ("mv"):
                    metods.mV(arg[1], arg[2]);
                    break;
                case ("rmdir"):
                    metods.rmDir(arg[1]);
                    break;
                case ("rm"):
                    metods.rmFiles(arg[1]);
                    break;
                case ("ls"):
                    metods.lsDir(arg[1]);
                    break;
                case ("exit"):
                    System.out.println("miniJShell Close");
                    System.exit(0);
                    break;

            }
        }
    }
}
