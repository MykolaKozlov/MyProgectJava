package EightLesson.Chapter_3_Task_5;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Arhivator {

    private String path;

    public Arhivator() {
    }

    private String returnPathName(String dir) {
        String getNeme = null;
        File file = new File(dir);
        path = file.getPath();
        if (file.isFile()) {
            getNeme = file.getPath().substring(0, file.getPath().indexOf(".")) + ".zip";
        } else if (file.isDirectory()) {
            getNeme = file.getPath() + ".zip";
        }
        return getNeme;
    }

    public void createZip(String dir) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(returnPathName(dir)))) {
            File file = new File(dir);
            if (file.isFile()) {
                zipFile(zipOutputStream, file);
            } else {
                doZip(file, zipOutputStream);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void zipFile(ZipOutputStream zipOutputStream, File file) throws IOException {
        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
        write(new FileInputStream(file), zipOutputStream);
    }


    private void doZip(File dir, ZipOutputStream out) throws IOException {
        for (File f : dir.listFiles()) {
            if (f.isDirectory())
                doZip(f, out);
            else {
                out.putNextEntry(new ZipEntry(f.getPath().substring(path.length() + 1, f.getPath().length())));
                write(new FileInputStream(f), out);
            }
        }
    }

    private void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
    }
}

