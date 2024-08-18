package test_magang_sei_backend.msib_sei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lokasi {
    private Integer id;
    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;
    private String createdAt;
}

