package Chapter15;



import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
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
            throw new RuntimeException(ex);
        }

    }

    public static void writeDataTo2(String data, String fileLocation) throws IOException {
        try(FileOutputStream outputStream = new FileOutputStream(fileLocation)){
            outputStream.write(data.getBytes());
        }
    }

    public static void readFromWeb(String url, String fileLocation) throws MalformedURLException {
            URL uri = URI.create(url).toURL();
        try(InputStream inputStream = uri.openStream();
            FileOutputStream outputStream = new FileOutputStream(fileLocation)){
            byte[] data = inputStream.readAllBytes();
            outputStream.write(data);
            }catch(IOException ex){
                System.err.println("Error:" + ex.getMessage());
                throw new RuntimeException(ex);


        }
    }
}
