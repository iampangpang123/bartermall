package bartermall.exception;

/**
 * @Description:自定义全局异常类
 * @author: 唐涛
 * @date: 2019年5月11日 下午10:16:57
 * 
 */
public class GlobalException extends Exception {
	private String message;

	
	public GlobalException() {
		// TODO Auto-generated constructor stub
	}
	public GlobalException(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {

		return message;
	}
}
