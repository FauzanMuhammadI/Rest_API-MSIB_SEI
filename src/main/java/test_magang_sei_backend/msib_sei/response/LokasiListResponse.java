package test_magang_sei_backend.msib_sei.response;

import test_magang_sei_backend.msib_sei.pojo.Lokasi;
import jakarta.annotation.Nullable;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class LokasiListResponse extends BasicResponse {
    @Nullable
    private final List<Lokasi> data;
}
