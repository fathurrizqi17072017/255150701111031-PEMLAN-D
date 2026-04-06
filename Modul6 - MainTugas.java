import java.time.LocalDate;

public class MainTugas {
    public static void main(String[] args) {
        System.out.println("====== TEST CASE MANUSIA ======");
        // a. Laki-laki telah menikah
        Manusia m1 = new Manusia("Andi", "350111", true, true);
        // b. Perempuan telah menikah
        Manusia m2 = new Manusia("Siti", "350222", false, true);
        // c. Belum menikah
        Manusia m3 = new Manusia("Budi", "350333", true, false);
        
        System.out.println(m1 + "\n");
        System.out.println(m2 + "\n");
        System.out.println(m3 + "\n");


        System.out.println("====== TEST CASE MAHASISWA FILKOM ======");
        // a. IPK < 3
        MahasiswaFILKOM mhs1 = new MahasiswaFILKOM("Cici", "350444", false, false, "215150400111111", 2.8);
        // b. IPK 3 - 3.5
        MahasiswaFILKOM mhs2 = new MahasiswaFILKOM("Dodi", "350555", true, false, "205150200111111", 3.2);
        // c. IPK 3.5 - 4
        MahasiswaFILKOM mhs3 = new MahasiswaFILKOM("Eka", "350666", true, false, "195150700111111", 3.8);
        
        System.out.println(mhs1 + "\n");
        System.out.println(mhs2 + "\n");
        System.out.println(mhs3 + "\n");


        System.out.println("====== TEST CASE PEKERJA ======");
        int currentYear = LocalDate.now().getYear();
        
        // a. Lama bekerja 2 tahun, anak 2
        Pekerja p1 = new Pekerja("Fahmi", "350777", true, true, 4000, LocalDate.of(currentYear - 2, 1, 1), 2);
        // b. Lama bekerja 9 tahun
        Pekerja p2 = new Pekerja("Gita", "350888", false, false, 5000, LocalDate.of(currentYear - 9, 1, 1), 0);
        // c. Lama bekerja 20 tahun, anak 10
        Pekerja p3 = new Pekerja("Hadi", "350999", true, true, 6000, LocalDate.of(currentYear - 20, 1, 1), 10);
        
        System.out.println(p1 + "\n");
        System.out.println(p2 + "\n");
        System.out.println(p3 + "\n");


        System.out.println("====== TEST CASE MANAGER ======");
        // Lama bekerja 15 tahun dengan gaji $7500
        Manager mgr = new Manager("Iwan", "350000", true, true, 7500, LocalDate.of(currentYear - 15, 1, 1), 3, "IT Development");
        
        System.out.println(mgr + "\n");
    }
}
