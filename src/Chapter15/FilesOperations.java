package Chapter15;

import Chapter15.exception.InvalidPathException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilesOperations {
    public static String readFrom(String fileLocation) {
        Path path = Path.of(fileLocation);
        StringBuilder data = new StringBuilder();
        try(BufferedReader reader = Files.newBufferedReader(path)){
            List<String> text = reader.lines().toList();
//            while(reader.ready()) data.append(reader.readLine());
            for(String word : text){
                data.append(word);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return data.toString();
    }

    public static void writeDataTo(String data, String fileLocation) throws IOException {
        Path path = Path.of(fileLocation);
        if(!Files.exists(path)){

            Files.createFile(path);

        }
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write(data);
        }catch(IOException ex){
            throw new RuntimeException();
        }

    }
}
