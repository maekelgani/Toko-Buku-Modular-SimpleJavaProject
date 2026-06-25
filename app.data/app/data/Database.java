package app.data;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Buku> getDaftarBuku() {
        List<Buku> buku = new ArrayList<>();
        buku.add(new Buku("Java Programming", 150000, 10));
        buku.add(new Buku("Basis Data", 120000, 5));
        buku.add(new Buku("Algoritma", 100000, 8));
        return buku;
    }
}
