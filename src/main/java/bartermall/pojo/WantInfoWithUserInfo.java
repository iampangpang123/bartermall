package bartermall.pojo;

public class WantInfoWithUserInfo extends WantInfo {
	
	private String userName;
	private String tel;
	private String qq;
	private String photo;
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public WantInfoWithUserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WantInfoWithUserInfo(int wantId, String userName, String title, String desc, String wantPrice,
			String wantDealArea, String creatTime) {
		super(wantId, userName, title, desc, wantPrice, wantDealArea, creatTime);
		// TODO Auto-generated constructor stub
	}
	public WantInfoWithUserInfo(int wantId, String userName, String title, String desc, String wantPrice,
			String wantDealArea, String creatTime, String userName2, String tel, String qq, String photo) {
		super(wantId, userName, title, desc, wantPrice, wantDealArea, creatTime);
		userName = userName2;
		this.tel = tel;
		this.qq = qq;
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "WantInfoWithUserInfo [userName=" + userName + ", tel=" + tel + ", qq=" + qq + ", photo=" + photo
				+ ", getuserName()=" + getuserName() + ", getTel()=" + getTel() + ", getQq()=" + getQq() + ", getPhoto()="
				+ getPhoto() + ", getWantId()=" + getWantId() + ", getTitle()=" + getTitle() + ", getDesc()="
				+ getDesc() + ", getWantPrice()=" + getWantPrice() + ", getWantDealArea()=" + getWantDealArea()
				+ ", getCreatTime()=" + getCreatTime() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]\n";
	}
	
	
	
}
