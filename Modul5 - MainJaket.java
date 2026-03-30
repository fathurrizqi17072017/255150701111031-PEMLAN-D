import java.util.Scanner;

public class MainJaket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Jaket jaket = new Jaket();

        System.out.print("Masukkan jumlah Jaket A: ");
        int jumlahA = input.nextInt();
        System.out.print("Masukkan jumlah Jaket B: ");
        int jumlahB = input.nextInt();
        System.out.print("Masukkan jumlah Jaket C: ");
        int jumlahC = input.nextInt();

        int hargaA = jaket.getHargaJaketA(jumlahA);
        int hargaB = jaket.getHargaJaketB(jumlahB);
        int hargaC = jaket.getHargaJaketC(jumlahC);

        int totalA = jaket.getTotalA(jumlahA);
        int totalB = jaket.getTotalB(jumlahB);
        int totalC = jaket.getTotalC(jumlahC);

        int grandTotal = totalA + totalB + totalC;

        System.out.println("\n===== RINCIAN PEMBELIAN =====");
        System.out.println("Jaket A : " + jumlahA + " x Rp " + hargaA + " = Rp " + totalA);
        System.out.println("Jaket B : " + jumlahB + " x Rp " + hargaB + " = Rp " + totalB);
        System.out.println("Jaket C : " + jumlahC + " x Rp " + hargaC + " = Rp " + totalC);
        System.out.println("Grand Total = Rp " + grandTotal);

        input.close();
    }
}
