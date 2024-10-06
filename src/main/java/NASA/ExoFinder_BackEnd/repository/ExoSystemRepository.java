package NASA.ExoFinder_BackEnd.repository;

import NASA.ExoFinder_BackEnd.domain.ExoSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExoSystemRepository extends JpaRepository<ExoSystem, Long> {

    List<ExoSystem> findByHostName(String hostName);
}
