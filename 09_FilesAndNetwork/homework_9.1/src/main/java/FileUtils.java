import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        File mainFolder = new File(path);
        if(!mainFolder.isDirectory()) {
            System.out.println("Not a directory");
            return 0;
        }

        File[] filesInDir = mainFolder.listFiles();
        int result = 0;
        for(File currFile : filesInDir){
            if(currFile.isDirectory()){
                result += calculateFolderSize(currFile.getPath());
            } else result += currFile.length();
        }
        return result;
    }
}
