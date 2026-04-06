import java.time.LocalDate;
import java.time.Period;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    // Constructor
    public Pekerja(String nama, String nik, boolean jenisKelamin, boolean menikah, double gaji, LocalDate tahunMasuk, int jumlahAnak) {
        super(nama, nik, jenisKelamin, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }

    // Setters
    public void setGaji(double gaji) { this.gaji = gaji; }
    public void setTahunMasuk(LocalDate tahunMasuk) { this.tahunMasuk = tahunMasuk; }
    public void setJumlahAnak(int jumlahAnak) { this.jumlahAnak = jumlahAnak; }

    // Getters
    public double getGaji() { return gaji; }
    public LocalDate getTahunMasuk() { return tahunMasuk; }
    public int getJumlahAnak() { return jumlahAnak; }

    // Logic Bonus Berdasarkan Lama Bekerja
    public double getBonus() {
        int lamaBekerja = Period.between(tahunMasuk, LocalDate.now()).getYears();
        if (lamaBekerja >= 0 && lamaBekerja <= 5) {
            return 0.05 * gaji;
        } else if (lamaBekerja > 5 && lamaBekerja <= 10) {
            return 0.10 * gaji;
        } else if (lamaBekerja > 10) {
            return 0.15 * gaji;
        }
        return 0.0;
    }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (jumlahAnak * 20.0);
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + getGaji() + getBonus();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
            String.format(
                "Tahun Masuk   : %d %d %d\n" +
                "Jumlah Anak   : %d\n" +
                "Gaji          : $%.1f",
                tahunMasuk.getDayOfMonth(), tahunMasuk.getMonthValue(), tahunMasuk.getYear(),
                jumlahAnak, gaji
            );
    }
}
