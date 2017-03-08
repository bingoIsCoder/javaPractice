package cn.example.shopping.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuyCart {
	List<CartItem> items = new ArrayList<CartItem>();

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	public void addItem(CartItem newItem) {
		for (CartItem item : items) {
			if (item.getId().equals(newItem.getId())) {
				item.setNum(item.getNum() + newItem.getNum());
				return;
			}
		}
		items.add(newItem);
	}
	
	public void deleteItem(String id) {
		Iterator<CartItem> it = items.iterator();
		while (it.hasNext()) {
			CartItem item = it.next();
			if (item.getId().equals(id)) {
				it.remove();
				return;
			}
		}
	}
	
	public Double getTotalPrice() {
		Double total = 0D;
		for (CartItem item : items) {
			total += item.getTotalPrice();
		}
		return Double.parseDouble(new DecimalFormat("0.00").format(total));
	}
}
