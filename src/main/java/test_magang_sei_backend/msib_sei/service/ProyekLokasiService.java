package test_magang_sei_backend.msib_sei.service;

import test_magang_sei_backend.msib_sei.entity.LokasiEntity;
import test_magang_sei_backend.msib_sei.entity.ProyekEntity;
import test_magang_sei_backend.msib_sei.entity.ProyekLokasiEntity;
import test_magang_sei_backend.msib_sei.pojo.Lokasi;
import test_magang_sei_backend.msib_sei.repository.LokasiRepo;
import test_magang_sei_backend.msib_sei.repository.ProyekLokasiRepo;
import test_magang_sei_backend.msib_sei.repository.ProyekRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProyekLokasiService {

    private final ProyekLokasiRepo proyekLokasiRepository;
    private final LokasiRepo lokasiRepository;
    private final ProyekRepo proyekRepository;

    public ProyekLokasiService(ProyekLokasiRepo proyekLokasiRepository, LokasiRepo lokasiRepository, ProyekRepo proyekRepository) {
        this.proyekLokasiRepository = proyekLokasiRepository;
        this.lokasiRepository = lokasiRepository;
        this.proyekRepository = proyekRepository;
    }

    @Transactional
    public void setProyekLokasi(int proyekId, List<Lokasi> lokasi) {

        proyekLokasiRepository.deleteAllByProyekId(proyekId);
        ProyekLokasiEntity proyekLokasiEntity = new ProyekLokasiEntity();
        ProyekEntity proyekEntity = proyekRepository.findById(proyekId).orElse(null);
        if (proyekEntity == null) {
            throw new IllegalArgumentException("Proyek not found");
        }
        proyekLokasiEntity.setProyekId(proyekId);
        for (Lokasi l : lokasi) {
            LokasiEntity lokasiEntity = lokasiRepository.findById(l.getId()).orElse(null);
            if (lokasiEntity == null) {
                throw new IllegalArgumentException("Lokasi not found");
            }
            proyekLokasiEntity.setLokasiId(l.getId());
            proyekLokasiRepository.save(proyekLokasiEntity);
        }
    }
}

