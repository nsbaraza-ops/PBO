package model;

public class Mhs {
    private String nim;
    private String nama;
    private double nilaiUts;
    private double nilaiUas;
    private double nilaiTugas;

    // Konstruktor
    public Mhs(String nim, String nama, double nilaiUts, double nilaiUas, double nilaiTugas) {
        this.nim = nim;
        this.nama = nama;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
        this.nilaiTugas = nilaiTugas;
    }

    // Perhitungan nilai akhir dengan bobot UTS (35%), UAS (35%), dan Tugas (30%)
    public double uts() { return nilaiUts * 0.35; }
    public double uas() { return nilaiUas * 0.35; }
    public double tugas() { return nilaiTugas * 0.30; }
    
    public double nilaiAkhir() {
        return uts() + uas() + tugas();
    }

    // Penentuan Nilai Huruf
    public char getNilHuruf(double na) {
        if (na >= 85) return 'A';
        else if (na >= 70) return 'B';
        else if (na >= 55) return 'C';
        else if (na >= 40) return 'D';
        else return 'E';
    }

    // Penentuan Predikat berdasarkan Nilai Huruf
    public String getPredikat(char huruf) {
        switch (huruf) {
            case 'A': return "Istimewa";
            case 'B': return "Baik";
            case 'C': return "Cukup";
            case 'D': return "Kurang";
            default: return "Sangat Kurang";
        }
    }

    // Getter (Encapsulation)
    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public double getNilaiUts() { return nilaiUts; }
    public double getNilaiUas() { return nilaiUas; }
    public double getNilaiTugas() { return nilaiTugas; }
}