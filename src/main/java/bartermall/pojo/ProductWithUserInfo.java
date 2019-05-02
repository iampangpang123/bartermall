package bartermall.pojo;

import java.sql.Date;

public class ProductWithUserInfo extends Product {
	private String name;

	private String area;
	
	private String college;
	
	private String tel;
	
	private String qq;
	
	private String photo;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
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

	public ProductWithUserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	public ProductWithUserInfo(String pid, String pname, double buyPrice, double salePrice, String pdesc, String pimage,
			String beloneto, int cid2, int readTimes, String state, String isHot, String creatTime) {
		super(pid, pname, buyPrice, salePrice, pdesc, pimage, beloneto, cid2, readTimes, state, isHot, creatTime);
		// TODO Auto-generated constructor stub
	}

	public ProductWithUserInfo(String name, String area, String college, String tel, String qq, String photo) {
		super();
		this.name = name;
		this.area = area;
		this.college = college;
		this.tel = tel;
		this.qq = qq;
		this.photo = photo;
	}

	@Override
	public String toString() {
		super.toString();
		return "ProductWithUserInfo [name=" + name + ", area=" + area + ", college=" + college + ", tel=" + tel
				+ ", qq=" + qq + ", photo=" + photo + "]\n";
	}

	
	
	
}
