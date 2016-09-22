package cn.zjc.exception;

/**
 * @author zhangjinci
 * @version 2016/9/22 15:53
 * @function
 */
public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}
