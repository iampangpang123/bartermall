package bartermall.pojo;

public class WantInfo {
	private int wantId;
	private String userId;
	private String title;
	private String desc;
	private String wantPrice;
	private String wantDealArea;
	private String creatTime;
	public int getWantId() {
		return wantId;
	}
	public void setWantId(int wantId) {
		this.wantId = wantId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getWantPrice() {
		return wantPrice;
	}
	public void setWantPrice(String wantPrice) {
		this.wantPrice = wantPrice;
	}
	public String getWantDealArea() {
		return wantDealArea;
	}
	public void setWantDealArea(String wantDealArea) {
		this.wantDealArea = wantDealArea;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public WantInfo(int wantId, String userId, String title, String desc, String wantPrice, String wantDealArea,
			String creatTime) {
		super();
		this.wantId = wantId;
		this.userId = userId;
		this.title = title;
		this.desc = desc;
		this.wantPrice = wantPrice;
		this.wantDealArea = wantDealArea;
		this.creatTime = creatTime;
	}
	public WantInfo() {
	}
	@Override
	public String toString() {
		return "WantInfo [wantId=" + wantId + ", userId=" + userId + ", title=" + title + ", desc=" + desc
				+ ", wantPrice=" + wantPrice + ", wantDealArea=" + wantDealArea + ", creatTime=" + creatTime + "]\n";
	}
	
}
