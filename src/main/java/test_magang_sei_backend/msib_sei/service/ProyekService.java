package test_magang_sei_backend.msib_sei.service;

import test_magang_sei_backend.msib_sei.entity.ProyekEntity;
import test_magang_sei_backend.msib_sei.pojo.Lokasi;
import test_magang_sei_backend.msib_sei.pojo.Proyek;
import test_magang_sei_backend.msib_sei.repository.ProyekLokasiRepo;
import test_magang_sei_backend.msib_sei.repository.ProyekRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProyekService extends AbstractService {
    private final LokasiService lokasiService;

    private final ProyekRepo proyekRepository;

    private final ProyekLokasiRepo proyekLokasiRepository;

    // note: hindari menggunakan @Autowired
    public ProyekService(LokasiService lokasiService, ProyekRepo proyekRepository, ProyekLokasiRepo proyekLokasiRepository) {
        this.lokasiService = lokasiService;
        this.proyekRepository = proyekRepository;
        this.proyekLokasiRepository = proyekLokasiRepository;
    }

    public long countProyek() {
        return proyekRepository.count();
    }

    private Proyek convertProyek(ProyekEntity proyekEntity) {
        Proyek proyek = new Proyek();
        proyek.setId(proyekEntity.getId());
        proyek.setNamaProyek(proyekEntity.getNamaProyek());
        proyek.setCreatedAt(formatDateTime(proyekEntity.getCreatedAt()));
        proyek.setPimpinanProyek(proyekEntity.getPimpinanProyek());
        proyek.setTanggalMulai(formatDate(proyekEntity.getTanggalMulai()));
        proyek.setTanggalSelesai(formatDate(proyekEntity.getTanggalSelesai()));
        proyek.setKeterangan(proyekEntity.getKeterangan());
        proyek.setClient(proyekEntity.getClient());
        List<Lokasi> lokasiList = lokasiService.getLokasiByProyekId(proyekEntity.getId());
        proyek.setLokasi(lokasiList);
        return proyek;
    }

    public List<Proyek> getAllProyek() {
        Iterable<ProyekEntity> proyekIterable = proyekRepository.findAll();
        List<Proyek> proyekList = new ArrayList<>();
        for (ProyekEntity proyekEntity : proyekIterable) {
            Proyek proyek = convertProyek(proyekEntity);
            proyekList.add(proyek);
        }
        return proyekList;
    }

    public Proyek addProyek(Proyek proyek) {
        ProyekEntity proyekEntity = new ProyekEntity();
        proyekEntity.setNamaProyek(proyek.getNamaProyek());
        proyekEntity.setPimpinanProyek(proyek.getPimpinanProyek());
        proyekEntity.setTanggalMulai(parseDate(proyek.getTanggalMulai()));
        proyekEntity.setTanggalSelesai(parseDate(proyek.getTanggalSelesai()));
        proyekEntity.setKeterangan(proyek.getKeterangan());
        proyekEntity.setClient(proyek.getClient());
        proyekEntity = proyekRepository.save(proyekEntity);
        proyek.setId(proyekEntity.getId());
        return proyek;
    }

    public void updateProyek(Proyek proyek) {
        ProyekEntity proyekEntity = proyekRepository.findById(proyek.getId()).orElse(null);
        if (proyekEntity == null) {
            return;
        }
        proyekEntity.setNamaProyek(proyek.getNamaProyek());
        proyekEntity.setPimpinanProyek(proyek.getPimpinanProyek());
        proyekEntity.setTanggalMulai(parseDate(proyek.getTanggalMulai()));
        proyekEntity.setTanggalSelesai(parseDate(proyek.getTanggalSelesai()));
        proyekEntity.setKeterangan(proyek.getKeterangan());
        proyekEntity.setClient(proyek.getClient());
        proyekRepository.save(proyekEntity);
    }

    @Transactional
    public void deleteProyek(int proyekId) {
        proyekLokasiRepository.deleteAllByProyekId(proyekId);
        proyekRepository.deleteById(proyekId);
    }
}

