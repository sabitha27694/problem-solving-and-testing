public class SalaryTransformer {
    private double basicSalary;
    private double allowances;
    private double bonus;
    private double taxRate;

    public SalaryTransformer(double basicSalary, double allowances, double bonus, double taxRate) {
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.bonus = bonus;
        this.taxRate = taxRate;
    }

    public double calculateGrossSalary() {
        return basicSalary + allowances + bonus;
    }

    public double calculateTaxDeduction() {
        return calculateGrossSalary() * (taxRate / 100);
    }

    public double calculateNetSalary() {
        return calculateGrossSalary() - calculateTaxDeduction();
    }

    public void generatePaySlip() {
        System.out.println("--- Pay Slip Summary ---");
        System.out.println("Basic Salary: $" + basicSalary);
        System.out.println("Allowances:   $" + allowances);
        System.out.println("Bonus:        $" + bonus);
        System.out.println("Gross Salary: $" + calculateGrossSalary());
        System.out.println("Tax Deducted: $" + calculateTaxDeduction());
        System.out.println("Net Salary:   $" + calculateNetSalary());
    }

    public static void main(String[] args) {
        // Example: Transforming base inputs into processed payroll outputs
        SalaryTransformer employee = new SalaryTransformer(5000.0, 1200.0, 800.0, 15.0);
        employee.generatePaySlip();
    }
}