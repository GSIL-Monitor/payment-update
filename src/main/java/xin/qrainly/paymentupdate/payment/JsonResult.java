package xin.qrainly.paymentupdate.payment;

/**
 *
 * @author liuwen
 * @date 2018/5/7
 */
public class JsonResult<T> {

    private static final String OK = "ok";
    private static final String ERROR = "error";
    private static final String SUCCESS_MESSAGE = "SUCCESS";

    /**
     * 状态
     */
    private String status;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public JsonResult(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static JsonResult<?> okJsonResult(){
        return okJsonResultWithMsg("");
    }

    public static <T> JsonResult<T> okJsonResultWithData(T data){
        JsonResult<T> jsonResult = new JsonResult<>();
        jsonResult.setData(data);
        return jsonResult;
    }

    public static JsonResult<?> okJsonResultWithMsg(String message){
        JsonResult<?> jsonResult = new JsonResult<>();
        jsonResult.setMessage(message);
        return jsonResult;
    }

    public static JsonResult<?> failJsonResult(String message) {
        JsonResult<?> jsonResult = new JsonResult<>();
        jsonResult.setStatus(ERROR);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    public JsonResult(){
        this.setStatus(OK);
        this.setMessage(SUCCESS_MESSAGE);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
