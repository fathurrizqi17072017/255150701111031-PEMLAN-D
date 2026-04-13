public class MainKue {
    public static void main(String[] args) {
        Kue[] daftarKue = new Kue[20];

        daftarKue[0] = new KuePesanan("Lapis Legit", 50000, 1.5);
        daftarKue[1] = new KueJadi("Donat Glaze", 5000, 12);
        daftarKue[2] = new KuePesanan("Brownies", 60000, 0.8);
        daftarKue[3] = new KueJadi("Roti Isi", 7000, 5);
        daftarKue[4] = new KuePesanan("Bika Ambon", 45000, 2.0);
        daftarKue[5] = new KueJadi("Kue Sus", 3000, 20);
        daftarKue[6] = new KuePesanan("Kue Tart", 150000, 1.2);
        daftarKue[7] = new KueJadi("Onde-onde", 2500, 10);
        daftarKue[8] = new KuePesanan("Bolu Gulung", 40000, 0.5);
        daftarKue[9] = new KueJadi("Pastel", 3500, 15);
        daftarKue[10] = new KuePesanan("Kue Lumpur", 25000, 1.0);
        daftarKue[11] = new KueJadi("Lemper", 3000, 30);
        daftarKue[12] = new KuePesanan("Kue Cubit", 20000, 0.4);
        daftarKue[13] = new KueJadi("Klepon", 5000, 8);
        daftarKue[14] = new KuePesanan("Kue Mangkok", 30000, 1.1);
        daftarKue[15] = new KueJadi("Bakpia", 4000, 25);
        daftarKue[16] = new KuePesanan("Kue Putu", 15000, 0.6);
        daftarKue[17] = new KueJadi("Nagasari", 2500, 12);
        daftarKue[18] = new KuePesanan("Serabi", 12000, 1.3);
        daftarKue[19] = new KueJadi("Dadargulung", 3000, 10);

        System.out.println("=== DAFTAR SEMUA KUE ===");
        for (Kue k : daftarKue) {
            System.out.println(k);
        }

        double totalHargaSemua = 0;
        double totalHargaPesanan = 0;
        double totalBeratPesanan = 0;
        double totalHargaJadi = 0;
        double totalJumlahJadi = 0;
        
        Kue kueTermahal = daftarKue[0];

        for (Kue k : daftarKue) {
            double hargaAkhir = k.hitungHarga();
            totalHargaSemua += hargaAkhir;

            if (k instanceof KuePesanan) {
                totalHargaPesanan += hargaAkhir;
                totalBeratPesanan += ((KuePesanan) k).getBerat();
            } else if (k instanceof KueJadi) {
                totalHargaJadi += hargaAkhir;
                totalJumlahJadi += ((KueJadi) k).getJumlah();
            }

            if (hargaAkhir > kueTermahal.hitungHarga()) {
                kueTermahal = k;
            }
        }

        System.out.println("\n=== ANALISIS DATA KUE ===");
        System.out.printf("Total Harga Semua Kue          : Rp %.2f\n", totalHargaSemua);
        System.out.printf("Total Harga Kue Pesanan        : Rp %.2f\n", totalHargaPesanan);
        System.out.printf("Total Berat Kue Pesanan        : %.2f kg\n", totalBeratPesanan);
        System.out.printf("Total Harga Kue Jadi           : Rp %.2f\n", totalHargaJadi);
        System.out.printf("Total Jumlah Kue Jadi          : %.0f biji\n", totalJumlahJadi);
        
        System.out.println("\n=== KUE DENGAN HARGA TERMAHAL ===");
        System.out.println(kueTermahal);
    }
}
