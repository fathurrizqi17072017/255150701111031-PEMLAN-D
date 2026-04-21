interface MakhlukHidup {
    void makan();
    void berjalan();
    void bersuara();
}

interface Identitas {
    void tampilkanNama();
    void tampilkanUmur();
}

class Manusia implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;

    public Manusia(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public void makan() {
        System.out.println("Makan pakai sendok garpu");
    }

    public void berjalan() {
        System.out.println("Jalan pakai dua kaki");
    }

    public void bersuara() {
        System.out.println("Suaranya merdu");
    }

    public void tampilkanNama() {
        System.out.println("Nama: " + nama);
    }

    public void tampilkanUmur() {
        System.out.println("Umur: " + umur);
    }
}

class Hewan implements MakhlukHidup, Identitas {
    public void makan() {
        System.out.println("Makan pakai mulut");
    }

    public void berjalan() {
        System.out.println("Jalan pakai 4 kaki");
    }

    public void bersuara() {
        System.out.println("Suaranya tidak jelas");
    }

    public void tampilkanNama() {
        System.out.println("Nama hewan tidak diketahui");
    }

    public void tampilkanUmur() {
        System.out.println("Umur hewan tidak diketahui");
    }
}

public class MainManusia {
    public static void main(String[] args) {

        Manusia m = new Manusia("Artur", 20);
        Hewan h = new Hewan();

        System.out.println("=== MANUSIA ===");
        m.tampilkanNama();
        m.tampilkanUmur();
        m.makan();
        m.berjalan();
        m.bersuara();

        System.out.println("\n=== HEWAN ===");
        h.tampilkanNama();
        h.tampilkanUmur();
        h.makan();
        h.berjalan();
        h.bersuara();
    }
}
