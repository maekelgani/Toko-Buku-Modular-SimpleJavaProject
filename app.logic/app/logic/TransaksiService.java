package app.logic;

import app.data.Buku;

public class TransaksiService {

    public static double hitungTotal(Buku buku, int jumlah) {
        return buku.getHarga() * jumlah;
    }

    public static boolean cekStok(Buku buku, int jumlah) {
        return jumlah <= buku.getStok();
    }

    public static double hitungDiskon(double total) {
        if (total >= 200000) {
            return total * 0.10;
        }
        return 0;
    }
}
