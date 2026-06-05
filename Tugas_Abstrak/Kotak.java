package abstrak;

// 2. Menambahkan "implements Resizeable" di samping "extends BangunDatar"
public class Kotak extends BangunDatar implements Resizeable {
    private double panjang;
    private double lebar;

    public Kotak(double panjang, double lebar) {
        super(4); 
        this.panjang = panjang;
        this.lebar = lebar;
    }

    // --- Implementasi Method Baru dari Interface Resizeable ---
    @Override
    public void resize(double x) {
        // Mengalikan panjang dan lebar sebesar x kali dari ukuran semula
        this.panjang = this.panjang * x;
        this.lebar = this.lebar * x;
        System.out.println("-> Ukuran Kotak berhasil di-resize sebesar " + x + "x");
    }

    // --- Implementasi Method bawaan BangunDatar (Tetap Sama) ---
    @Override
    public void draw() {
        System.out.println("Menggambar sebuah Kotak.");
    }

    @Override
    public void resize() {
        System.out.println("Mengubah ukuran Kotak (Tanpa parameter).");
    }

    @Override
    public double getLuas() {
        return panjang * lebar;
    }

    @Override
    public double getKeliling() {
        return 2 * (panjang + lebar);
    }
}