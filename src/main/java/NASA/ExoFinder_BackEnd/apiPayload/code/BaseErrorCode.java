package NASA.ExoFinder_BackEnd.apiPayload.code;

public interface BaseErrorCode {

    public ErrorReasonDTO getReason();
    public ErrorReasonDTO getReasonHttpStatus();
}
