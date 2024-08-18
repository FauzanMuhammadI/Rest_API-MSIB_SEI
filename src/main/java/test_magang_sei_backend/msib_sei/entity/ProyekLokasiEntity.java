package test_magang_sei_backend.msib_sei.entity;

import test_magang_sei_backend.msib_sei.identifier.ProyekLokasiId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proyek_lokasi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ProyekLokasiId.class)
public class ProyekLokasiEntity {
    @Id
    @Column(name = "proyek_id")
    private int proyekId;

    @Id
    @Column(name = "lokasi_id")
    private int lokasiId;
}
