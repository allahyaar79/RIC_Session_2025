public class SalaryCalculator {
    public static void main(String[] args) {
        int salary = 25000;

        // Increase salary by 15%
        salary += (salary * 15) / 100;
        System.out.println("After 15% increase: " + salary);

        // Deduct tax
        salary -= 2000;
        System.out.println("After tax deduction: " + salary);

        // Add bonus
        salary += 5000;
        System.out.println("After adding bonus: " + salary);

        // Monthly salary
        salary /= 12;
        System.out.println("Monthly salary: " + salary);
    }
}
