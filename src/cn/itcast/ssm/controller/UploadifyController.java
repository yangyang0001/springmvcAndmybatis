//package cn.itcast.ssm.controller;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MultipartFile;
//
//import cn.itcast.ssm.po.UploadBean;
//import cn.itcast.ssm.service.UploadService;
//
//@Controller
//@RequestMapping("/upload")
//public class UploadifyController {
//	
//	@Autowired
//	private UploadService uploadService;
//	
//	/**
//	 * 查询上传文件
//	 * @return
//	 */
//	@RequestMapping("/getUploadList")
//	public String getUploadList(HttpServletRequest request , HttpServletResponse response , Model model){
//		
//		List<UploadBean> uploadList = uploadService.queryAllUploadList();
//		
//		model.addAttribute("uploadList", uploadList);
//		
//		return "list";
//	}
//	
//	
//	/**
//	 * 上传文件
//	 * @param request
//	 * @param response
//	 * @param uploadFile
//	 * @return
//	 */
//	@RequestMapping("/uploadFile")
//	public String uploadFileByUploadify(HttpServletRequest request,HttpServletResponse response,MultipartFile[] uploadFile){
//		
//		for(MultipartFile file : uploadFile){
//			
//			String basePath = request.getRealPath("/image");
//			String subName = UUID.randomUUID().toString();
//			String filePath = basePath + "\\" + subName;
//			
//			try {
//				file.transferTo(new File(filePath));
//				
//				UploadBean uploadBean = new UploadBean();
//				uploadBean.setFileSize(file.getSize());
//				uploadBean.setFileType(file.getContentType());
//				uploadBean.setRealName(file.getOriginalFilename());
//				uploadBean.setRealPath(filePath);
//				
//				uploadService.uploadFile(uploadBean);
//				
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return "redirect:/getUploadList.action";
//	}
//	
//
//}
