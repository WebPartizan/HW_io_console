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

    public void cP(String source, String dest) throws IOException {

        File inFile = new File(source);
        File outFile = new File(dest);

        if (inFile.isDirectory() || outFile.isDirectory()) {
            if (!outFile.exists()) {
                outFile.mkdirs();
            }
            String files[] = inFile.list();
            if (files != null) {
                for (String file : files) {
                    File srcFile = new File(inFile, file);
                    File destFile = new File(outFile, file);

                    cP(srcFile.toString(), destFile.toString());
                }
            } else {
                outFile = new File(outFile, inFile.getName());
                outFile.createNewFile();
            }
        } else {
            InputStream in = null;
            OutputStream out = null;

            try {

                in = new FileInputStream(inFile);
                out = new FileOutputStream(outFile);

                byte[] buffer = new byte[1024];

                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            } catch (Exception e) {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                try {
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private void delFilDir(String source) throws IOException {
        File inFile = new File(source);
        if (inFile.isDirectory()) {
            String[] children = inFile.list();
            for (int i = 0; i < children.length; i++) {
                File f = new File(inFile, children[i]);
                delFilDir(f.toString());
            }
            inFile.delete();
        } else inFile.delete();

    }

    public void mV(String source, String dest) throws IOException {
        cP(source, dest);
        delFilDir(source);
    }

}





