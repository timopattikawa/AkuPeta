package akupeta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String Isource, Idestination;
        int sourCode, destCode;
//        Digunakan while agar program dapat jalan terus sampai user memberhentikannya
        while(true) {
            System.out.println("Selamat Datang DI App Cari Jalur");
            System.out.println("Nama Kota Dalam Aplikasi");
            System.out.println("1. Jogja");
            System.out.println("2. Klaten");
            System.out.println("3. Solo");
            System.out.println("4. Boyoloali");
            System.out.println("5. Salatiga");
            System.out.println("6. Ambarawa");
            System.out.println("7. Semarang");
            System.out.println("8. Magelang");
            System.out.println("=====================================");

//            User diminta input nama kota asal
            System.out.print("Masukan Nama Kota Asal \t\t: ");
            Isource = in.nextLine().toLowerCase();

//            User diminta input nama kota tujuan
            System.out.print("Masukan Nama Kota Tujuan \t: ");
            Idestination = in.nextLine().toLowerCase();
            System.out.println("=====================================");

//            Objek untuk Mencari SEMUA JALUR
//            constructor menerima parameter source dan destination
            Graph ap = new APGraph(Isource, Idestination);
//            Objek Untuk Mencari JALUR TERCEPAT
//            constructor menerima parameter source dan destination
            Graph spt = new STPGraph(Isource, Idestination);

//            Cek Apakah Ada Kotanya pada method there is a city
            if (ap.thereIsaCity()) {
                System.out.println("Maaf Kota Yang Di Masukan Belum Terdaftar!!");
            } else {
//                Jika ada akan dilakukan pencarian semua jalur terlebih dahulu lalu di print
                System.out.println("Mencari Semua Jalur");
                ap.searchPath();
                ap.printPath();
                System.out.println("\n=====================================");
                System.out.println("Mencari Jalur Tercepat");
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                Setelah itu mencari jalur tercepat lalu di print
                System.out.println();
                spt.searchPath();
                spt.printPath();
                System.out.println("\n=====================================");
            }
//            user diminta membuat keputusan untuk melanjutkan prorgram atau tidak.
            System.out.print("Ingin Menggunakan Aplikasi Ini Lagi? (Y/n): ");
            char continueProgram = in.nextLine().charAt(0);
            if(continueProgram == 'N' || continueProgram == 'n') {
                System.out.println("Terima Kasih Telah Menggunakan Program Kami");
                break;
            }
        }
    }
}
