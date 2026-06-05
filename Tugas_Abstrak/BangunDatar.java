package abstrak;

public abstract class BangunDatar {
    // 1. Atribut sesuai spesifikasi diagram
    private int jumlahSisi;
    protected int x;
    protected int y;

    // 2. Constructor: mengisi jumlahSisi dengan nilai dari parameter sisi
    public BangunDatar(int sisi) {
        this.jumlahSisi = sisi;
    }

    // 3. Method konkret untuk memindahkan koordinat
    public void pindahkan(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Posisi objek berhasil dipindahkan ke koordinat (" + x + ", " + y + ")");
    }

    // 4. Getter konkret untuk mengambil nilai jumlahSisi
    public int getJumlahSisi() {
        return this.jumlahSisi;
    }

    // 5. Kumpulan Abstract Method yang wajib di-override oleh subclass
    public abstract void draw();
    public abstract void resize();
    public abstract double getLuas();
    public abstract double getKeliling();
}