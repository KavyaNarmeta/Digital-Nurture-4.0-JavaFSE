public class FinancialForecast {

    public static double forecastRecursive(double initialAmount, double growthRate, int years) {
        if (years == 0) {
            return initialAmount;
        }
        return forecastRecursive(initialAmount, growthRate, years - 1) * (1 + growthRate);
    }

   
    public static double forecastIterative(double initialAmount, double growthRate, int years) {
        double result = initialAmount;
        for (int i = 0; i < years; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }

    public static void main(String[] args) {
        double initialAmount = 10000; 
        double growthRate = 0.10;     
        int years = 5;

        System.out.println("Financial Forecasting:");
        System.out.println("Initial Amount: ₹" + initialAmount);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);

        double recursiveResult = forecastRecursive(initialAmount, growthRate, years);
        double iterativeResult = forecastIterative(initialAmount, growthRate, years);

        System.out.printf("\nRecursive Result: ₹%.2f\n", recursiveResult);
        System.out.printf("Iterative (Optimized) Result: ₹%.2f\n", iterativeResult);
    }
}
