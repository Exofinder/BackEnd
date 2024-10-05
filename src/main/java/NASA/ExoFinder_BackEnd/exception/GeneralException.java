package NASA.ExoFinder_BackEnd.exception;

import NASA.ExoFinder_BackEnd.apiPayload.code.BaseErrorCode;
import NASA.ExoFinder_BackEnd.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() { return this.code.getReason(); }

    public ErrorReasonDTO getErrorReasonHttpStatus() { return this.code.getReasonHttpStatus(); }
}
