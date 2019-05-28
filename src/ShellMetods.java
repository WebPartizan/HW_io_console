import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ShellMetods {
    private Path dir;
    private String filename;

    public ShellMetods () {
    }

    public void newDir (String dirPath){
        try {
            Files.createDirectories(Paths.get(dirPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void newFile(String filename) {
        try {
            dir = Files.createDirectories(Paths.get(Paths.get("").toAbsolutePath().toString()));
            OutputStream out = Files.newOutputStream(dir.resolve(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lsDir(String linkDir) throws IOException {
        Stream<Path> stream = Files.walk(Paths.get(linkDir), FileVisitOption.FOLLOW_LINKS);
        stream.forEach(System.out::println);
    }

    public void rmFiles(String linkFile) {
        File file = new File(linkFile);
        if (file.delete()) {
            System.out.println("file " + linkFile + " delete");
        }
    }

}
