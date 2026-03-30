import java.util.Scanner;

public class MainAritmatika {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan nilai 1 untuk pengurangan: ");
        int nil1 = in.nextInt();
        System.out.print("Masukkan nilai 2 untuk pengurangan: ");
        int nil2 = in.nextInt();
        Aritmatika.hitungPengurangan(nil1, nil2);

        System.out.print("Masukkan nilai 1 untuk perkalian: ");
        nil1 = in.nextInt();
        System.out.print("Masukkan nilai 2 untuk perkalian: ");
        nil2 = in.nextInt();
        Aritmatika.hitungPerkalian(nil1, nil2);

        System.out.print("Masukkan nilai 1 untuk penjumlahan: ");
        int value1 = in.nextInt();
        System.out.print("Masukkan nilai 2 untuk penjumlahan: ");
        int value2 = in.nextInt();

        Aritmatika a = new Aritmatika();
        a.hitungPenjumlahan(value1, value2);

        System.out.print("Masukkan nilai 1 untuk pembagian: ");
        String bagi1 = in.next();
        System.out.print("Masukkan nilai 2 untuk pembagian: ");
        String bagi2 = in.next();

        System.out.println("Nilai pembagian adalah: " + a.hitungPembagian(bagi1, bagi2));

        in.close();
    }
}
