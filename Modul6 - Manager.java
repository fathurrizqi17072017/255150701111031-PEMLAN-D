import java.time.LocalDate;

public class Manager extends Pekerja {
    private String departemen;

    // Constructor
    public Manager(String nama, String nik, boolean jenisKelamin, boolean menikah, double gaji, LocalDate tahunMasuk, int jumlahAnak, String departemen) {
        super(nama, nik, jenisKelamin, menikah, gaji, tahunMasuk, jumlahAnak);
        this.departemen = departemen;
    }

    // Setters
    public void setDepartemen(String departemen) { this.departemen = departemen; }

    // Getters
    public String getDepartemen() { return departemen; }

    @Override
    public double getTunjangan() {
        // Tunjangan tambahan 10% dari gaji
        return super.getTunjangan() + (0.10 * getGaji());
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
            String.format("Departemen    : %s", departemen);
    }
}
