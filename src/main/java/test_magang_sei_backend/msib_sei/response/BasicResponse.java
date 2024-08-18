package test_magang_sei_backend.msib_sei.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@SuperBuilder
public class BasicResponse {
    protected String message;
}
