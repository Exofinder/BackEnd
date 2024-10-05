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
        private String planet;
        private String habitablePercent;
    }
}
