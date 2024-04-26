package stokBarang;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

abstract class Barang {
    private static int counter = 1;
    protected final int nomor;
    protected final Integer kodeBarang;
    protected final String namaBarang;
    protected final int stokAwal;
    protected int stokAkhir;
    protected int barangMasuk;
    protected int barangKeluar;
    protected String keterangan;

    protected static final Set<Integer> kodeBarangSet = new HashSet<>();

    public Barang(final Integer kodeBarang, final String namaBarang, final int stokAwal, final int barangMasuk, final int barangKeluar, final String keterangan) {
        this.nomor = counter++;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.stokAwal = stokAwal;
        this.barangMasuk = barangMasuk;
        this.barangKeluar = barangKeluar;
        this.keterangan = keterangan;
        this.stokAkhir = stokAwal + barangMasuk - barangKeluar;

        kodeBarangSet.add(kodeBarang);
    }

    public static Set<Integer> getKodeBarangSet() {
        return kodeBarangSet;
    }

    public int getNomor() {
        return nomor;
    }

    public int getkodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getStokAwal() {
        return stokAwal;
    }

    public int getStokAkhir() {
        return stokAkhir;
    }

    public int getBarangMasuk() {
        return barangMasuk;
    }

    public int getBarangKeluar() {
        return barangKeluar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public abstract String getJenisBarang();

    public void setBarangMasuk(int barangMasuk) {
        this.barangMasuk = barangMasuk;
        this.stokAkhir = this.stokAwal + this.barangMasuk - this.barangKeluar;
    }

    public void setBarangKeluar(int barangKeluar) {
        this.barangKeluar = barangKeluar;
        this.stokAkhir = this.stokAwal + this.barangMasuk - this.barangKeluar;
    }

    public void setStokAkhir(int stokAkhir) {
        this.stokAkhir = stokAkhir;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}

final class BarangHabisPakai extends Barang {
    private static final ArrayList<BarangHabisPakai> BarangHabisPakaiList = new ArrayList<>();

    public BarangHabisPakai(final int kodeBarang, final String namaBarang, final int stokAwal, final int barangMasuk, final int barangKeluar, final String keterangan) {
        super(kodeBarang, namaBarang, stokAwal, barangMasuk, barangKeluar, keterangan);
        BarangHabisPakaiList.add(this);
    }

    public static ArrayList<BarangHabisPakai> getBarangHabisPakaiList() {
        return BarangHabisPakaiList;
    }

    @Override
    public String getJenisBarang() {
        return "Barang Habis Pakai";
    }
}

final class BarangTidakHabisPakai extends Barang {
    private static final ArrayList<BarangTidakHabisPakai> BarangTidakHabisPakaiList = new ArrayList<>();

    public BarangTidakHabisPakai(final int kodeBarang, final String namaBarang, final int stokAwal, final int barangMasuk, final int barangKeluar, final String keterangan) {
        super(kodeBarang, namaBarang, stokAwal, barangMasuk, barangKeluar, keterangan);
        BarangTidakHabisPakaiList.add(this);
    }

    public static ArrayList<BarangTidakHabisPakai> getBarangTidakHabisPakaiList() {
        return BarangTidakHabisPakaiList;
    }

    @Override
    public String getJenisBarang() {
        return "Barang Tidak Habis Pakai";
    }
}

public final class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("========================================");
            System.out.println("----------------------------------------");
            System.out.println("Menu:");
            System.out.println("----------------------------------------");
            System.out.println("\n1. Kelola Stok Barang Habis Pakai");
            System.out.println("\n2. Kelola Stok Barang Tidak Habis Pakai");
            System.out.println("\n3. Lihat Semua Stok Barang");
            System.out.println("\n4. Keluar");
            System.out.println("----------------------------------------");
            System.out.println("========================================");
            System.out.print("Pilih menu: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        menuBarangHabisPakai();
                        break;
                    case 2:
                        menuBarangTidakHabisPakai();
                        break;
                    case 3:
                        lihatSemuaBarang();
                        break;
                    case 4:
                        isRunning = false;
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine();
            }
        }
    }

    private static void menuBarangHabisPakai() {
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

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        tambahBarangHabisPakai();
                        break;
                    case 2:
                        lihatSemuaBarangHabisPakai();
                        break;
                    case 3:
                        ubahBarangHabisPakai();
                        break;
                    case 4:
                        hapusBarangHabisPakai();
                        break;
                    case 5:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine();
            }
        }
    }

    private static void menuBarangTidakHabisPakai() {
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

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        tambahBarangTidakHabisPakai();
                        break;
                    case 2:
                        lihatSemuaBarangTidakHabisPakai();
                        break;
                    case 3:
                        ubahBarangTidakHabisPakai();
                        break;
                    case 4:
                        hapusBarangTidakHabisPakai();
                        break;
                    case 5:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine();
            }
        }
    }

    private static void tambahBarangHabisPakai() {
        System.out.print("kode Barang: ");
        if (scanner.hasNextInt()) {
            int kodeBarang = scanner.nextInt();
            scanner.nextLine();

            if (Barang.getKodeBarangSet().contains(kodeBarang)) {
                System.out.println("Kode Barang sudah ada. Mohon masukkan kode yang unik.");
                return;
            }
            System.out.print("Nama Barang: ");
            String namaBarang = scanner.nextLine();
            System.out.print("Stok Awal: ");
            if (scanner.hasNextInt()) {
                int stokAwal = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Keterangan: ");
                String keterangan = scanner.nextLine();

                new BarangHabisPakai(kodeBarang, namaBarang, stokAwal, 0, 0, keterangan);
                System.out.println("Stok barang habis pakai berhasil ditambahkan.");
            } else {
                System.out.println("Input Stok Awal tidak valid. Harap masukkan angka.");
            }
        } else {
            System.out.println("Input kode Barang tidak valid. Harap masukkan angka.");
        }
    }

    private static void tambahBarangTidakHabisPakai() {
        System.out.print("kode Barang: ");
        if (scanner.hasNextInt()) {
            int kodeBarang = scanner.nextInt();
            scanner.nextLine();

            if (Barang.getKodeBarangSet().contains(kodeBarang)) {
                System.out.println("Kode Barang sudah ada. Mohon masukkan kode yang unik.");
                return;
            }
            System.out.print("Nama Barang: ");
            String namaBarang = scanner.nextLine();
            System.out.print("Stok Awal: ");
            if (scanner.hasNextInt()) {
                int stokAwal = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Keterangan: ");
                String keterangan = scanner.nextLine();

                new BarangTidakHabisPakai(kodeBarang, namaBarang, stokAwal, 0, 0, keterangan);
                System.out.println("Stok barang tidak habis pakai berhasil ditambahkan.");
            } else {
                System.out.println("Input Stok Awal tidak valid. Harap masukkan angka.");
            }
        } else {
            System.out.println("Input kode Barang tidak valid. Harap masukkan angka.");
        }
    }

    private static void lihatSemuaBarangHabisPakai() {
        ArrayList<BarangHabisPakai> BarangHabisPakaiList = BarangHabisPakai.getBarangHabisPakaiList();
        if (BarangHabisPakaiList.isEmpty()) {
            System.out.println("Tidak ada stok barang habis pakai yang tersedia.");
            return;
        }
        System.out.println("===================================================================================================================");
        System.out.printf("| %-5s | %-10s | %-20s | %-10s | %-10s | %-10s | %-10s | %-15s |\n", "No", "kode", "Nama Barang", "Stok Awal", "Masuk", "Keluar", "Stok Akhir", "Keterangan");
        System.out.println("===================================================================================================================");
        for (BarangHabisPakai Barang : BarangHabisPakaiList) {
            System.out.printf("| %-5d | %-10d | %-20s | %-10d | %-10d | %-10d | %-10d | %-15s |\n", Barang.getNomor(), Barang.getkodeBarang(), Barang.getNamaBarang(), Barang.getStokAwal(), Barang.getBarangMasuk(), Barang.getBarangKeluar(), Barang.getStokAkhir(), Barang.getKeterangan());
        }
        System.out.println("===================================================================================================================");
    }

    private static void lihatSemuaBarangTidakHabisPakai() {
        ArrayList<BarangTidakHabisPakai> BarangTidakHabisPakaiList = BarangTidakHabisPakai.getBarangTidakHabisPakaiList();
        if (BarangTidakHabisPakaiList.isEmpty()) {
            System.out.println("Tidak ada stok barang tidak habis pakai yang tersedia.");
            return;
        }
        System.out.println("===================================================================================================================");
        System.out.printf("| %-5s | %-10s | %-20s | %-10s | %-10s | %-10s | %-10s | %-15s |\n", "No", "kode", "Nama Barang", "Stok Awal", "Masuk", "Keluar", "Stok Akhir", "Keterangan");
        System.out.println("===================================================================================================================");
        for (BarangTidakHabisPakai Barang : BarangTidakHabisPakaiList) {
            System.out.printf("| %-5d | %-10d | %-20s | %-10d | %-10d | %-10d | %-10d | %-15s |\n", Barang.getNomor(), Barang.getkodeBarang(), Barang.getNamaBarang(), Barang.getStokAwal(), Barang.getBarangMasuk(), Barang.getBarangKeluar(), Barang.getStokAkhir(), Barang.getKeterangan());
        }
        System.out.println("===================================================================================================================");
    }

    private static void ubahBarangHabisPakai() {
        System.out.print("Masukkan kode barang yang ingin diubah: ");
        if (scanner.hasNextInt()) {
            int kodeBarang = scanner.nextInt();
            scanner.nextLine();
            ArrayList<BarangHabisPakai> BarangHabisPakaiList = BarangHabisPakai.getBarangHabisPakaiList();
            boolean found = false;
            for (BarangHabisPakai Barang : BarangHabisPakaiList) {
                if (Barang.getkodeBarang() == kodeBarang) {
                    found = true;
                    System.out.println("Stok Barang Habis Pakai:");
                    System.out.println(Barang);
                    System.out.println("----------------------------------------");
                    System.out.print("Stok Masuk: ");
                    if (scanner.hasNextInt()) {
                        int barangMasuk = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Stok Keluar: ");
                        if (scanner.hasNextInt()) {
                            int barangKeluar = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Keterangan: ");
                            String keterangan = scanner.nextLine();

                            Barang.setBarangMasuk(barangMasuk);
                            Barang.setBarangKeluar(barangKeluar);
                            Barang.setStokAkhir(Barang.getStokAwal() + barangMasuk - barangKeluar);
                            Barang.setKeterangan(keterangan);
                            System.out.println("Stok barang berhasil diubah.");
                        } else {
                            System.out.println("Input Stok Keluar tidak valid. Harap masukkan angka.");
                        }
                    } else {
                        System.out.println("Input Stok Masuk tidak valid. Harap masukkan angka.");
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("kode barang tidak ditemukan.");
            }
        } else {
            System.out.println("Input kode barang tidak valid. Harap masukkan angka.");
        }
    }

    private static void ubahBarangTidakHabisPakai() {
        System.out.print("Masukkan kode barang yang ingin diubah: ");
        if (scanner.hasNextInt()) {
            int kodeBarang = scanner.nextInt();
            scanner.nextLine(); 
            ArrayList<BarangTidakHabisPakai> BarangTidakHabisPakaiList = BarangTidakHabisPakai.getBarangTidakHabisPakaiList();
            boolean found = false;
            for (BarangTidakHabisPakai Barang : BarangTidakHabisPakaiList) {
                if (Barang.getkodeBarang() == kodeBarang) {
                    found = true;
                    System.out.println("Stok Barang Tidak Habis Pakai:");
                    System.out.println(Barang);
                    System.out.println("----------------------------------------");
                    System.out.print("Stok Masuk: ");
                    if (scanner.hasNextInt()) {
                        int barangMasuk = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Stok Keluar: ");
                        if (scanner.hasNextInt()) {
                            int barangKeluar = scanner.nextInt();
                            scanner.nextLine(); 
                            System.out.print("Keterangan: ");
                            String keterangan = scanner.nextLine();

                            Barang.setBarangMasuk(barangMasuk);
                            Barang.setBarangKeluar(barangKeluar);
                            Barang.setStokAkhir(Barang.getStokAwal() + barangMasuk - barangKeluar);
                            Barang.setKeterangan(keterangan);
                            System.out.println("Stok barang berhasil diubah.");
                        } else {
                            System.out.println("Input Stok Keluar tidak valid. Harap masukkan angka.");
                        }
                    } else {
                        System.out.println("Input Stok Masuk tidak valid. Harap masukkan angka.");
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("kode barang tidak ditemukan.");
            }
        } else {
            System.out.println("Input kode barang tidak valid. Harap masukkan angka.");
        }
    }

    private static void hapusBarangHabisPakai() {
        System.out.print("Masukkan kode barang yang ingin dihapus: ");
        if (scanner.hasNextInt()) {
            int kodeBarang = scanner.nextInt();
            scanner.nextLine(); 
            ArrayList<BarangHabisPakai> BarangHabisPakaiList = BarangHabisPakai.getBarangHabisPakaiList();
            boolean found = false;
            for (BarangHabisPakai Barang : BarangHabisPakaiList) {
                if (Barang.getkodeBarang() == kodeBarang) {
                    found = true;
                    BarangHabisPakaiList.remove(Barang);
                    System.out.println("Stok barang berhasil dihapus.");
                    break;
                }
            }
            if (!found) {
                System.out.println("kode barang tidak ditemukan.");
            }
        } else {
            System.out.println("Input kode barang tidak valid. Harap masukkan angka.");
        }
    }

    private static void hapusBarangTidakHabisPakai() {        System.out.print("Masukkan kode barang yang ingin dihapus: ");
    if (scanner.hasNextInt()) {
        int kodeBarang = scanner.nextInt();
        scanner.nextLine(); 
        ArrayList<BarangTidakHabisPakai> BarangTidakHabisPakaiList = BarangTidakHabisPakai.getBarangTidakHabisPakaiList();
        boolean found = false;
        for (BarangTidakHabisPakai Barang : BarangTidakHabisPakaiList) {
            if (Barang.getkodeBarang() == kodeBarang) {
                found = true;
                BarangTidakHabisPakaiList.remove(Barang);
                System.out.println("Stok barang berhasil dihapus.");
                break;
            }
        }
        if (!found) {
            System.out.println("kode barang tidak ditemukan.");
        }
    } else {
        System.out.println("Input kode barang tidak valid. Harap masukkan angka.");
    }
}

private static void lihatSemuaBarang() {
    ArrayList<BarangHabisPakai> BarangHabisPakaiList = BarangHabisPakai.getBarangHabisPakaiList();
    ArrayList<BarangTidakHabisPakai> BarangTidakHabisPakaiList = BarangTidakHabisPakai.getBarangTidakHabisPakaiList();

    if (BarangHabisPakaiList.isEmpty() && BarangTidakHabisPakaiList.isEmpty()) {
        System.out.println("Tidak ada stok barang yang tersedia.");
        return;
    }

    ArrayList<Barang> semuaBarang = new ArrayList<>();
    semuaBarang.addAll(BarangHabisPakaiList);
    semuaBarang.addAll(BarangTidakHabisPakaiList);

    semuaBarang.sort(Comparator.comparingInt(Barang::getNomor));

    System.out.println("=========================================================================================================================================");
        System.out.printf("| %-5s | %-5s | %-20s | %-10s | %-10s | %-10s | %-10s | %-15s | %-10s |\n", "No", "kode", "Nama Barang", "Stok Awal", "Masuk", "Keluar", "Stok Akhir", "Keterangan", "Jenis Barang            ");
        System.out.println("=========================================================================================================================================");

        for (Barang Barang : semuaBarang) {
            String jenisBarang;
            if (Barang instanceof BarangHabisPakai) {
                jenisBarang = "Barang Habis Pakai";
            } else {
                jenisBarang = "Barang Tidak Habis Pakai";
            }
            System.out.printf("| %-5d | %-5d | %-20s | %-10d | %-10d | %-10d | %-10d | %-15s | %-10s |\n", Barang.getNomor(), Barang.getkodeBarang(), Barang.getNamaBarang(), Barang.getStokAwal(), Barang.getBarangMasuk(), Barang.getBarangKeluar(), Barang.getStokAkhir(), Barang.getKeterangan(), jenisBarang);
        }
        System.out.println("=========================================================================================================================================");
    }
}