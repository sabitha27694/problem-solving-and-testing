public class BankingSystem {
    static class Account {
        private double balance;
        public Account(double balance) { this.balance = balance; }
        public synchronized void deposit(double amount) { balance += amount; }
        public synchronized void withdraw(double amount) {
            if (balance >= amount) balance -= amount;
        }
        public double getBalance() { return balance; }
    }

    public static void main(String[] args) throws InterruptedException {
        Account acc = new Account(1000.0);
        Thread t1 = new Thread(() -> acc.deposit(500));
        Thread t2 = new Thread(() -> acc.withdraw(200));
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Final Balance: " + acc.getBalance());
    }
}