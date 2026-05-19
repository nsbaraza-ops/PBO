package polymorphism;

public class SegiEmpat extends BangunDatar {
    @Override
    public double luas() {
        return panjang * lebar;
    }

    public int luas(int sisi) {
        return sisi * sisi;
    }
}