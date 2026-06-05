package abstrak;

public class SepedaMain {
    public static void main(String[] args) {
        
        System.out.println("=== PENGUJIAN OBJEK SEPEDA PERTAMA ===");
        // 1. Membuat objek sepeda dengan isAuto = false (Sepeda Manual/Kayuh)
        Sepeda sepedaManual = new Sepeda(false);
        sepedaManual.nyalakan();
        sepedaManual.jenis(); // Ini akan memunculkan "Sepeda kayuh"

        System.out.println("\n=== PENGUJIAN OBJEK SEPEDA KEDUA ===");
        // 2. Membuat objek sepeda dengan isAuto = true (Sepeda Otomatis)
        Sepeda sepedaOtomatis = new Sepeda(true);
        sepedaOtomatis.nyalakan();
        sepedaOtomatis.jenis(); // Ini akan memunculkan "Sepeda otomatis"
        
    }
}