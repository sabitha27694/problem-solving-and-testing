// Using standard JUnit 5 style logic skeleton
public class CalculatorTest {
    static class Calculator {
        public int add(int a, int b) { return a + b; }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        assert calc.add(2, 3) == 5 : "Test Failed!";
        assert calc.add(-1, 1) == 0 : "Test Failed!";
        System.out.println("All Calculator Unit Tests Passed Successfully.");
    }
}