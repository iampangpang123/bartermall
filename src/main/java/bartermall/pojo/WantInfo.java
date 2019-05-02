package bartermall.pojo;

public class WantInfo {
	private String wantId;
	private String userId;
	private String title;
	private String wdesc;
	private String wantPrice;
	private String wantDealArea;
	private String creatTime;
	
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
		return wdesc;
	}
	public void setDesc(String desc) {
		this.wdesc = desc;
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
	
	public WantInfo(String wantId, String userId, String title, String desc, String wantPrice, String wantDealArea,
			String creatTime) {
		super();
		this.wantId = wantId;
		this.userId = userId;
		this.title = title;
		this.wdesc = desc;
		this.wantPrice = wantPrice;
		this.wantDealArea = wantDealArea;
		this.creatTime = creatTime;
	}
	public String getWantId() {
		return wantId;
	}
	public void setWantId(String wantId) {
		this.wantId = wantId;
	}
	public WantInfo() {
	}
	@Override
	public String toString() {
		return "WantInfo [wantId=" + wantId + ", userId=" + userId + ", title=" + title + ", desc=" + wdesc
				+ ", wantPrice=" + wantPrice + ", wantDealArea=" + wantDealArea + ", creatTime=" + creatTime + "]\n";
	}
	
}
