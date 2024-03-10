package stokBarang;
import java.util.ArrayList;
import java.util.Scanner;

class StokBarangHabisPakai {
    private static int counter = 1; // Counter untuk nomor otomatis
    private int nomor;
    private int codeBarang;
    private String namaBarang;
    private int stokAwal;
    private int stokAkhir;
    private int barangMasuk;
    private int barangKeluar;
    private String keterangan;

    public StokBarangHabisPakai(int codeBarang, String namaBarang, int stokAwal, int barangMasuk, int barangKeluar, String keterangan) {
        this.nomor = counter++;
        this.codeBarang = codeBarang;
        this.namaBarang = namaBarang;
        this.stokAwal = stokAwal;
        this.barangMasuk = barangMasuk;
        this.barangKeluar = barangKeluar;
        this.keterangan = keterangan;
        this.stokAkhir = stokAwal + barangMasuk - barangKeluar;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public int getCodeBarang() {
        return codeBarang;
    }

    public void setCodeBarang(int codeBarang) {
        this.codeBarang = codeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStokAwal() {
        return stokAwal;
    }

    public void setStokAwal(int stokAwal) {
        this.stokAwal = stokAwal;
    }

    public int getStokAkhir() {
        return stokAkhir;
    }

    public void setStokAkhir(int stokAkhir) {
        this.stokAkhir = stokAkhir;
    }

    public int getBarangMasuk() {
        return barangMasuk;
    }

    public void setBarangMasuk(int barangMasuk) {
        this.barangMasuk = barangMasuk;
    }

    public int getBarangKeluar() {
        return barangKeluar;
    }

    public void setBarangKeluar(int barangKeluar) {
        this.barangKeluar = barangKeluar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "StokBarangHabisPakai{" +
                "nomor=" + nomor +
                ", codeBarang=" + codeBarang +
                ", namaBarang='" + namaBarang + '\'' +
                ", stokAwal=" + stokAwal +
                ", stokAkhir=" + stokAkhir +
                ", barangMasuk=" + barangMasuk +
                ", barangKeluar=" + barangKeluar +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}

class StokBarangTidakHabisPakai {
    private static int counter = 1; // Counter untuk nomor otomatis
    private int nomor;
    private int codeBarang;
    private String namaBarang;
    private int stokAwal;
    private int stokAkhir;
    private int barangMasuk;
    private int barangKeluar;
    private String keterangan;

    public StokBarangTidakHabisPakai(int codeBarang, String namaBarang, int stokAwal, int barangMasuk, int barangKeluar, String keterangan) {
        this.nomor = counter++;
        this.codeBarang = codeBarang;
        this.namaBarang = namaBarang;
        this.stokAwal = stokAwal;
        this.barangMasuk = barangMasuk;
        this.barangKeluar = barangKeluar;
        this.keterangan = keterangan;
        this.stokAkhir = stokAwal + barangMasuk - barangKeluar;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public int getCodeBarang() {
        return codeBarang;
    }

    public void setCodeBarang(int codeBarang) {
        this.codeBarang = codeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStokAwal() {
        return stokAwal;
    }

    public void setStokAwal(int stokAwal) {
        this.stokAwal = stokAwal;
    }

    public int getStokAkhir() {
        return stokAkhir;
    }

    public void setStokAkhir(int stokAkhir) {
        this.stokAkhir = stokAkhir;
    }

    public int getBarangMasuk() {
        return barangMasuk;
    }

    public void setBarangMasuk(int barangMasuk) {
        this.barangMasuk = barangMasuk;
    }

    public int getBarangKeluar() {
        return barangKeluar;
    }

    public void setBarangKeluar(int barangKeluar) {
        this.barangKeluar = barangKeluar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "StokBarangTidakHabisPakai{" +
                "nomor=" + nomor +
                ", codeBarang=" + codeBarang +
                ", namaBarang='" + namaBarang + '\'' +
                ", stokAwal=" + stokAwal +
                ", stokAkhir=" + stokAkhir +
                ", barangMasuk=" + barangMasuk +
                ", barangKeluar=" + barangKeluar +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}

public class Main {
    private static ArrayList<StokBarangHabisPakai> stokBarangHabisPakaiList = new ArrayList<>();
    private static ArrayList<StokBarangTidakHabisPakai> stokBarangTidakHabisPakaiList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("========================================");
            System.out.println("----------------------------------------");
            System.out.println("Menu:");
            System.out.println("----------------------------------------");
            System.out.println("\n1. Kelola Stok Barang Habis Pakai");
            System.out.println("\n2. Kelola Stok Barang Tidak Habis Pakai");
            System.out.println("\n3. Keluar");
            System.out.println("----------------------------------------");
            System.out.println("========================================");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    menuStokBarangHabisPakai();
                    break;
                case 2:
                    menuStokBarangTidakHabisPakai();
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    private static void menuStokBarangHabisPakai() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("========================================");
            System.out.println("----------------------------------------");
            System.out.println("Menu Stok Barang Habis Pakai:");
            System.out.println("----------------------------------------");
            System.out.println("\n1. Tambah Stok Barang");
            System.out.println("\n2. Lihat Semua Stok Barang");
            System.out.println("\n3. Ubah Stok Barang");
            System.out.println("\n4. Hapus Stok Barang");
            System.out.println("\n5. Kembali ke Menu Utama");
            System.out.println("----------------------------------------");
            System.out.println("========================================");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tambahStokBarangHabisPakai();
                    break;
                case 2:
                    lihatSemuaStokBarangHabisPakai();
                    break;
                case 3:
                    ubahStokBarangHabisPakai();
                    break;
                case 4:
                    hapusStokBarangHabisPakai();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void menuStokBarangTidakHabisPakai() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("========================================");
            System.out.println("----------------------------------------");
            System.out.println("Menu Stok Barang Tidak Habis Pakai:");
            System.out.println("----------------------------------------");
            System.out.println("\n1. Tambah Stok Barang");
            System.out.println("\n2. Lihat Semua Stok Barang");
            System.out.println("\n3. Ubah Stok Barang");
            System.out.println("\n4. Hapus Stok Barang");
            System.out.println("\n5. Kembali ke Menu Utama");
            System.out.println("----------------------------------------");
            System.out.println("========================================");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tambahStokBarangTidakHabisPakai();
                    break;
                case 2:
                    lihatSemuaStokBarangTidakHabisPakai();
                    break;
                case 3:
                    ubahStokBarangTidakHabisPakai();
                    break;
                case 4:
                    hapusStokBarangTidakHabisPakai();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void tambahStokBarangHabisPakai() {
        System.out.print("Code Barang: ");
        int codeBarang = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Stok Awal: ");
        int stokAwal = scanner.nextInt();
        System.out.print("Barang Masuk: ");
        int barangMasuk = scanner.nextInt();
        System.out.print("Barang Keluar: ");
        int barangKeluar = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Keterangan: ");
        String keterangan = scanner.nextLine();

        StokBarangHabisPakai stokBarang = new StokBarangHabisPakai(codeBarang, namaBarang, stokAwal, barangMasuk, barangKeluar, keterangan);
        stokBarangHabisPakaiList.add(stokBarang);
        System.out.println("Stok barang habis pakai berhasil ditambahkan.");
    }

    private static void tambahStokBarangTidakHabisPakai() {
        System.out.print("Code Barang: ");
        int codeBarang = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Stok Awal: ");
        int stokAwal = scanner.nextInt();
        System.out.print("Barang Masuk: ");
        int barangMasuk = scanner.nextInt();
        System.out.print("Barang Keluar: ");
        int barangKeluar = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Keterangan: ");
        String keterangan = scanner.nextLine();

        StokBarangTidakHabisPakai stokBarang = new StokBarangTidakHabisPakai(codeBarang, namaBarang, stokAwal, barangMasuk, barangKeluar, keterangan);
        stokBarangTidakHabisPakaiList.add(stokBarang);
        System.out.println("Stok barang tidak habis pakai berhasil ditambahkan.");
    }

    private static void lihatSemuaStokBarangHabisPakai() {
        if (stokBarangHabisPakaiList.isEmpty()) {
            System.out.println("Tidak ada stok barang habis pakai yang tersedia.");
            return;
        }
        System.out.println("===================================================================================================================");
        System.out.printf("| %-5s | %-10s | %-20s | %-10s | %-10s | %-10s | %-10s | %-15s |\n", "No", "Code", "Nama Barang", "Stok Awal", "Masuk", "Keluar", "Stok Akhir", "Keterangan");
        System.out.println("===================================================================================================================");
        for (StokBarangHabisPakai stokBarang : stokBarangHabisPakaiList) {
            System.out.printf("| %-5d | %-10d | %-20s | %-10d | %-10d | %-10d | %-10d | %-15s |\n", stokBarang.getNomor(), stokBarang.getCodeBarang(), stokBarang.getNamaBarang(), stokBarang.getStokAwal(), stokBarang.getBarangMasuk(), stokBarang.getBarangKeluar(), stokBarang.getStokAkhir(), stokBarang.getKeterangan());
        }
        System.out.println("===================================================================================================================");
    }

    private static void lihatSemuaStokBarangTidakHabisPakai() {
        if (stokBarangTidakHabisPakaiList.isEmpty()) {
            System.out.println("Tidak ada stok barang tidak habis pakai yang tersedia.");
            return;
        }
        System.out.println("===================================================================================================================");
        System.out.printf("| %-5s | %-10s | %-20s | %-10s | %-10s | %-10s | %-10s | %-15s |\n", "No", "Code", "Nama Barang", "Stok Awal", "Masuk", "Keluar", "Stok Akhir", "Keterangan");
        System.out.println("===================================================================================================================");
        for (StokBarangTidakHabisPakai stokBarang : stokBarangTidakHabisPakaiList) {
            System.out.printf("| %-5d | %-10d | %-20s | %-10d | %-10d | %-10d | %-10d | %-15s |\n", stokBarang.getNomor(), stokBarang.getCodeBarang(), stokBarang.getNamaBarang(), stokBarang.getStokAwal(), stokBarang.getBarangMasuk(), stokBarang.getBarangKeluar(), stokBarang.getStokAkhir(), stokBarang.getKeterangan());
        }
        System.out.println("===================================================================================================================");
    }

    private static void ubahStokBarangHabisPakai() {
        System.out.print("Masukkan code stok barang yang akan diubah: ");
        int codeBarang = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        StokBarangHabisPakai stokBarang = findStokBarangHabisPakaiByCode(codeBarang);
        if (stokBarang == null) {
            System.out.println("Stok barang tidak ditemukan.");
            return;
        }
    
        System.out.print("Nama Barang: ");
        stokBarang.setNamaBarang(scanner.nextLine());
        System.out.print("Stok Awal: ");
        stokBarang.setStokAwal(scanner.nextInt());
        System.out.print("Barang Masuk: ");
        stokBarang.setBarangMasuk(scanner.nextInt());
        System.out.print("Barang Keluar: ");
        stokBarang.setBarangKeluar(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.print("Keterangan: ");
        stokBarang.setKeterangan(scanner.nextLine());
    
        stokBarang.setStokAkhir(stokBarang.getStokAwal() + stokBarang.getBarangMasuk() - stokBarang.getBarangKeluar());
        System.out.println("Stok barang habis pakai berhasil diubah.");
    }

    private static void ubahStokBarangTidakHabisPakai() {
        System.out.print("Masukkan code stok barang yang akan diubah: ");
        int codeBarang = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        StokBarangTidakHabisPakai stokBarang = findStokBarangTidakHabisPakaiByCode(codeBarang);
        if (stokBarang == null) {
            System.out.println("Stok barang tidak ditemukan.");
            return;
        }
    
        System.out.print("Nama Barang: ");
        stokBarang.setNamaBarang(scanner.nextLine());
        System.out.print("Stok Awal: ");
        stokBarang.setStokAwal(scanner.nextInt());
        System.out.print("Barang Masuk: ");
        stokBarang.setBarangMasuk(scanner.nextInt());
        System.out.print("Barang Keluar: ");
        stokBarang.setBarangKeluar(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.print("Keterangan: ");
        stokBarang.setKeterangan(scanner.nextLine());
    
        stokBarang.setStokAkhir(stokBarang.getStokAwal() + stokBarang.getBarangMasuk() - stokBarang.getBarangKeluar());
        System.out.println("Stok barang tidak habis pakai berhasil diubah.");
    }

    private static void hapusStokBarangHabisPakai() {
        System.out.print("Masukkan code stok barang yang akan dihapus: ");
        int codeBarang = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        StokBarangHabisPakai stokBarang = findStokBarangHabisPakaiByCode(codeBarang);
        if (stokBarang == null) {
            System.out.println("Stok barang tidak ditemukan.");
            return;
        }

        stokBarangHabisPakaiList.remove(stokBarang);
        System.out.println("Stok barang berhasil dihapus.");
    }

    private static void hapusStokBarangTidakHabisPakai() {
        System.out.print("Masukkan code stok barang yang akan dihapus: ");
        int codeBarang = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        StokBarangTidakHabisPakai stokBarang = findStokBarangTidakHabisPakaiByCode(codeBarang);
        if (stokBarang == null) {
            System.out.println("Stok barang tidak ditemukan.");
            return;
        }

        stokBarangTidakHabisPakaiList.remove(stokBarang);
        System.out.println("Stok barang berhasil dihapus.");
    }

    private static StokBarangHabisPakai findStokBarangHabisPakaiByCode(int codeBarang) {
        for (StokBarangHabisPakai stokBarang : stokBarangHabisPakaiList) {
            if (stokBarang.getCodeBarang() == codeBarang) {
                return stokBarang;
            }
        }
        return null;
    }

    private static StokBarangTidakHabisPakai findStokBarangTidakHabisPakaiByCode(int codeBarang) {
        for (StokBarangTidakHabisPakai stokBarang : stokBarangTidakHabisPakaiList) {
            if (stokBarang.getCodeBarang() == codeBarang) {
                return stokBarang;
            }
        }
        return null;
    }
}

