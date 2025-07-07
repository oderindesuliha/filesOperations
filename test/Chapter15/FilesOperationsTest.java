package Chapter15;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;


public class FilesOperationsTest {
    private static String folder = "C:\\Users\\USER\\Desktop\\Chapter15\\test\\files\\";

    @Test
    void testCanReadFromFile() {
        String fileLocation = folder.concat("data.txt");
        String data = FilesOperations.readFrom(fileLocation);
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }

    @Test
    void testCanWriteToFile() throws IOException {
        String fileLocation = folder.concat("Output.java");
        String data = """
                package files;
                
                import java.util.Arrays;
                public class Output {
                public static void main(String[] args) {
                System.out.println(Arrays.toString(args));
                    }
                }
                """;
        FilesOperations.writeDataTo2(data,fileLocation);
        String fileData = FilesOperations.readFrom(fileLocation);
        assertNotNull(fileData);
        assertFalse(fileData.isEmpty());
   }

   @Test
    void testCanReadFromTheWeb() throws MalformedURLException {
        String url = "https://jsonplaceholder.typicode.com/posts";
        String fileLocation = folder.concat("data.json");
        FilesOperations.readFromWeb(url,fileLocation);
        String data = FilesOperations.readFrom(fileLocation);
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }
}
