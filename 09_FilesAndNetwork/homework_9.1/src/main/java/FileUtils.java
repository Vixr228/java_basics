import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static long calculateFolderSize(String path) throws IllegalArgumentException, NullPointerException, IOException {
        if(path.equals(null))  throw new IOException("Path is null");
        File mainFolder = new File(path);
        if(!mainFolder.exists()) throw new NullPointerException("Path doesn't exist");
        if(!mainFolder.isDirectory()) {
           throw new IllegalArgumentException("It is not a directory");
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
