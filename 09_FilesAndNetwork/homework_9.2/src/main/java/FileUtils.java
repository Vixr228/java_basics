import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IllegalArgumentException, IOException {
        //System.out.println("Start");
        if(sourceDirectory == null || destinationDirectory == null) throw new IOException("Null paths");
        File source = new File(sourceDirectory);
        if(!source.isDirectory()) throw new IllegalArgumentException("Source is not a directory");
        File[] filesInDir = source.listFiles();


        Path destDir = Paths.get(destinationDirectory);
        for(File currFile : filesInDir){
           // System.out.println(currFile.getPath());
            if(currFile.isDirectory()){
                Files.copy(currFile.toPath(), destDir.resolve(currFile.getName()), StandardCopyOption.REPLACE_EXISTING);
                copyFolder(currFile.getPath(), destDir.resolve(currFile.getName()).toString());

            } else {
                Files.copy(currFile.toPath(), destDir.resolve(currFile.getName()), StandardCopyOption.REPLACE_EXISTING);
            }
        }


    }
}
