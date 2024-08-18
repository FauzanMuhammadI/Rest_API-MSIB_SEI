package test_magang_sei_backend.msib_sei.identifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyekLokasiId implements Serializable {
    private int proyekId;
    private int lokasiId;
}