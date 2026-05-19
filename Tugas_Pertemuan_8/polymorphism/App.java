package polymorphism;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		BangunDatar bd;
		Scanner inputan = new Scanner(System.in);
		
		// --- 1. PERSEGI PANJANG ---
		SegiEmpat persegiPanjang = new SegiEmpat();
		bd = persegiPanjang;
		
		System.out.println("Masukkan Panjang:");
		bd.panjang = inputan.nextDouble();
		
		System.out.println("Masukkan Lebar:");
		bd.lebar = inputan.nextDouble();
		
		double luas = bd.luas();
		bd.cetakLuas("Persegi panjang", luas);
		
		// --- 2. SEGITIGA SIKU-SIKU ---
		Segitiga sikusiku = new Segitiga();
		bd = sikusiku;
		
		System.out.println("Masukkan Panjang:");
		bd.panjang = inputan.nextDouble();
		
		System.out.println("Masukkan Tinggi:");
		bd.tinggi = inputan.nextDouble();
		
		double luas1 = bd.luas(bd.panjang, bd.tinggi);
		bd.cetakLuas("Segitiga siku-siku", luas1);
		
		// --- 3. KREASI BARU: LINGKARAN ---
		System.out.println("\n--- Tambahan Subclass Kreasi Mandiri ---");
		Lingkaran bundar = new Lingkaran();
		bd = bundar;

		System.out.println("Masukkan Jari-jari:");
		bd.panjang = inputan.nextDouble();
		bundar.r = bd.panjang;

		double luasLingkaran = bd.luas();
		bd.cetakLuas("Lingkaran", luasLingkaran);
		
		inputan.close();
	}
}