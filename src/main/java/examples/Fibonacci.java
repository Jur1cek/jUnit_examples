package examples;

import Exceptions.BadInputException;

public class Fibonacci {
    public long compute(int n, String method) throws Exception {
        if (n <= 0) {
            throw new BadInputException("Bad input given: " + n);
        }

        switch (method) {
            case "RECURSIVE":
                return fibko_recursive(n);
            case "ITERATIVE":
                return fibko_iterative(n);
            default:
                throw new Exception("Bad method given: " + method);
        }
    }


    private long fibko_recursive(int n) {
        if (n <= 1) {
            return n;
        }

        return fibko_recursive(n - 1) + fibko_recursive(n - 2);
    }

    private long fibko_iterative(int n) {

        long current = 1;
        long last = 0;
        long tmp;
        for (int i = 1; i < n; i++) {
            tmp = current;
            current = current + last;
            last = tmp;
        }

        return current;
    }
}
