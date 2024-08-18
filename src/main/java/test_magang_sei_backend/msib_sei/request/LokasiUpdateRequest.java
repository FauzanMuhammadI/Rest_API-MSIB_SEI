package test_magang_sei_backend.msib_sei.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LokasiUpdateRequest {
    private int id;
    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;
}
