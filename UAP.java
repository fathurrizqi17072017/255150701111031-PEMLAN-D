package GoDriveRental;

import java.util.ArrayList;
import java.util.Scanner;

// ABSTRACT CLASS
abstract class Kendaraan {

    private String kodeKendaraan;
    private String namaKendaraan;
    private double hargaSewaPerHari;
    private boolean isTersedia;

    public Kendaraan(String kode, String nama, double hargaSewa) {
        this.kodeKendaraan = kode;
        this.namaKendaraan = nama;
        this.hargaSewaPerHari = hargaSewa;
        this.isTersedia = true;
    }

    // Getter & Setter
    public String getKodeKendaraan() {
        return kodeKendaraan;
    }

    public void setKodeKendaraan(String kodeKendaraan) {
        this.kodeKendaraan = kodeKendaraan;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public boolean isTersedia() {
        return isTersedia;
    }

    public void setTersedia(boolean tersedia) {
        isTersedia = tersedia;
    }

    // Method abstract
    public abstract void tampilInfo();

    public abstract double hitungBiayaDasar(int lamaSewa);
}

// CLASS MOBIL
class Mobil extends Kendaraan {

    private int jumlahKursi;

    public Mobil(String kode, String nama, double harga, int jumlahKursi) {
        super(kode, nama, harga);
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    @Override
    public void tampilInfo() {
        System.out.println(
                "[MOBIL] Kode: " + getKodeKendaraan() +
                        " | Nama: " + getNamaKendaraan() +
                        " | Kursi: " + jumlahKursi +
                        " | Tarif: Rp" + getHargaSewaPerHari() +
                        "/hari | Status: " +
                        (isTersedia() ? "Tersedia" : "Disewa")
        );
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {

        double total = lamaSewa * getHargaSewaPerHari();

        if (jumlahKursi > 5) {
            total += 50000;
        }

        return total;
    }
}

// CLASS MOTOR
class Motor extends Kendaraan {

    private String jenisTransmisi;

    public Motor(String kode, String nama, double harga, String jenisTransmisi) {
        super(kode, nama, harga);
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi() {
        return jenisTransmisi;
    }

    public void setJenisTransmisi(String jenisTransmisi) {
        this.jenisTransmisi = jenisTransmisi;
    }

    @Override
    public void tampilInfo() {
        System.out.println(
                "[MOTOR] Kode: " + getKodeKendaraan() +
                        " | Nama: " + getNamaKendaraan() +
                        " | Transmisi: " + jenisTransmisi +
                        " | Tarif: Rp" + getHargaSewaPerHari() +
                        "/hari | Status: " +
                        (isTersedia() ? "Tersedia" : "Disewa")
        );
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {

        double total = lamaSewa * getHargaSewaPerHari();

        if (jenisTransmisi.equalsIgnoreCase("Matik")) {
            total += 10000 * lamaSewa;
        }

        return total;
    }
}

// CUSTOM EXCEPTION
class KendaraanTidakTersediaException extends Exception {

    public KendaraanTidakTersediaException(String message) {
        super(message);
    }
}

// CLASS SYSTEM
class GoDriveRentalSystem {

    ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();

    // Tambah kendaraan
    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);

        System.out.println("[INFO] Kendaraan berhasil ditambahkan!");
    }

    // Tampilkan daftar
    public void tampilkanDaftarKendaraan() {

        System.out.println("\n===== DAFTAR ARMADA GODRIVE =====");

        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan.");
            return;
        }

        int no = 1;

        for (Kendaraan k : daftarKendaraan) {
            System.out.print(no + ". ");
            k.tampilInfo();
            no++;
        }
    }

    // Sewa kendaraan
    public void sewaKendaraan(String kode, int lamaSewa)
            throws KendaraanTidakTersediaException {

        Kendaraan kendaraanDipilih = null;

        for (Kendaraan k : daftarKendaraan) {

            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                kendaraanDipilih = k;
                break;
            }
        }

        if (kendaraanDipilih == null) {
            throw new KendaraanTidakTersediaException(
                    "Kendaraan dengan kode " + kode + " tidak ditemukan!"
            );
        }

        if (!kendaraanDipilih.isTersedia()) {
            throw new KendaraanTidakTersediaException(
                    "Kendaraan sedang disewa!"
            );
        }

        double total = kendaraanDipilih.hitungBiayaDasar(lamaSewa);

        kendaraanDipilih.setTersedia(false);

        System.out.println("\n===== TRANSAKSI SEWA GODRIVE =====");
        System.out.println("Kendaraan berhasil disewa!");
        System.out.println("Unit        : "
                + kendaraanDipilih.getNamaKendaraan()
                + " (" + kendaraanDipilih.getKodeKendaraan() + ")");
        System.out.println("Lama Sewa   : " + lamaSewa + " Hari");
        System.out.println("Total Bayar : Rp" + total);
    }

    // Kembalikan kendaraan
    public void kembalikanKendaraan(String kode) {

        for (Kendaraan k : daftarKendaraan) {

            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {

                k.setTersedia(true);

                System.out.println(
                        "[INFO] Kendaraan "
                                + k.getNamaKendaraan()
                                + " (" + k.getKodeKendaraan() + ") "
                                + "berhasil dikembalikan."
                );

                return;
            }
        }

        System.out.println("Kode kendaraan tidak ditemukan!");
    }
}

// MAIN CLASS
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        GoDriveRentalSystem system = new GoDriveRentalSystem();

        int pilih;

        do {

            System.out.println("\n====== MENU GO DRIVE RENTAL SYSTEM ======");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tampilkan Daftar Armada");
            System.out.println("3. Sewa Kendaraan");
            System.out.println("4. Kembalikan Kendaraan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:

                    System.out.print("Masukkan jenis kendaraan (mobil/motor): ");
                    String jenis = input.nextLine();

                    System.out.print("Masukkan kode kendaraan: ");
                    String kode = input.nextLine();

                    System.out.print("Masukkan nama kendaraan: ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan harga sewa per hari: ");
                    double harga = input.nextDouble();
                    input.nextLine();

                    if (jenis.equalsIgnoreCase("mobil")) {

                        System.out.print("Masukkan jumlah kursi: ");
                        int kursi = input.nextInt();
                        input.nextLine();

                        Mobil mobil = new Mobil(
                                kode,
                                nama,
                                harga,
                                kursi
                        );

                        system.tambahKendaraan(mobil);

                    } else if (jenis.equalsIgnoreCase("motor")) {

                        System.out.print("Masukkan jenis transmisi: ");
                        String transmisi = input.nextLine();

                        Motor motor = new Motor(
                                kode,
                                nama,
                                harga,
                                transmisi
                        );

                        system.tambahKendaraan(motor);

                    } else {
                        System.out.println("Jenis kendaraan tidak valid!");
                    }

                    break;

                case 2:

                    system.tampilkanDaftarKendaraan();

                    break;

                case 3:

                    try {

                        System.out.print(
                                "Masukkan kode kendaraan yang ingin disewa: "
                        );

                        String kodeSewa = input.nextLine();

                        System.out.print("Masukkan durasi sewa (hari): ");

                        int lama = input.nextInt();
                        input.nextLine();

                        system.sewaKendaraan(kodeSewa, lama);

                    } catch (KendaraanTidakTersediaException e) {

                        System.out.println(
                                "\nException: " + e.getMessage()
                        );
                    }

                    break;

                case 4:

                    System.out.print(
                            "Masukkan kode kendaraan yang ingin dikembalikan: "
                    );

                    String kodeKembali = input.nextLine();

                    system.kembalikanKendaraan(kodeKembali);

                    break;

                case 5:

                    System.out.println("Program selesai.");

                    break;

                default:

                    System.out.println("Menu tidak tersedia!");
            }

        } while (pilih != 5);

        input.close();
    }
}
