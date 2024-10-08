package NASA.ExoFinder_BackEnd.apiPayload.code.status;

import NASA.ExoFinder_BackEnd.apiPayload.code.BaseErrorCode;
import NASA.ExoFinder_BackEnd.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "Server error, contact administrator."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","Wrong request."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","Authentication is required."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "prohibited request.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
