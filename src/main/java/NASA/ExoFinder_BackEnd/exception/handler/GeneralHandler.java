package NASA.ExoFinder_BackEnd.exception.handler;

import NASA.ExoFinder_BackEnd.apiPayload.code.BaseErrorCode;
import NASA.ExoFinder_BackEnd.exception.GeneralException;

public class GeneralHandler extends GeneralException {

    public GeneralHandler(BaseErrorCode errorCode) { super(errorCode); }
}
