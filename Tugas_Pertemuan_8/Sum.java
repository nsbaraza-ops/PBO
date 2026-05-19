// Kelas Sum yang mendemonstrasikan keuntungan Overloading
public class Sum {
    // Method 1: Memiliki 2 parameter bertipe int
    public int jumlah(int x, int y) {
        return (x + y);
    }
    // Method 2: Memiliki 3 parameter bertipe int
    public int jumlah(int x, int y, int z) {
        return (x + y + z);
    }
    // Method 3: Memiliki 2 parameter bertipe double
    public double jumlah(double x, double y) {
        return (x + y);
    }
    // Driver code untuk menjalankan program
    public static void main(String args[]) {
        Sum s = new Sum();
        // Cukup memanggil satu nama method 'jumlah', namun bisa menerima berbagai input
        System.out.println(s.jumlah(10, 20));       // Memanggil Method 1
        System.out.println(s.jumlah(10, 20, 30));   // Memanggil Method 2
        System.out.println(s.jumlah(10.5, 20.5));   // Memanggil Method 3
    }
}