package abstrak;

public class BangunDatarMain {
    public static void main(String[] args) {
        // Membuat objek Kotak dengan panjang = 6 dan lebar = 4
        Kotak kotakSaya = new Kotak(6, 4);

        // Membuat objek Segitiga dengan alas = 6 dan tinggi = 5
        Segitiga segitigaSaya = new Segitiga(6, 5);

        System.out.println("================================");
        System.out.println("     PENGUJIAN OBJEK KOTAK      ");
        System.out.println("================================");
        kotakSaya.draw();
        System.out.println("Jumlah Sisi : " + kotakSaya.getJumlahSisi());
        System.out.println("Luas Kotak  : " + kotakSaya.getLuas());
        System.out.println("Keliling    : " + kotakSaya.getKeliling());
        kotakSaya.pindahkan(10, 5);

        System.out.println("\n================================");
        System.out.println("    PENGUJIAN OBJEK SEGITIGA    ");
        System.out.println("================================");
        segitigaSaya.draw();
        System.out.println("Jumlah Sisi : " + segitigaSaya.getJumlahSisi());
        System.out.println("Luas Segitiga: " + segitigaSaya.getLuas());
        System.out.println("Keliling    : " + segitigaSaya.getKeliling());
        segitigaSaya.pindahkan(3, 7);
    }
}