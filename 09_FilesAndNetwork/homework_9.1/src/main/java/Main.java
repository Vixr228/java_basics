import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path =  scanner.nextLine();
        try {
            System.out.println(FileUtils.calculateFolderSize(path));
        } catch (IllegalArgumentException | IOException | NullPointerException e){
            e.printStackTrace();
        }

    }
}
