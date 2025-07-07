package Chapter15;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesOperations {
    public static String readFrom(String fileLocation) {
        Path path = Path.of(fileLocation);
        StringBuilder data = new StringBuilder();
        try(BufferedReader reader = Files.newBufferedReader(path)){
            while(reader.ready()) data.append(reader.readLine());
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return data.toString();
    }

}
