import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader jShell = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("$>");
            String comReader = jShell.readLine();
            String[] arg = comReader.split("\\s");
            switch (arg[0]) {
                case ("touch"):
                    if (arg.length > 1) {
                        TouchMkDir touch = new TouchMkDir();
                        touch.newFile(arg[1]);
                    } else {
                        System.out.println("Не указано имя файла");
                    }
                    break;
                case ("mkdir"):
                    if (arg.length > 1) {
                        TouchMkDir mkDir = new TouchMkDir();
                        mkDir.newDir(arg[1]);
                        break;
                    } else {
                        System.out.println("Не указано имя папки");
                    }
                    break;
                case ("cp"):
                    break;
                case ("mv"):
                    break;
                case ("rmdir"):
                    break;
                case ("rm"):
                    break;
                case ("ls"):
                    break;
                case ("exit"):
                    System.out.println("jShell Close");
                    System.exit(0);
                    break;

            }
        }
    }
}
