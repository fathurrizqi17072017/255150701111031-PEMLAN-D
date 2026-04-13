public class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat() {
        return berat;
    }

    @Override
    public double hitungHarga() {
        return getHarga() * berat;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Berat: %.1f kg | Total: %.2f (Kue Pesanan)", berat, hitungHarga());
    }
}
