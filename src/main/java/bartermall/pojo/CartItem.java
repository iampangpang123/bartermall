package bartermall.pojo;

public class CartItem {
	String pid;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	String image;
	String pname;
	double price;
	int count;
	double total;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double d) {
		this.total = d;
	}

	@Override
	public String toString() {
		return "Cart [image=" + image + ", pname=" + pname + ", price=" + price + ", count=" + count + ", total="
				+ total + "]";
	}

}
