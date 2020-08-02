package cn.edu.hebut.ego.common.exception;

import cn.edu.hebut.ego.common.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author tianziyi
 */
@Data
@NoArgsConstructor
public class ErrorTokenException extends RuntimeException {

    protected final int errCode = 401;
    protected String errMessage;
    protected Object data;

    public ErrorTokenException(String errMessage, Throwable cause) {
        super(errMessage, cause);
        this.errMessage = errMessage;
    }

    public ErrorTokenException(ErrorCodeEnum errorEnum, Throwable cause) {
        this(errorEnum.getMsg(), cause);
    }

    public ErrorTokenException(ErrorCodeEnum errorEnum) {
        this(errorEnum.getMsg(), null);
    }

    public ErrorTokenException(String errMessage) {
        this(errMessage, null);
    }

    public ErrorTokenException(String errMessage, Object data) {
        this.errMessage = errMessage;
        this.data = data;
    }

}
