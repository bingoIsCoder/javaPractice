package cn.example.query;

import java.util.List;

public class PageList<T> {
	//当前页
	private Integer currentPage;
	//每页多少条数据
	private Integer pageSize;
	//一共多少条数据
	private Integer totalCount;
	//一共多少页
	private Integer totalPages;
	//上一页
	private Integer prePage;
	//下一页
	private Integer nextPage;
	//当前页所有数据
	private List<T> data;
	
	public PageList(Integer currentPage, Integer pageSize, Integer totalCount) {
		//这三个数据由外部传入
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		//先取模，为0：总条数/每页条数；不为0：总条数/每页条数+1
		this.totalPages = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		
		this.prePage = currentPage > 1 ? currentPage - 1 : currentPage;
		
		this.nextPage = currentPage < totalPages ? currentPage + 1: currentPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getnextPage() {
		return nextPage;
	}

	public void setnextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PageList [currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", totalCount=" + totalCount + ", totalPages="
				+ totalPages + ", prePage=" + prePage + ", nextPage="
				+ nextPage + ", data=" + data + "]";
	}
	
}
