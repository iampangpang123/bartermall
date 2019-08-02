package bartermall.pojo;

import java.math.BigDecimal;
import java.util.Collection;

import java.util.LinkedHashMap;
import java.util.Map;



public class Cart {
	/*
	 * 购物车
	 */
	
	private Map<String,CartItem> map=new LinkedHashMap<String, CartItem>();
	
	
	public double getTotal(){
		/*
		 * 计算购物车里面所有条目价格:总价=条目1价格（书本类型*数量）+条目2+条目3+。。。。。+条目n；
		 */
		
		/*
		 * 解决2进制运算误差问题。如2.0-1.1=0.89999999999999999999999999999999999999999999999
		 */
		BigDecimal total=new BigDecimal("0");
		for(CartItem cartItem:map.values()){
			BigDecimal subtotal=new BigDecimal(""+cartItem.getTotal());
			total=total.add(subtotal);
		}
		return total.doubleValue();
		
	}
	
	
	public void add(CartItem cartItem){
		/*
		 * 添加条目
		 */
		if(map.containsKey(cartItem.getPid())){//如果条目存在
			CartItem _cartItem=map.get(cartItem.getPid());//返回原条目
			//新条目=原条目书籍的数量+传递过来条目书籍的数量
			_cartItem.setCount(cartItem.getCount()+_cartItem.getCount());
			_cartItem.setTotal(cartItem.getTotal()+cartItem.getPrice());
			map.put(_cartItem.getPid(),_cartItem);
			
			
			
		}else {
			map.put(cartItem.getPid(),cartItem);
		}
		
		
		
	}
	public void delete(String bid){
		/*
		 * 删除指定条目
		 */
		map.remove(bid);
		
	}
	public void clear(){
		/*
		 * 清空购物车
		 */
		map.clear();
	}
	public Collection<CartItem> getCartItems(){
		
		return map.values();
	}

}
