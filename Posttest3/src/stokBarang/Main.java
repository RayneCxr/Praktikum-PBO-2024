package stokBarang;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class StokBarang {
    protected static int counter = 1; 
    protected int nomor;
    protected Integer codeBarang;
    protected String namaBarang;
    protected int stokAwal;
    protected int stokAkhir;
    protected int barangMasuk;
    protected int barangKeluar;
    protected String keterangan;

    protected static Set<Integer> kodeBarangSet = new HashSet<>();

    public StokBarang(Integer codeBarang, String namaBarang, int stokAwal, int barangMasuk, int barangKeluar, String keterangan) {
        this.nomor = counter++;
        this.codeBarang = codeBarang;
        this.namaBarang = namaBarang;
        this.stokAwal = stokAwal;
        this.barangMasuk = barangMasuk;
        this.barangKeluar = barangKeluar;
        this.keterangan = keterangan;
        this.stokAkhir = stokAwal + barangMasuk - barangKeluar;

        kodeBarangSet.add(codeBarang);
    }

    public static Set<Integer> getKodeBarangSet() {
        return kodeBarangSet;
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
        return "StokBarang{" +
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

class StokBarangHabisPakai extends StokBarang {
    private static ArrayList<StokBarangHabisPakai> stokBarangHabisPakaiList = new ArrayList<>();

    public StokBarangHabisPakai(int codeBarang, String namaBarang, int stokAwal, int barangMasuk, int barangKeluar, String keterangan) {
        super(codeBarang, namaBarang, stokAwal, barangMasuk, barangKeluar, keterangan);
        stokBarangHabisPakaiList.add(this);
    }

    public static ArrayList<StokBarangHabisPakai> getStokBarangHabisPakaiList() {
        return stokBarangHabisPakaiList;
    }
}

class StokBarangTidakHabisPakai extends StokBarang {
    private static ArrayList<StokBarangTidakHabisPakai> stokBarangTidakHabisPakaiList = new ArrayList<>();

    public StokBarangTidakHabisPakai(int codeBarang, String namaBarang, int stokAwal, int barangMasuk, int barangKeluar, String keterangan) {
        super(codeBarang, namaBarang, stokAwal, barangMasuk, barangKeluar, keterangan);
        stokBarangTidakHabisPakaiList.add(this);
    }

    public static ArrayList<StokBarangTidakHabisPakai> getStokBarangTidakHabisPakaiList() {
        return stokBarangTidakHabisPakaiList;
    }
}

public class Main {
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
                        menuStokBarangHabisPakai();
                        break;
                    case 2:
                        menuStokBarangTidakHabisPakai();
                        break;
                    case 3:
                        lihatSemuaStokBarang();
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
    
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
    
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
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine(); 
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

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); 

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
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine(); 
            }
        }
    }

    private static void tambahStokBarangHabisPakai() {
        System.out.print("Code Barang: ");
        if (scanner.hasNextInt()) {
            int codeBarang = scanner.nextInt();
            scanner.nextLine(); 
            
            if (StokBarang.getKodeBarangSet().contains(codeBarang)) {
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

                new StokBarangHabisPakai(codeBarang, namaBarang, stokAwal, 0, 0, keterangan);
                System.out.println("Stok barang habis pakai berhasil ditambahkan.");
            } else {
                System.out.println("Input Stok Awal tidak valid. Harap masukkan angka.");
            }
        } else {
            System.out.println("Input Code Barang tidak valid. Harap masukkan angka.");
        }
    }

    private static void tambahStokBarangTidakHabisPakai() {
        System.out.print("Code Barang: ");
        if (scanner.hasNextInt()) {
            int codeBarang = scanner.nextInt();
            scanner.nextLine(); 
            
            if (StokBarang.getKodeBarangSet().contains(codeBarang)) {
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

                new StokBarangTidakHabisPakai(codeBarang, namaBarang, stokAwal, 0, 0, keterangan);
                System.out.println("Stok barang tidak habis pakai berhasil ditambahkan.");
            } else {
                System.out.println("Input Stok Awal tidak valid. Harap masukkan angka.");
            }
        } else {
            System.out.println("Input Code Barang tidak valid. Harap masukkan angka.");
        }
    }

    private static void lihatSemuaStokBarangHabisPakai() {
        ArrayList<StokBarangHabisPakai> stokBarangHabisPakaiList = StokBarangHabisPakai.getStokBarangHabisPakaiList();
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

    private static void lihatSemuaStokBarangTidakHabisPakai() {        ArrayList<StokBarangTidakHabisPakai> stokBarangTidakHabisPakaiList = StokBarangTidakHabisPakai.getStokBarangTidakHabisPakaiList();
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
        System.out.print("Masukkan code barang yang ingin diubah: ");
        if (scanner.hasNextInt()) {
            int codeBarang = scanner.nextInt();
            scanner.nextLine(); 
            ArrayList<StokBarangHabisPakai> stokBarangHabisPakaiList = StokBarangHabisPakai.getStokBarangHabisPakaiList();
            boolean found = false;
            for (StokBarangHabisPakai stokBarang : stokBarangHabisPakaiList) {
                if (stokBarang.getCodeBarang() == codeBarang) {
                    found = true;
                    System.out.println("Stok Barang Habis Pakai:");
                    System.out.println(stokBarang);
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

                            stokBarang.setBarangMasuk(barangMasuk);
                            stokBarang.setBarangKeluar(barangKeluar);
                            stokBarang.setStokAkhir(stokBarang.getStokAwal() + barangMasuk - barangKeluar);
                            stokBarang.setKeterangan(keterangan);
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
                System.out.println("Code barang tidak ditemukan.");
            }
        } else {
            System.out.println("Input code barang tidak valid. Harap masukkan angka.");
        }
    }

    private static void ubahStokBarangTidakHabisPakai() {
        System.out.print("Masukkan code barang yang ingin diubah: ");
        if (scanner.hasNextInt()) {
            int codeBarang = scanner.nextInt();
            scanner.nextLine(); 
            ArrayList<StokBarangTidakHabisPakai> stokBarangTidakHabisPakaiList = StokBarangTidakHabisPakai.getStokBarangTidakHabisPakaiList();
            boolean found = false;
            for (StokBarangTidakHabisPakai stokBarang : stokBarangTidakHabisPakaiList) {
                if (stokBarang.getCodeBarang() == codeBarang) {
                    found = true;
                    System.out.println("Stok Barang Tidak Habis Pakai:");
                    System.out.println(stokBarang);
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

                            stokBarang.setBarangMasuk(barangMasuk);
                            stokBarang.setBarangKeluar(barangKeluar);
                            stokBarang.setStokAkhir(stokBarang.getStokAwal() + barangMasuk - barangKeluar);
                            stokBarang.setKeterangan(keterangan);
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
                System.out.println("Code barang tidak ditemukan.");
            }
        } else {
            System.out.println("Input code barang tidak valid. Harap masukkan angka.");
        }
    }

    private static void hapusStokBarangHabisPakai() {
        System.out.print("Masukkan code barang yang ingin dihapus: ");
        if (scanner.hasNextInt()) {
            int codeBarang = scanner.nextInt();
            scanner.nextLine(); 
            ArrayList<StokBarangHabisPakai> stokBarangHabisPakaiList = StokBarangHabisPakai.getStokBarangHabisPakaiList();
            boolean found = false;
            for (StokBarangHabisPakai stokBarang : stokBarangHabisPakaiList) {
                if (stokBarang.getCodeBarang() == codeBarang) {
                    found = true;
                    stokBarangHabisPakaiList.remove(stokBarang);
                    System.out.println("Stok barang berhasil dihapus.");
                    break;
                }
            }
            if (!found) {
                System.out.println("code barang tidak ditemukan.");
            }
        } else {
            System.out.println("Input code barang tidak valid. Harap masukkan angka.");
        }
    }

    private static void hapusStokBarangTidakHabisPakai() {        System.out.print("Masukkan code barang yang ingin dihapus: ");
    if (scanner.hasNextInt()) {
        int codeBarang = scanner.nextInt();
        scanner.nextLine(); 
        ArrayList<StokBarangTidakHabisPakai> stokBarangTidakHabisPakaiList = StokBarangTidakHabisPakai.getStokBarangTidakHabisPakaiList();
        boolean found = false;
        for (StokBarangTidakHabisPakai stokBarang : stokBarangTidakHabisPakaiList) {
            if (stokBarang.getCodeBarang() == codeBarang) {
                found = true;
                stokBarangTidakHabisPakaiList.remove(stokBarang);
                System.out.println("Stok barang berhasil dihapus.");
                break;
            }
        }
        if (!found) {
            System.out.println("Code barang tidak ditemukan.");
        }
    } else {
        System.out.println("Input code barang tidak valid. Harap masukkan angka.");
    }
}

private static void lihatSemuaStokBarang() {
    ArrayList<StokBarangHabisPakai> stokBarangHabisPakaiList = StokBarangHabisPakai.getStokBarangHabisPakaiList();
    ArrayList<StokBarangTidakHabisPakai> stokBarangTidakHabisPakaiList = StokBarangTidakHabisPakai.getStokBarangTidakHabisPakaiList();

    if (stokBarangHabisPakaiList.isEmpty() && stokBarangTidakHabisPakaiList.isEmpty()) {
        System.out.println("Tidak ada stok barang yang tersedia.");
        return;
    }

    ArrayList<StokBarang> semuaStokBarang = new ArrayList<>();
    semuaStokBarang.addAll(stokBarangHabisPakaiList);
    semuaStokBarang.addAll(stokBarangTidakHabisPakaiList);

    semuaStokBarang.sort(Comparator.comparingInt(StokBarang::getCodeBarang));

    System.out.println("=========================================================================================================================================");
        System.out.printf("| %-5s | %-5s | %-20s | %-10s | %-10s | %-10s | %-10s | %-15s | %-10s |\n", "No", "Code", "Nama Barang", "Stok Awal", "Masuk", "Keluar", "Stok Akhir", "Keterangan", "Jenis Barang            ");
        System.out.println("=========================================================================================================================================");

        for (StokBarang stokBarang : semuaStokBarang) {
            String jenisBarang;
            if (stokBarang instanceof StokBarangHabisPakai) {
                jenisBarang = "Barang Habis Pakai";
            } else {
                jenisBarang = "Barang Tidak Habis Pakai";
            }
            System.out.printf("| %-5d | %-5d | %-20s | %-10d | %-10d | %-10d | %-10d | %-15s | %-10s |\n", stokBarang.getNomor(), stokBarang.getCodeBarang(), stokBarang.getNamaBarang(), stokBarang.getStokAwal(), stokBarang.getBarangMasuk(), stokBarang.getBarangKeluar(), stokBarang.getStokAkhir(), stokBarang.getKeterangan(), jenisBarang);
        }
        System.out.println("=========================================================================================================================================");
    }
}