interface Payable {
    double getPayableAmount();
}

class Invoice implements Payable {
    String productName;
    int quantity;
    int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public double getPayableAmount() {
        return quantity * pricePerItem;
    }

    public void display() {
        System.out.println(productName + " | qty: " + quantity + " | total: " + getPayableAmount());
    }
}

class Employee implements Payable {
    int registrationNumber;
    String name;
    int salaryPerMonth;
    Invoice[] invoices;

    public Employee(int reg, String name, int salary, Invoice[] invoices) {
        this.registrationNumber = reg;
        this.name = name;
        this.salaryPerMonth = salary;
        this.invoices = invoices;
    }

    public double getPayableAmount() {
        double total = 0;
        for (Invoice inv : invoices) {
            total += inv.getPayableAmount();
        }
        return salaryPerMonth - total;
    }

    public void display() {
        System.out.println("Nama: " + name);
        System.out.println("Gaji awal: " + salaryPerMonth);

        System.out.println("Detail belanja:");
        for (Invoice inv : invoices) {
            inv.display();
        }

        System.out.println("Gaji setelah potongan: " + getPayableAmount());
    }
}

public class MainPayable {
    public static void main(String[] args) {

        Invoice i1 = new Invoice("Sabun", 2, 5000);
        Invoice i2 = new Invoice("Shampoo", 1, 15000);

        Invoice[] invoices = {i1, i2};

        Employee emp = new Employee(1, "Artur", 1000000, invoices);

        emp.display();
    }
}
