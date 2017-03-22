package cn.example.query;

import java.math.BigDecimal;

public class ProductQuery {
	private String name;
	private BigDecimal maxPrice;
	private BigDecimal minPrice;
	private Integer pageSize = 10;
	private Integer currentPage = 1;
	
	public Integer getBeginIndex() {
		return (currentPage-1) * pageSize;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	public BigDecimal getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}
	
	public String getWhereSql() {
		String sql = "";
		
		if (name != null && !"".equals(name)) {
			sql += " and productName like '%" + name + "%'";
		}
		
		if (maxPrice != null) {
			sql += " and salePrice <=" + maxPrice;
		}
		
		if (minPrice != null) {
			sql += " and salePrice >=" + minPrice;
		}
		
		sql = sql.replaceFirst("and", "where");
		return sql;
		
		/* No.1
		String sql = "where 1=1";
		if (name != null && !"".equals(name)) {
			sql += " and productName like '%" + name + "%'";
		}
		
		if (maxPrice != null) {
			sql += " and salePrice <=" + maxPrice;
		}
		
		if (minPrice != null) {
			sql += " and salePrice >=" + minPrice;
		}
		return sql;
		*/
	}
}
