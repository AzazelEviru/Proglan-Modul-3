import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Menu {
    private String namaMakanan;
    private double harga;

    public Menu(String namaMakanan, double harga) {
        this.namaMakanan = namaMakanan;
        this.harga = harga;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public double getHarga() {
        return harga;
    }
}

class Pemesanan {
    private List<Menu> daftarPesanan = new ArrayList<>();

    // Metode untuk menambahkan pesanan ke daftar
    public void tambahPesanan(Menu menu) {
        daftarPesanan.add(menu);
    }

    // Metode untuk menampilkan nota dan menghitung total pembayaran
    public void tampilkanNota() {
        System.out.println("Nota Pemesanan:");
        double total = 0; // Variabel untuk menyimpan total harga

                // Menghitung total harga dari semua pesanan
                for (Menu menu : daftarPesanan) {
                    System.out.println(menu.getNamaMakanan() + " - Rp. " + menu.getHarga());
                    total += menu.getHarga(); // Menambahkan harga setiap menu ke total
                }

                // Menampilkan total harga
                System.out.println("Total: Rp. " + total);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pemesanan pemesanan = new Pemesanan();

        // Daftar menu
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("Nasi Goreng", 20000));
        menuList.add(new Menu("Mie Ayam", 15000));
        menuList.add(new Menu("Ayam Penyet", 25000));
        menuList.add(new Menu("Sate", 30000));

        System.out.println("Selamat datang di Restoran!");
        System.out.println("Daftar Menu:");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getNamaMakanan() + " - Rp. " + menuList.get(i).getHarga());
        }

        String lagi;
        do {
            System.out.print("Pilih nomor menu yang ingin dipesan: ");
            int pilihan = scanner.nextInt();

            if (pilihan > 0 && pilihan <= menuList.size()) {
                pemesanan.tambahPesanan(menuList.get(pilihan - 1)); // Menambahkan pesanan
                System.out.println("Pesanan ditambahkan: " + menuList.get(pilihan - 1).getNamaMakanan());
            } else {
                System.out.println("Pilihan tidak valid.");
            }

            System.out.print("Apakah Anda ingin memesan lagi? (ya/tidak): ");
            lagi = scanner.next();
        } while (lagi.equalsIgnoreCase("ya"));

        // Menampilkan nota dan total pembayaran
        pemesanan.tampilkanNota();
        scanner.close();
    }
}
