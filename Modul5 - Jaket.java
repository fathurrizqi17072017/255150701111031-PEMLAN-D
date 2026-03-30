public class Jaket {
    public static final int HARGA_A = 100000;
    public static final int HARGA_B = 125000;
    public static final int HARGA_C = 175000;

    public int getHargaJaketA(int jumlah) {
        if (jumlah > 100) {
            return 95000;
        }
        return HARGA_A;
    }

    public int getHargaJaketB(int jumlah) {
        if (jumlah > 100) {
            return 120000;
        }
        return HARGA_B;
    }

    public int getHargaJaketC(int jumlah) {
        if (jumlah > 100) {
            return 160000;
        }
        return HARGA_C;
    }

    public int getTotalA(int jumlah) {
        return getHargaJaketA(jumlah) * jumlah;
    }

    public int getTotalB(int jumlah) {
        return getHargaJaketB(jumlah) * jumlah;
    }

    public int getTotalC(int jumlah) {
        return getHargaJaketC(jumlah) * jumlah;
    }
}
