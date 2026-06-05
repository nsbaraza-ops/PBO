package abstrak;

public class ResizeMain {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("     PENGUJIAN INTERFACE RESIZEABLE      ");
        System.out.println("=========================================");

        // a. Mendefinisikan objek kotak (panjang = 4, lebar = 5)
        Kotak kotakUji = new Kotak(4, 5);
        kotakUji.draw();
        
        // b. Cetak luas dan keliling objek semula
        System.out.println("\n[Ukuran Semula]");
        System.out.println("Luas Kotak     : " + kotakUji.getLuas());
        System.out.println("Keliling Kotak : " + kotakUji.getKeliling());

        System.out.println("-----------------------------------------");

        // c. Ubah ukuran panjang dan lebar sebesar 2x dari ukuran semula
        kotakUji.resize(2.0);

        System.out.println("-----------------------------------------");

        // d. Cetak kembali luas dan keliling objek setelah di-resize
        System.out.println("[Ukuran Setelah Di-resize 2x]");
        System.out.println("Luas Kotak Baru     : " + kotakUji.getLuas());
        System.out.println("Keliling Kotak Baru : " + kotakUji.getKeliling());
        System.out.println("=========================================");
    }
}