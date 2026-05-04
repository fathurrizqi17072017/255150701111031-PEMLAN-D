public class Mahasiswa {
    private String nama, ttl, noDaftar, noTelp, alamat, email;

    public Mahasiswa(String nama, String ttl, String noDaftar,
                     String noTelp, String alamat, String email) {
        this.nama = nama;
        this.ttl = ttl;
        this.noDaftar = noDaftar;
        this.noTelp = noTelp;
        this.alamat = alamat;
        this.email = email;
    }

    public String getData() {
        return "Nama           : " + nama + "\n" +
               "Tanggal Lahir  : " + ttl + "\n" +
               "No. Pendaftaran: " + noDaftar + "\n" +
               "No. Telp       : " + noTelp + "\n" +
               "Alamat         : " + alamat + "\n" +
               "E-mail         : " + email;
    }
}
