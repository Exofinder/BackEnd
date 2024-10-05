package NASA.ExoFinder_BackEnd.service;

import NASA.ExoFinder_BackEnd.domain.ExoSystem;

import java.util.List;

public interface ExoSystemQueryService {

    List<ExoSystem> getPlanetInfoList(String hostName);
}
