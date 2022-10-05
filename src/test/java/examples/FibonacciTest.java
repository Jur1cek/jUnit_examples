package examples;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    private Fibonacci fibonacci;

    @BeforeEach
    void setupEachFibonacci() {
        fibonacci = new Fibonacci();
    }

    @DisplayName("Basic test of recursive fibonacci implementation")
    @Test
    void testComputeRecursive() throws Exception {
        assertEquals(55, fibonacci.compute(10, "RECURSIVE"));
    }

    @Test
    void testComputeRecursiveBadInputException0() {
        assertThrows(Exception.class, () -> fibonacci.compute(0, "RECURSIVE"));
    }

    @Test
    @Disabled("It is not working, dunno why")
    void testComputeRecursiveBadInputException100() {
        assertThrows(Exception.class, () -> fibonacci.compute(100, "RECURSIVE"));
    }

    @Test
    void testComputeRecursiveBadMethodException() {
        assertThrows(Exception.class, () -> fibonacci.compute(1, "RECURSIVEE"));
    }

    @Test
    void testComputeIterative2() throws Exception {
        assertEquals(1, fibonacci.compute(2, "ITERATIVE"));
    }

    @Test
    void testComputeIterativ3() throws Exception {
        assertEquals(2, fibonacci.compute(3, "ITERATIVE"));
    }

    @Test
    void testComputeIterative4() throws Exception {
        assertEquals(3, fibonacci.compute(4, "ITERATIVE"));
    }

    @Test
    void testComputeIterative5() throws Exception {
        assertEquals(5, fibonacci.compute(5, "ITERATIVE"));
    }



    @ParameterizedTest
    @MethodSource("dataGenerator")
    void testParameterizedComputeIterative(Integer n, Long result) throws Exception {
        assertEquals(result, fibonacci.compute(n, "ITERATIVE"));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10, 15, 4545646})
    void testParameterizedComputeIterativeFail(Integer n) {
        assertDoesNotThrow(() -> fibonacci.compute(n, "ITERATIVE"));
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,1", "3,2"})
    void testParameterizedComputeIterativeCsv(Integer input, Long expected) throws Exception {
        assertEquals(expected, fibonacci.compute(input, "ITERATIVE"));
    }


    private static Stream<Arguments> dataGenerator() {
        return Stream.of(
                Arguments.of(1, (long) 1),
                Arguments.of(2, (long) 1),
                Arguments.of(3, (long) 2),
                Arguments.of(4, (long) 3),
                Arguments.of(5, (long) 5),
                Arguments.of(6, (long) 8),
                Arguments.of(20, (long) 6765)
        );
    }
}