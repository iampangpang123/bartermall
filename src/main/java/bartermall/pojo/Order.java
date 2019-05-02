package bartermall.pojo;


public class Order {
	private int orderId;
	private String product;
	private String creatDate;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	public Order(int orderId, String product, String creatDate) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.creatDate = creatDate;
	}
	public Order() {
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", product=" + product + ", creatDate=" + creatDate + "]";
	}
	
}
