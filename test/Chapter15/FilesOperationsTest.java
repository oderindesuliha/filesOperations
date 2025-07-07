package Chapter15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FilesOperationsTest {

    @Test
    void testToReadFrom() {
        String fileLocation = "C:\\Users\\USER\\Desktop\\Chapter15\\test\\files\\data.txt";
        String data = FilesOperations.readFrom(fileLocation);
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }

}