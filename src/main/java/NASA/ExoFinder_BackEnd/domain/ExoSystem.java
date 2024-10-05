package NASA.ExoFinder_BackEnd.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExoSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hostName; // hostname

    private String planetName; // pl_name

    private String planetDensity; // pl_dens

    private String planetEccentricity; // pl_orbeccen

    private String planetOrbitSemiMajorAxis; // pl_orbsmax

    private String stellarSpectralType; // st_spectype

    private String stellarMass; // st_mass

    private String stellarEffectiveTemperature; // st_teff

    private String systemDistance; // sy_dist

    private String systemVMagnitude; // sy_vmag
}
