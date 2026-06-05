package abstrak;

// 1. Menghubungkan Sepeda sebagai subclass dari Kendaraan
public class Sepeda extends Kendaraan {
    // 2. Menambahkan atribut privat isAuto sesuai diagram
    private boolean isAuto;

    // 3. Membuat Constructor untuk mengisi nilai atribut isAuto saat objek dibuat
    public Sepeda(boolean isAuto) {
        this.isAuto = isAuto;
    }

    // 4. Mengimplementasikan method jenis() sesuai dengan ketentuan soal
    public void jenis() {
        if (this.isAuto) {
            System.out.println("Sepeda otomatis"); // Jika isAuto bernilai true
        } else {
            System.out.println("Sepeda kayuh");    // Jika isAuto bernilai false
        }
    }

    // 5. WAJIB meng-override method nyalakan() dari abstract class Kendaraan
    // Jika bagian ini tidak ditulis, class Sepeda akan mengalami kompilasi error!
    @Override
    public void nyalakan() {
        System.out.println("Sepeda siap digunakan.");
    }
}