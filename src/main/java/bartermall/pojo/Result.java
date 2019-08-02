package bartermall.pojo;

public class Result {
	String msg;
	boolean flag;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Result(boolean flag,String msg) {
		super();
		this.msg = msg;
		this.flag = flag;
	}
	public Result() {
		super();
	}
	

}
