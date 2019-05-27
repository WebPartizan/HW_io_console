import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TouchMkDir {
    private Path dir;
    private String filename;

    public TouchMkDir() {
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
}
