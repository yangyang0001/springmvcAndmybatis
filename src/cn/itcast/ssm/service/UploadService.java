package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.UploadBean;

/**
 * 上传Service
 * @author 杨建伟
 *
 */
public interface UploadService {

	/**
	 * 上传文件
	 * @param uploadBean
	 */
	public void uploadFile(UploadBean uploadBean);

	/**
	 * 查询所有的上传文件
	 * @return
	 */
	public List<UploadBean> queryAllUploadList();
	
}
