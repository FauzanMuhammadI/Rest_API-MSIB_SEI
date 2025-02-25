package test_magang_sei_backend.msib_sei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Proyek {
    private int id;
    private String namaProyek;
    private String client;
    private String tanggalMulai;
    private String tanggalSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private String createdAt;

    private List<Lokasi> lokasi;
}
