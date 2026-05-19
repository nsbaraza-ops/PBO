public class OverloadMain {
    // 1. Method main UTAMA yang akan dijalankan pertama kali oleh JVM
    public static void main(String[] args) {
        System.out.println("Ini adalah main utama (String[] args)");
        
        // Memanggil method main yang di-overload secara manual
        main("Halo mahasiswa semester 4!");
        main(10, 20);
    }

    // 2. Overload method main dengan parameter String tunggal
    public static void main(String arg1) {
        System.out.println("Ini main overload dengan 1 String: " + arg1);
    }

    // 3. Overload method main dengan dua parameter int
    public static void main(String of, int angka1, int angka2) { // Kamu bisa sesuaikan parameternya
        System.out.println("Ini main overload dengan angka: " + (angka1 + angka2));
    }
    
    // Versi sederhana dua int
    public static void main(int x, int y) {
        System.out.println("Ini main overload dengan int x dan y: " + (x + y));
    }
}