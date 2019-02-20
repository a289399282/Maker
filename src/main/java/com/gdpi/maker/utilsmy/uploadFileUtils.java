package com.gdpi.maker.utilsmy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;


public class uploadFileUtils {
	
	/*public static String imgBuilder(MultipartFile pic, String Id){
		
		//截取id的前面3个字符串
		String substring = Id.substring(0,3);
		//获取原图片的名字
		String originalFilename = pic.getOriginalFilename();
		
		//项目路径
		//String uploadPath = request.getSession().getServletContext().getRealPath("/");
		
		//上传图片，判断是否有图片
		if("Stu".equals(substring)){
			//工作室存储图片的物理路径
			pic_path.append("img\\studioImg");
			
		}else if ("Dev".equals(substring)){
			//开发人员存储图片的物理路径
			pic_path.append("img\\developerImg");
		}
		//图片新名字
		String newPicName=Id + originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新图片
		File newfile=new File(pic_path.toString(),newPicName);
		
		try {
			//将内存中的图片写到磁盘
			pic.transferTo(newfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//将图片名写到itemsCustom中
		return newPicName;
	}*/

	public static String imgBuilder(MultipartFile pic,HttpServletRequest request){

		//获取原图片的名字
		String originalFilename = pic.getOriginalFilename();

		//项目路径
		String uploadPath = request.getSession().getServletContext().getRealPath("/WEB-INF/user/img/forumImg");

		//图片新名字
		String newPicName=UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新图片
		File newfile=new File(uploadPath,newPicName);

		try {
			//将内存中的图片写到磁盘
			pic.transferTo(newfile);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		//将图片名写到itemsCustom中
		return newPicName;
	}

	/**
	 * 上传图片和生成缩略图
	 * @param file
	 * @param name
	 * @return
	 */
	public static String thumbnailUploadImage(MultipartFile file,String name,HttpServletRequest request){
		//项目路径
		//String pic_path="D:\\Software\\TomCat\\resources\\maker\\";
		String pic_path=request.getSession().getServletContext().getRealPath("WEB-INF/user/");

		String pic_path2 = pic_path;

		final int width=220;
		final int height=220;
		final int suowidth=50;
		final int suoheight=50;

		//截取id的前面3个字符串
		String substring = name.substring(0,3);
		if("Stu".equals(substring)){
			//工作室存储图片的物理路径
			pic_path+="img\\studioImg\\";
			pic_path2+="img\\stuSuoImg\\";
		}else if ("Dev".equals(substring)){
			//开发人员存储图片的物理路径
			pic_path+="img\\developerImg\\";
			pic_path2+="img\\devSuoImg\\";
		}
		//获取原图片的名字
		//String originalFilename = file.getOriginalFilename();
		String newPicName=name + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String des = pic_path + newPicName;//普通图实际存储路径
		String des2 = pic_path2 + newPicName;//缩略图实际存储路径
		try {
			Thumbnails.of(file.getInputStream()).size(width, height).toFile(des);
			Thumbnails.of(file.getInputStream()).size(suowidth, suoheight).toFile(des2);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return newPicName;
	}
	
	public static String videoBuilder(MultipartFile file, String Id,HttpServletRequest request){
		if (file!=null) {
			//for (MultipartFile multipartFile : file) {
				//获取原文件的名字
				//String originalFilename = multipartFile.getOriginalFilename();
				String originalFilename = file.getOriginalFilename();
				//项目路径
				if(file !=null && originalFilename !=null && originalFilename.length()>0){
					//String pic_path="D:\\Software\\TomCat\\resources\\maker\\video\\forumVideo";

					String pic_path=request.getSession().getServletContext().getRealPath("WEB-INF/user/video/forumVideo");

					//视频新名字
					String newPicName=Id + originalFilename.substring(originalFilename.lastIndexOf("."));
					//生成新视频
					File newfile=new File(pic_path,newPicName);
					try {
						//将内存中的视频写到磁盘
						file.transferTo(newfile);
					} catch (IOException e) {
						e.printStackTrace();
						return null;
					}
					//将图片名写到itemsCustom中
					return newPicName;
				}

			//}
			return null;

		}
		return null;
	}
	
	
	/*public static void videoBuilder3(final HttpServletRequest request,HttpServletResponse response){
		String pic_path="D:\\Software\\TomCat\\resources\\maker\\";

		ProdService service = BasicFactory.getFactory().getService(ProdService.class);
		System.out.println(request.getParameter("name"));
		try {
			String encode = this.getServletContext().getInitParameter("encode");
			Map<String, String> paramMap = new HashMap<String,String>();
			//1.上传图片
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*100);
			factory.setRepository(new File(this.getServletContext().getRealPath("WEB-INF/temp")));
			
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setHeaderEncoding(encode);
//			fileUpload.setFileSizeMax(1024*1024*1);
//			fileUpload.setSizeMax(1024*1024*10);
			fileUpload.setProgressListener(new ProgressListener(){
				Long beginTime = System.currentTimeMillis();
				public void update(long bytesRead, long contentLength, int items) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					UploadMsg umsg = new UploadMsg();
					BigDecimal br = new BigDecimal(bytesRead).divide(new BigDecimal(1024),2,BigDecimal.ROUND_HALF_UP);
					BigDecimal cl = new BigDecimal(contentLength).divide(new BigDecimal(1024),2,BigDecimal.ROUND_HALF_UP);
					//剩余字节数
					BigDecimal ll = cl.subtract(br);
					//上传百分比
					BigDecimal per = br.multiply(new BigDecimal(100)).divide(cl,2,BigDecimal.ROUND_HALF_UP);
					umsg.setPer(per.toString());
					//上传用时
					Long nowTime = System.currentTimeMillis();
					Long useTime = (nowTime - beginTime)/1000;
					//上传速度
					BigDecimal speed = new BigDecimal(0);
					if(useTime!=0){
						speed = br.divide(new BigDecimal(useTime),2,BigDecimal.ROUND_HALF_UP);
					}
					umsg.setSpeed(speed.toString());
					//大致剩余时间
					BigDecimal ltime = new BigDecimal(0);
					if(!speed.equals(new BigDecimal(0))){
						ltime = ll.divide(speed,0,BigDecimal.ROUND_HALF_UP);
					}
					umsg.setLtime(ltime.toString());
					request.getSession().setAttribute("umsg", umsg);
				}
			});
			
			if(!fileUpload.isMultipartContent(request)){
				throw new RuntimeException("请使用正确的表单进行上传!");
			}
	
			List<FileItem> list = fileUpload.parseRequest(request);
			for(FileItem item : list){
				if(item.isFormField()){
					//普通字段
					String name = item.getFieldName();
					String value = item.getString(encode);
					paramMap.put(name, value);
				}else{
					//文件上传项
					String realname = item.getName();
					String uuidname = UUID.randomUUID().toString()+"_"+realname;

					String hash = Integer.toHexString(uuidname.hashCode());
					String upload = this.getServletContext().getRealPath("WEB-INF/upload");
					String imgurl = "/WEB-INF/upload";
					for(char c : hash.toCharArray()){
						upload+="/"+c;
						imgurl+="/"+c;
					}
					imgurl +="/"+uuidname;
					paramMap.put("imgurl", imgurl);
					
					File uploadFile = new File(upload);
					if(!uploadFile.exists())
						uploadFile.mkdirs();
					
					InputStream in = item.getInputStream();
					OutputStream out = new FileOutputStream(new File(upload,uuidname));
					
					IOUtils.In2Out(in, out);
					IOUtils.close(in, out);
					
					item.delete();
					
					//--生成缩略图
					PicUtils picu = new PicUtils(this.getServletContext().getRealPath(imgurl));
					picu.resizeByHeight(140);
				}
			}
			
			//2.调用Service中提供的方法,在数据库中添加商品
			Product prod = new Product();
			BeanUtils.populate(prod, paramMap);
			service.addProd(prod);
			
			//3.提示成功,回到主页
			response.getWriter().write("添加商品成功!3秒回到主页..");
			response.setHeader("Refresh", "3;url=/index.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}*/
	
	
	public static void videoBuilder2(HttpServletRequest request,HttpServletResponse response){
		StringBuffer pic_path=new StringBuffer("D:\\Software\\TomCat\\resources\\maker\\");
		try{
			//1.创建工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(100*1024);
			factory.setRepository(new File(pic_path.toString()));
			//2.生产文件上传核心类
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			
			//--检查是否是正确的文件上传表单
			if(!ServletFileUpload.isMultipartContent(request)){
				throw new RuntimeException("请用正确的表单进行上传!");
			}
			//--设置文件上传的大小限制
//			fileUpload.setFileSizeMax(1024*1024*100);//单个文件不大于10M
//			fileUpload.setSizeMax(1024*1024*100);//总大小不大于100M
			
			//--设置编码集,解决上传文件名的乱码问题
			fileUpload.setHeaderEncoding("utf-8");
			
			//--设置文件上传监听
			fileUpload.setProgressListener(new ProgressListener(){
				Long beginTime = System.currentTimeMillis();
				@Override
				public void update(long bytesRead, long contentLength, int items) {
					BigDecimal br = new BigDecimal(bytesRead).divide(new BigDecimal(1024),2,BigDecimal.ROUND_HALF_UP);
					BigDecimal cl = new BigDecimal(contentLength).divide(new BigDecimal(1024),2,BigDecimal.ROUND_HALF_UP);
					System.out.print("当前读取的是第"+items+"个上传项,总大小"+cl+"KB,已经读取"+br+"KB");
					//剩余字节数
					BigDecimal ll = cl.subtract(br);
					System.out.print("剩余"+ll+"KB");
					//上传百分比
					BigDecimal per = br.multiply(new BigDecimal(100)).divide(cl,2,BigDecimal.ROUND_HALF_UP);
					System.out.print("已经完成"+per+"%");
					//上传用时
					Long nowTime = System.currentTimeMillis();
					Long useTime = (nowTime - beginTime)/1000;
					System.out.print("已经用时"+useTime+"秒");
					//上传速度
					BigDecimal speed = new BigDecimal(0);
					if(useTime!=0){
						speed = br.divide(new BigDecimal(useTime),2,BigDecimal.ROUND_HALF_UP);
					}
					System.out.print("上传速度为"+speed+"KB/S");
					//大致剩余时间
					BigDecimal ltime = new BigDecimal(0);
					if(!speed.equals(new BigDecimal(0))){
						ltime = ll.divide(speed,0,BigDecimal.ROUND_HALF_UP);
					}
					System.out.print("大致剩余时间为"+ltime+"秒");
					
					System.out.println();
				}
				
			});
			
			//3.利用文件上传核心类解析request
			List<FileItem> list = fileUpload.parseRequest(request);
			//4.遍历所有的FileItem
			for(FileItem item : list){
				if(item.isFormField()){
					//当前是一个普通的字段项
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println(name+":"+value);
				}else{
					//当前是一个文件上传项
					String filename = item.getName();
					String uuidName = UUID.randomUUID().toString()+"_"+filename;
					
					int hash = uuidName.hashCode();
					String hashStr = Integer.toHexString(hash);
					char [] hss = hashStr.toCharArray();
					String path = request.getServletContext().getRealPath("WEB-INF/upload");
					for(char c : hss){
						path+="/"+c;
					}
					new File(path).mkdirs();
					
					InputStream in = item.getInputStream();
					OutputStream out = new FileOutputStream(new File(path,uuidName));
					
					IOUtils.In2Out(in, out);
					IOUtils.close(in, out);
					
					//--删除临时文件
					item.delete();
				}
			}
		}catch (FileSizeLimitExceededException e) {
			try {
				response.getWriter().write("单个文件不超过10M,总大小不超过100M!");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
