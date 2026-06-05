package abstrak;

public class Segitiga extends BangunDatar {
    // Atribut spesifik untuk Segitiga
    private double alas;
    private double tinggi;

    // Constructor Segitiga: mempassing angka 3 ke superclass karena segitiga punya 3 sisi
    public Segitiga(double alas, double tinggi) {
        super(3);
        this.alas = alas;
        this.tinggi = tinggi;
    }

    // Implementasi seluruh abstract method dari BangunDatar
    @Override
    public void draw() {
        System.out.println("Menggambar sebuah Segitiga.");
    }

    @Override
    public void resize() {
        System.out.println("Mengubah ukuran Segitiga.");
    }

    @Override
    public double getLuas() {
        return 0.5 * alas * tinggi; // Rumus Luas Segitiga
    }

    @Override
    public double getKeliling() {
        return 3 * alas; // Asumsi Segitiga Sama Sisi: alas + alas + alas
    }
}