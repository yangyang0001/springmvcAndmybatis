package cn.itcast.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.ssm.po.UploadBean;

/**
 * 上传文件Dao
 * @author 杨建伟
 *
 */
public interface UploadDao {
	
	/**
	 * 上传文件
	 * @param uploadBean
	 */
	public void uploadFile(@Param("uploadBean") UploadBean uploadBean);

	
	/**
	 * 查询所有的上传文件
	 * @return
	 */
	public List<UploadBean> queryAllUploadList();

}
