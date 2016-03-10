package EightLesson.Chapter_4_Task_1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadPage {

    public DownloadPage() {

    }

    public void download() {
        File file = new File("D:\\MyProgectJava\\Catalog\\EightLesson\\Chapter_4_Task_1\\DownloadSite.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            URL url = new URL("http://www.quizful.net/post/Crawling-Java");
            URLConnection connection = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            writer = new BufferedWriter(new FileWriter(file));

            String s;
            while ((s = reader.readLine()) != null) {
                writer.newLine();
                writer.write(s);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
