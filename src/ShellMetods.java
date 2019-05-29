import java.io.*;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ShellMetods {
    private Path dir;
    private String filename;

    public ShellMetods() {
    }

    public void newDir(String dirPath) {
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
        if (file.isFile()) {
            if (file.delete()) {
                System.out.println("file " + linkFile + " delete");
            }
        }
    }

    public void rmDir(String linDir) {
        File file = new File(linDir);
        if (file.isDirectory()) {
            if (file.delete()) {
                System.out.println("folder " + linDir + " delete");
            }
        }
    }
    public void copyFile(String source, String dest) throws IOException {
        //File in = new File(source);
        //File out = new File(dest);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

}
