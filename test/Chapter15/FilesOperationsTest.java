package Chapter15;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class FilesOperationsTest {

    @Test
    void testCanReadFromFile() {
        String fileLocation = "C:\\Users\\USER\\Desktop\\Chapter15\\test\\files\\data.txt";
        String data = FilesOperations.readFrom(fileLocation);
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }

    @Test
    void testCanWriteToFile() throws IOException {
        String fileLocation = "C:\\Users\\USER\\Desktop\\Chapter15\\test\\files\\Output.java";
        String data = """
                package file;
                
                public class Output {
                public static void main(String[] args) {
                System.out.println(Arrays.toString(args));
                    }
                }
                """;
        FilesOperations.writeDataTo(data,fileLocation);
        String fileData = FilesOperations.readFrom(fileLocation);
        assertNotNull(fileData);
        assertFalse(fileData.isEmpty());
   }
}
