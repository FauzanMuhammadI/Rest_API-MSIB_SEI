package test_magang_sei_backend.msib_sei.response;

import test_magang_sei_backend.msib_sei.pojo.Proyek;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class ProyekListResponse extends BasicResponse {
    private final List<Proyek> data;
}
