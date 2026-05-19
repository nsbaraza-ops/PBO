package polymorphism;

public class BangunDatar {
    public double panjang;
    public double lebar;
    public double tinggi;

    public double luas() {
        return 0;
    }

    public double luas(double panjang, double tinggi) {
        return 0;
    }

    public void cetakLuas(String jenisBangun, double nilaiLuas) {
        System.out.println("Luas " + jenisBangun + " adalah " + nilaiLuas);
    }
}