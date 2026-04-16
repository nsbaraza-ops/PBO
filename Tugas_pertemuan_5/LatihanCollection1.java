import java.util.TreeSet;

public class LatihanCollection1 {
    public static void main(String[] args) {
        // 1. Inisialisasi TreeSet bertipe String
        TreeSet<String> daftarBuku = new TreeSet<>();

        // 2. Memasukkan data buku ke dalam TreeSet
        daftarBuku.add("Buku Tulis");
        daftarBuku.add("Buku Dongeng");
        daftarBuku.add("Mahaguru");
        daftarBuku.add("Laskar Pelangi");
        
        // Memasukkan data duplikat (otomatis akan diabaikan oleh sistem)
        daftarBuku.add("Buku Tulis");
        daftarBuku.add("Mahaguru");

        // 3. Menampilkan isi TreeSet menggunakan perulangan for-each
        System.out.println("Daftar Buku Perpustakaan:");
        for (String buku : daftarBuku) {
            System.out.println(buku);
        }
    }
}