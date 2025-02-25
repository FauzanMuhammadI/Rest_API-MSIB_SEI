package test_magang_sei_backend.msib_sei.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DashboardResponse extends BasicResponse {
    private final long totalLokasi;
    private final long totalProyek;

    public DashboardResponse(String message, long totalLokasi, long totalProyek) {
        super(message);
        this.totalLokasi = totalLokasi;
        this.totalProyek = totalProyek;
    }
}
