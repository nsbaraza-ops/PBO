package polymorphism;

public class Lingkaran extends BangunDatar {
    public double r;

    @Override
    public double luas() {
        return Math.PI * r * r;
    }
}