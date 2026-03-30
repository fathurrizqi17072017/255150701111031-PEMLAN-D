public class Aritmatika {
    public void hitungPenjumlahan(int a, int b) {
        int nilai = a + b;
        System.out.println("Nilai penjumlahan adalah: " + nilai);
    }

    public static void hitungPerkalian(int a, int b) {
        int nilai = a * b;
        System.out.println("Nilai perkalian adalah: " + nilai);
    }

    public static void hitungPengurangan(int a, int b) {
        int nilai = a - b;
        System.out.println("Nilai pengurangan adalah: " + nilai);
    }

    public double hitungPembagian(String nil1, String nil2) {
        double a = Double.parseDouble(nil1);
        double b = Double.parseDouble(nil2);
        return a / b;
    }
}
