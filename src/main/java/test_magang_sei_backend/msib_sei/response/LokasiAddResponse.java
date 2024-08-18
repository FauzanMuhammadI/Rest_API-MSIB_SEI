package test_magang_sei_backend.msib_sei.response;

import jakarta.annotation.Nullable;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class LokasiAddResponse extends BasicResponse {
    @Nullable
    private final Integer id;

    public LokasiAddResponse(String message, Integer id) {
        super(message);
        this.id = id;
    }
}
