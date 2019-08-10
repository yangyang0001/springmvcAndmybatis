package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.ssm.dao.UploadDao;
import cn.itcast.ssm.po.UploadBean;
import cn.itcast.ssm.service.UploadService;

/**
 * 上传文件的ServiceImpl
 * @author 杨建伟
 */
@Service
public class UploadServiceImpl implements UploadService{
	
	@Autowired
	private UploadDao uploadDao;

	/**
	 * 上传文件
	 * @param uploadBean
	 */
	@Override
	public void uploadFile(UploadBean uploadBean) {
		
		uploadDao.uploadFile(uploadBean);
		
	}

	/**
	 * 查询所有的上传文件
	 * @return
	 */
	@Override
	public List<UploadBean> queryAllUploadList() {
		return uploadDao.queryAllUploadList();
	}

}
