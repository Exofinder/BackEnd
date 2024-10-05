package NASA.ExoFinder_BackEnd.web.controller;

import NASA.ExoFinder_BackEnd.apiPayload.ApiResponse;
import NASA.ExoFinder_BackEnd.apiPayload.code.status.ErrorStatus;
import NASA.ExoFinder_BackEnd.domain.ExoSystem;
import NASA.ExoFinder_BackEnd.service.ExoSystemQueryService;
import NASA.ExoFinder_BackEnd.web.dto.ExoSystemResponseDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/systems")
public class ExoSystemRestController {

    private final ExoSystemQueryService exoSystemQueryService;
    private final WebClient webClient;

    @GetMapping("")
    public Mono<ApiResponse<?>> exoSystemInfo(@RequestParam String hostName) {
        List<ExoSystem> planetInfoList = exoSystemQueryService.getPlanetInfoList(hostName);

        List<String> planetNames = new ArrayList<>();
        List<String> planetDensities = new ArrayList<>();
        List<String> planetEccentricities = new ArrayList<>();
        List<String> stellarSpectralTypes = new ArrayList<>();
        List<String> stellarMasses = new ArrayList<>();
        List<String> stellarEffectiveTemperatures = new ArrayList<>();
        List<String> systemDistance = new ArrayList<>();
        List<String> systemVMagnitudes = new ArrayList<>();

        planetInfoList.forEach(planetInfo -> {
           planetNames.add(planetInfo.getPlanetName());
           planetDensities.add(planetInfo.getPlanetDensity());
           planetEccentricities.add(planetInfo.getPlanetEccentricity());
           stellarSpectralTypes.add(planetInfo.getStellarSpectralType());
           stellarMasses.add(planetInfo.getStellarMass());
           stellarEffectiveTemperatures.add(planetInfo.getStellarEffectiveTemperature());
           systemDistance.add(planetInfo.getSystemDistance());
           systemVMagnitudes.add(planetInfo.getSystemVMagnitude());
        });

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/systemInfo")
                        .queryParam("plNameList", planetNames)
                        .queryParam("plDensList", planetDensities)
                        .queryParam("plObeccenList", planetEccentricities)
                        .queryParam("stSpectypeList", stellarSpectralTypes)
                        .queryParam("stMassList", stellarMasses)
                        .queryParam("stTeffList", stellarEffectiveTemperatures)
                        .queryParam("syDistList", systemDistance)
                        .queryParam("syVmagList", systemVMagnitudes)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> {
                    try {
                        ObjectMapper mapper = new ObjectMapper();

                        List<ExoSystemResponseDTO.HabitablePercentDTO> infos = mapper.readValue(response, new TypeReference<List<ExoSystemResponseDTO.HabitablePercentDTO>>() {});

                        return ApiResponse.onSuccess(infos);
                    } catch (Exception e) {
                        return ApiResponse.onFailure(ErrorStatus._INTERNAL_SERVER_ERROR.getCode(),ErrorStatus._INTERNAL_SERVER_ERROR.getMessage(), "Error parsing JSON response: " + e.getMessage());
                    }
                });
    }
}
