package examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileManipulatorTest {

    @Test
    void getFirstLine() {
        FileManipulator fileManipulator = new FileManipulator("src/test/resources/testfile.txt");

        assertEquals("First Line", fileManipulator.getLines().get(0));
    }
}