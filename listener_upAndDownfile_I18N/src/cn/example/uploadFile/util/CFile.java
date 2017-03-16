package cn.example.uploadFile.util;

public class CFile {
	private String name;
	private String filePath;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() { 
		return "CFile [name=" + name + ", filePath=" + filePath + "]";
	}
}
