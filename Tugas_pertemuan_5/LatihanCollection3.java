import java.util.LinkedHashMap;
import java.util.Map;

public class LatihanCollection3 {
    public static void main(String[] args) {
        // 1. Inisialisasi Map (String untuk Key, String untuk Value)
        // Menggunakan LinkedHashMap agar urutan input tetap terjaga
        Map<String, String> dataDeveloper = new LinkedHashMap<>();

        // 2. Memasukkan data ke dalam Map menggunakan method put()
        dataDeveloper.put("Microsoft", "Bill Gates");
        dataDeveloper.put("Apple", "Steven Paul Jobs");
        dataDeveloper.put("Linux", "Linus Benedict Torvalds"); 
        dataDeveloper.put("Facebook", "Mark Zuckerberg");
        dataDeveloper.put("Twitter", "Jack Dorsey");
        dataDeveloper.put("Instagram", "Kevin Systrom");

        // 3. Menampilkan output sesuai format yang diminta
        System.out.println("Program Menampilkan Developer");
        System.out.println("-----------------------------------");
        
        // Melakukan perulangan untuk mengambil setiap Key dari Map
        for (String key : dataDeveloper.keySet()) {
            // Mengubah key menjadi huruf kapital
            String namaPerusahaan = key.toUpperCase(); 
            // Mengambil value berdasarkan key
            String namaPengembang = dataDeveloper.get(key); 
            
            // Mencetak hasil
            System.out.println(namaPerusahaan + " dikembangkan oleh " + namaPengembang);
        }
    }
}
