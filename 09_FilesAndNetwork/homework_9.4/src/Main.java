import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String url = "https://lenta.ru/";
        List<String> urls = parseHTML(url);
        donwloadImages(urls);
        //urls.forEach(System.out::println);



    }

    public static List<String> parseHTML(String url){
        List<String> urls = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("img");
            elements.forEach(element -> {
                urls.add(element.attr("abs:src"));
            });
        } catch (Exception e){
            e.printStackTrace();
        }

        return urls;
    }


    public static void donwloadImages(List<String> urls) throws IOException {
        for(String url : urls) {
            String imgName = getName(url);
            System.out.println(imgName);
            if (imgName == null) continue;
            String path = System.getProperty("user.dir") + "\\images\\" + imgName + ".png";
            Image img = ImageIO.read(new URL(url));
            try {
                BufferedImage bi = (BufferedImage) img;
                File outputFile = new File(path);
                ImageIO.write(bi, "jpg", outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //<” (знак меньше),  „>” (знак больше), „:” (двоеточие), „«” (двойные кавычки), „/” (слеш), „\” (обратный слеш),
    // „|” (вертикальная черта),
    // „?” (вопросительный знак), „*” (звездочка), а также не может заканчиваться точкой или пробелом
    public static String getName(String url) {
        String imgName = "";
        int lastSlash = url.lastIndexOf('/');
        imgName = url.substring(++lastSlash);
        imgName.replaceAll("\\|<>:/\\?\\*", "");
        if(!imgName.contains(".jpg")) return null;
        return imgName;
    }

}
