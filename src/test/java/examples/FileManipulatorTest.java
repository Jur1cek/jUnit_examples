package examples;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


class FileManipulatorTest {
    FileManipulator fileManipulator;

    @BeforeEach
    void setUp() {
        this.fileManipulator = new FileManipulator("src/test/resources/testfile.txt");
    }

    @Test
    void getFirstLine() {
        Assumptions.assumeTrue(this.fileManipulator.file.length() > 0);

        assertEquals("First Line", this.fileManipulator.getLines().get(0));
    }

    @Test
    void getLastLine() {
        Assumptions.assumeTrue(this.fileManipulator.file.length() > 0);

        List<String> lines = this.fileManipulator.getLines();

        assertNull(lines.get(lines.size() - 1));
    }

    @AfterEach()
    void end() throws IOException {
        fileManipulator.getFileReader().close();
    }
}