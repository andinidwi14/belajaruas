import java.util.Scanner;

public class belajar {

    // 1. Deklarasi Variable dan scanner
    Scanner sc = new Scanner(System.in);
    String[] namaMahasiswa = new String[3];
    double[] nilaiMahasiswa = new double[3];
    boolean dataDisimpan = false;

    // 2. Membuat Method untuk menampilkan Menu
    public void tampilkanMenu() {
        System.out.println("\n===== Menu Program =====");
        System.out.println("1. Input Nilai Mahasiswa");
        System.out.println("2. Tampilkan Semua Nilai Mahasiswa");
        System.out.println("3. Hitung Jumlah Mahasiswa Lulus dan Tidak Lulus");
        System.out.println("4. Keluar Program");
        System.out.print("Pilih menu (1-4): ");
    }

    // 3. Membuat fungsi input
    public int inputPilihan() {
        try {
            int pilihan = sc.nextInt();
            sc.nextLine();
            return pilihan;
        } catch (Exception e) {
            sc.nextLine();
            return -1;
        }
    }

    // 4. Membuat method untuk input nilai mahasiswa
    public void inputNilaiMahasiswa() {
        System.out.println("\n===== Input Nilai Mahasiswa =====");
        for (int i = 0; i < 3; i++) {
            System.out.print("Masukkan nama mahasiswa ke-" + (i + 1) + ": ");
            namaMahasiswa[i] = sc.nextLine();

            System.out.print("Masukkan nilai akhir: ");
            try {
                nilaiMahasiswa[i] = sc.nextDouble();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Input nilai tidak valid. Masukkan angka.");
                sc.nextLine();
                i--;
            }
        }
        dataDisimpan = true;
        System.out.println("Data nilai mahasiswa berhasil disimpan.");
    }

    // 5. Membuat method untuk menampilkan semua nilai
    public void tampilkanSemuaNilai() {
        System.out.println("\n===== Daftar Nilai Mahasiswa =====");
        if (!dataDisimpan) {
            System.out.println("Data belum tersedia. Silakan input data terlebih dahulu.");
            return;
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.println(
                        "Mahasiswa ke-" + (i + 1) + ": " + namaMahasiswa[i] + " - Nilai: " + nilaiMahasiswa[i]);
            }
        }
    }

    // 6. Membuat method untuk menghitung kelulusan
    public void hitungKelulusan() {
        System.out.println("\n===== Hasil Kelulusan =====");
        if (!dataDisimpan) {
            System.out.println("Data belum tersedia. Silakan input data terlebih dahulu.");
            return;
        } else {

            int lulus = 0;
            int tidakLulus = 0;

            for (int i = 0; i < 3; i++) {
                if (nilaiMahasiswa[i] >= 60) {
                    lulus++;
                    System.out.println(namaMahasiswa[i] + " (Nilai: " + nilaiMahasiswa[i] + ") - LULUS");
                } else {
                    tidakLulus++;
                    System.out.println(namaMahasiswa[i] + " (Nilai: " + nilaiMahasiswa[i] + ") - TIDAK LULUS");
                }
            }

            System.out.println("\nRingkasan:");
            System.out.println("Jumlah Mahasiswa Lulus: " + lulus);
            System.out.println("Jumlah Mahasiswa Tidak Lulus: " + tidakLulus);
        }
    }

    // 7. Membuat fungsi untuk mengulangi program
    public boolean tanyaUlangi() {
        System.out.print("\nApakah ingin mengulang program? (ya/tidak): ");
        String jawab = sc.nextLine().toLowerCase();

        while (!jawab.equals("ya") && !jawab.equals("tidak")) {
            System.out.print("Input tidak valid. Masukkan 'ya' atau 'tidak': ");
            jawab = sc.nextLine().toLowerCase();
        }

        return jawab.equals("ya");
    }

    public static void main(String[] args) {
        // 8. Membuat object
        belajar obj = new belajar();

        boolean lanjut = true;

        // 9. Membuat perulangan untuk mengulangi program
        while (lanjut) {
            obj.tampilkanMenu();
            int pilihan = obj.inputPilihan();

            // 10. Membuat Switch Case
            switch (pilihan) {
                case 1:
                    obj.inputNilaiMahasiswa();
                    break;
                case 2:
                    obj.tampilkanSemuaNilai();
                    break;
                case 3:
                    obj.hitungKelulusan();
                    break;
                case 4:
                    System.out.println("Program berhenti. Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan menu tidak valid.");
            }

            lanjut = obj.tanyaUlangi();
        }

        obj.sc.close();

    }
}