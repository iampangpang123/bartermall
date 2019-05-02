package bartermall.pojo;

public class Category {
	private Integer cid2;
	private String cname2;
	private Integer cid1;
	private String cname1;
	public Integer getCid2() {
		return cid2;
	}
	public void setCid2(Integer cid2) {
		this.cid2 = cid2;
	}
	public String getCname2() {
		return cname2;
	}
	public void setCname2(String cname2) {
		this.cname2 = cname2;
	}
	public Integer getCid1() {
		return cid1;
	}
	public void setCid1(Integer cid1) {
		this.cid1 = cid1;
	}
	public String getCname1() {
		return cname1;
	}
	public void setCname1(String cname1) {
		this.cname1 = cname1;
	}
	public Category(Integer cid2, String cname2, Integer cid1, String cname1) {
		super();
		this.cid2 = cid2;
		this.cname2 = cname2;
		this.cid1 = cid1;
		this.cname1 = cname1;
	}
	public Category() {

	}
	@Override
	public String toString() {
		return "Category [cid2=" + cid2 + ", cname2=" + cname2 + ", cid1=" + cid1 + ", cname1=" + cname1 + "]";
	}
	
}
