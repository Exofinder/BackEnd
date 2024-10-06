package NASA.ExoFinder_BackEnd.service;

import NASA.ExoFinder_BackEnd.domain.ExoSystem;
import NASA.ExoFinder_BackEnd.repository.ExoSystemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExoSystemQueryServiceImpl implements ExoSystemQueryService {

    private final ExoSystemRepository exoSystemRepository;

    @Override
    public List<ExoSystem> getPlanetInfoList(String hostName) {
        List<ExoSystem> planetInfoList = exoSystemRepository.findByHostName(hostName);

        return planetInfoList;
    }
}
