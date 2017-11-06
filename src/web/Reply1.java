package web;

public class Reply1 {

	public static final Reply1 DEFAULT_REPLY = new Reply1();
	
	public static final String OK_STR = "ok";
	public static final String FAIL_STR = "fail";
	public static final String FAIL_STR_COMM = "fail (communication error)";
	public static final int FAIL_ID = -1;
	public static final int OK_ID = 0;
	
	private int id = OK_ID;
	private String msg = OK_STR;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
