import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String destination = scanner.nextLine();
        try{
            FileUtils.copyFolder(source, destination);
        } catch (Exception e){
            e.printStackTrace();
        }
       // System.out.println("END");
    }
}
