package test_magang_sei_backend.msib_sei.repository;

import test_magang_sei_backend.msib_sei.entity.ProyekLokasiEntity;
import test_magang_sei_backend.msib_sei.identifier.ProyekLokasiId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProyekLokasiRepo extends CrudRepository<ProyekLokasiEntity, ProyekLokasiId> {
    void deleteAllByLokasiId(int id);
    void deleteAllByProyekId(int id);
    List<ProyekLokasiEntity> findAllByProyekId(int proyekId);
}
