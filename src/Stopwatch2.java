import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Stopwatch2 adalah aplikasi konsol yang berfungsi sebagai stopwatch.
 * Aplikasi ini memungkinkan pengguna untuk memulai, menghentikan,
 * mencatat waktu lap, dan menampilkan waktu lap.
 */
public class Stopwatch2 {

    /**
     * Metode utama yang menjalankan aplikasi stopwatch.
     * Pengguna dapat memberikan perintah untuk mengontrol stopwatch.
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = 0; // Total waktu yang telah berlalu
        long startTime = 0; // Waktu mulai stopwatch
        boolean isRunning = false; // Status stopwatch
        List<Long> lapTimes = new ArrayList<>(); // Daftar waktu lap

        while (true) {
            System.out.print("Enter command (start, stop, lap, show, exit): ");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "start":
                    if (!isRunning) {
                        startTime = System.currentTimeMillis(); // Menyimpan waktu mulai
                        isRunning = true;
                        System.out.println("Stopwatch started.");
                    }
                    break;
                case "stop":
                    if (isRunning) {
                        t += System.currentTimeMillis() - startTime; // Menghitung total waktu
                        isRunning = false;
                        System.out.println("Stopwatch stopped. Total elapsed time: " + (t / 1000) + " seconds.");
                    }
                    break;
                case "lap":
                    if (isRunning) {
                        long lapTime = System.currentTimeMillis() - startTime + t; // Menghitung waktu lap
                        lapTimes.add(lapTime); // Menyimpan waktu lap
                        System.out.println("Lap time recorded: " + (lapTime / 1000) + " seconds.");
                    }
                    break;
                case "show":
                    System.out.println("Lap Times:");
                    for (int i = 0; i < lapTimes.size(); i++) {
                        System.out.println("Lap " + (i + 1) + ": " + (lapTimes.get(i) / 1000) + " seconds."); // Menampilkan waktu lap
                    }
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close(); // Menutup scanner
                    return;
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}
