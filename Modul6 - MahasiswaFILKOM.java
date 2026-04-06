public class MahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;

    // Constructor
    public MahasiswaFILKOM(String nama, String nik, boolean jenisKelamin, boolean menikah, String nim, double ipk) {
        super(nama, nik, jenisKelamin, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }

    // Setters
    public void setNim(String nim) { this.nim = nim; }
    public void setIpk(double ipk) { this.ipk = ipk; }

    // Getters
    public String getNim() { return nim; }
    public double getIpk() { return ipk; }

    // Logic Status Mahasiswa
    public String getStatus() {
        String angkatan = "20" + nim.substring(0, 2);
        char prodiCode = nim.charAt(6);
        String prodi = "";
        
        switch (prodiCode) {
            case '2': prodi = "Teknik Informatika"; break;
            case '3': prodi = "Teknik Komputer"; break;
            case '4': prodi = "Sistem Informasi"; break;
            case '6': prodi = "Pendidikan Teknologi Informasi"; break;
            case '7': prodi = "Teknologi Informasi"; break;
            default: prodi = "Program Studi Tidak Diketahui";
        }
        
        return prodi + ", " + angkatan;
    }

    // Logic Beasiswa
    public double getBeasiswa() {
        if (ipk >= 3.5 && ipk <= 4.0) {
            return 75.0;
        } else if (ipk >= 3.0 && ipk < 3.5) {
            return 50.0;
        } else {
            return 0.0;
        }
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + getBeasiswa();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
            String.format(
                "NIM           : %s\n" +
                "IPK           : %.2f\n" +
                "Status        : %s",
                nim, ipk, getStatus()
            );
    }
}
