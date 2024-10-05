package NASA.ExoFinder_BackEnd.apiPayload.code.status;

import NASA.ExoFinder_BackEnd.apiPayload.code.BaseCode;
import NASA.ExoFinder_BackEnd.apiPayload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    OK(HttpStatus.OK,"COMMON200", "Successfully performed the request."),
    CREATED(HttpStatus.CREATED,"COMMON201", "Successfully created."),
    NO_CONTENT(HttpStatus.NO_CONTENT,"COMMON204", "Successfully deleted.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}

