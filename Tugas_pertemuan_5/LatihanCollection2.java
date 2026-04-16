import java.util.ArrayList;

public class LatihanCollection2 {
    public static void main(String[] args) {
        // 1. Inisialisasi ArrayList untuk menyimpan daftar buku
        ArrayList<String> daftarBuku = new ArrayList<>();

        // Memasukkan data buku
        daftarBuku.add("Buku Tulis");
        daftarBuku.add("Buku Dongeng");
        daftarBuku.add("Laskar Pelangi");
        daftarBuku.add("Mahaguru");

        String bukuYangDicari = "Mahaguru";

        // 2. Mengecek apakah buku "Mahaguru" ada menggunakan method contains()
        System.out.println("--- Pengecekan Buku ---");
        if (daftarBuku.contains(bukuYangDicari)) {
            System.out.println("Status: Buku \"" + bukuYangDicari + "\" TERSEDIA dan bisa dipinjam.");
        } else {
            System.out.println("Status: Maaf, buku \"" + bukuYangDicari + "\" TIDAK TERSEDIA.");
        }

        // 3. Mencetak semua buku dengan looping for tanpa index (for-each)
        System.out.println("\n--- Daftar Keseluruhan Buku ---");
        for (String buku : daftarBuku) {
            System.out.println("- " + buku);
        }
    }
}
