package app.ui;

import app.data.Buku;
import app.data.Database;
import app.logic.TransaksiService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Buku> daftarBuku = Database.getDaftarBuku();

        System.out.println("===== TOKO BUKU =====");
        System.out.print("Cari Judul Buku : ");
        String keyword = input.nextLine();

        boolean ditemukan = false;

        for (Buku buku : daftarBuku) {
            if (buku.getJudul().toLowerCase().contains(keyword.toLowerCase())) {

                ditemukan = true;

                System.out.println("\n===== Buku Ditemukan =====");
                System.out.println("Judul : " + buku.getJudul());
                System.out.println("Harga : Rp" + buku.getHarga());
                System.out.println("Stok  : " + buku.getStok());

                System.out.print("Jumlah Beli : ");
                int jumlah = input.nextInt();

                if (!TransaksiService.cekStok(buku, jumlah)) {
                    System.out.println("Stok tidak cukup");
                    return;
                }

                double total = TransaksiService.hitungTotal(buku, jumlah);
                double diskon = TransaksiService.hitungDiskon(total);
                double bayar = total - diskon;

                buku.setStok(buku.getStok() - jumlah);

                System.out.println("\n===== INVOICE =====");
                System.out.println("Judul Buku : " + buku.getJudul());
                System.out.println("Jumlah     : " + jumlah);
                System.out.println("Subtotal   : Rp" + total);
                System.out.println("Diskon     : Rp" + diskon);
                System.out.println("Total Bayar: Rp" + bayar);
                System.out.println("===================");

                break;
            }
        }

        if (!ditemukan) {
            System.out.println("\n[PERINGATAN] Buku tidak ditemukan. Silahkan cari dengan kata kunci lain.");
        }
    }
}
