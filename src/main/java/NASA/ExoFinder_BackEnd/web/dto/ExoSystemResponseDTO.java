package NASA.ExoFinder_BackEnd.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ExoSystemResponseDTO {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HabitablePercentDTO {
        private String plName;
        private String plOrbsmax;
        private String stSpectype;
        private String stBrightness;
        private String innerBoundHabitableZone;
        private String outerBoundHabitableZone;
        private String habitablePercent;
    }
}
