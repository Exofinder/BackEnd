package NASA.ExoFinder_BackEnd.service;

import NASA.ExoFinder_BackEnd.domain.ExoSystem;
import NASA.ExoFinder_BackEnd.repository.ExoSystemRepository;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CSVService {

    private final ExoSystemRepository exoSystemRepository;

    @Transactional
    public void saveCSVData(MultipartFile file) throws Exception {

        exoSystemRepository.deleteAll();

        try(CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                ExoSystem exoSystem = new ExoSystem();
                exoSystem.setPlanetName(line[0]);
                exoSystem.setHostName(line[1]);
                exoSystem.setPlanetDensity(line[2]);

                exoSystemRepository.save(exoSystem);

            }
        }
    }
}
