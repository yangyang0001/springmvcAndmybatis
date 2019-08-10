package cn.itcast.ssm.po;

/**
 * 上传文件的Bean
 * 
 * @author 杨建伟
 */
public class UploadBean {
	
	private int id;				//主键Id
	
	private String realName;	//文件真实名称
	
	private String fileType;	//文件类型
	
	private String realPath;	//文件绝对路径
	
	private long fileSize;		//文件大小

	//************************************************上传文件的Bean*************************************************
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	
	
	
}
