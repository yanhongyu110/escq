package com.jero.esc.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	/**
	 * 获取文件扩展名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param file
	 * @return
	 */
	public static String getExtention(File file) {
		if (file == null) {
			return null;
		}
		if (file.isDirectory()) {
			return "";
		}
		String fileName = file.getName();
		String prefix = fileName.substring(fileName.lastIndexOf("."));
		return prefix;
	}

	/**
	 * 文件拷贝
	 * 
	 * @param resourceFile源文件
	 * @param targetFileName目的文件
	 * @return
	 * @throws IOException
	 */
	public static boolean copyFile(String resourceFimeName, String targetFileName) throws IOException {
		return copyFile(new File(resourceFimeName), new File(targetFileName));
	}

	/**
	 * 文件拷贝
	 * 
	 * @param resourceFile源文件
	 * @param targetFileName目的文件
	 * @return
	 * @throws IOException
	 */
	public static boolean copyFile(String resourceFimeName, File targetFile) throws IOException {
		return copyFile(new File(resourceFimeName), targetFile);
	}

	/**
	 * 文件拷贝
	 * 
	 * @param resourceFile源文件
	 * @param targetFileName目的文件
	 * @return
	 * @throws IOException
	 */
	public static boolean copyFile(File resourceFile, String targetFileName) throws IOException {
		return copyFile(resourceFile, new File(targetFileName));
	}

	/**
	 * 文件拷贝
	 * 
	 * @param resourceFile源文件
	 * @param targetFile目的文件
	 * @return
	 */
	public static boolean copyFile(File resourceFile, File targetFile) throws IOException {
		if (resourceFile == null || targetFile == null)
			return false;

		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			if (resourceFile.exists()) {
				if (!targetFile.exists()) {
					File parentFile = targetFile.getParentFile();
					if (!parentFile.exists())
						parentFile.mkdirs();
					targetFile.createNewFile();
				}
				in = new FileInputStream(resourceFile);
				out = new FileOutputStream(targetFile);
				byte[] buffer = new byte[1024 * 8];
				int i = 0;

				while ((i = in.read(buffer)) != -1) {
					out.write(buffer, 0, i);
				}
				out.flush();
				return true;
			} else {
				return false;
			}
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	/**
	 * 文件刪除
	 * 
	 * @param fileName要删除文件的全路径
	 */
	public static void deleteFile(String fileName) {
		if (fileName != null) {
			deleteFile(new File(fileName));
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param file要删除的文件
	 */
	public static void deleteFile(File file) {
		if (file != null && file.exists()) {
			file.delete();
		}
	}

	public static String getFileNameByUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().trim().replaceAll("-", "");
	}
	
	/**
	 * 
	 *<pre>
	 *<b> 保存文件到服务器 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2018-2-5 下午4:28:22
	 *@param file
	 *@return
	 *</pre>
	 */
	public static String saveFileToLocal(MultipartFile file){
        //上传文件路径
		PropertiesUtil util = new PropertiesUtil();
		String s = File.separator;
        String path = util.getUrlByKey("fileVideoUrl");
        String dateStr = DateUtil.dateToFull1StringDate(new Date());
        path += dateStr + s;
		//文件名
		String fileName = UUIDUtil.getUUID()+".mp4";
        File filepath = new File(path,fileName);
        //判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) { 
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文件当中
        try {
			file.transferTo(new File(path + File.separator + fileName));
			return s+"files"+ s + "video"+s+dateStr+s+fileName;
		} catch (IllegalStateException | IOException e) {
			System.out.println("上传文件异常");
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 
	 *<pre>
	 *<b> 保存图片到本地 .</b>
	 *<b>Description:</b> 
	 *    获取网络图片保存至本地
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2018-1-24 下午5:01:59
	 *@param url
	 *</pre>
	 */
	public static String saveImg(String imgUrl){
		try {
			//new一个URL对象  
			URL url = new URL(imgUrl);  
			//打开链接  
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
			//设置请求方式为"GET"  
			conn.setRequestMethod("GET");  
			//超时响应时间为5秒  
			conn.setConnectTimeout(5 * 1000);  
			//通过输入流获取图片数据  
			InputStream inStream = conn.getInputStream();  
			//得到图片的二进制数据，以二进制封装得到数据，具有通用性  
			byte[] data = readInputStream(inStream);  		
			String str = "E:/service/tomcat7/service704/webapps/esc/files/image/";
			//获取当前日期
			String nowDate = DateUtil.dateToFull1StringDate(new Date())+"/";
			str += nowDate;
			System.out.println(str);
			File file = new File(str);
			if(!file.exists()){
				file.mkdirs();
			}
			String path = UUIDUtil.getUUID() + ".jpg";
			str += path;
			OutputStream os = new FileOutputStream(new File(str));
			os.write(data);
			inStream.close();
			os.close();
			return "/files/image/"+nowDate+ "/" + path;
		} catch (Exception e) {
			return null;
		}
	}
	public static void main(String[] args) {
		String str = saveImg("http://q.qlogo.cn/qqapp/101459414/1F2EF6145C120D85C365F74FCED7CD24/100");
		System.out.println(str);
	}
	/**
	 * 
	 *<pre>
	 *<b> 读取文件 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2018-1-24 下午5:05:37
	 *@param inStream
	 *@return
	 *</pre>
	 */
    public static byte[] readInputStream(InputStream inStream){  
    	ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
    	try {
    		//创建一个Buffer字符串  
    		byte[] buffer = new byte[1024];  
    		//每次读取的字符串长度，如果为-1，代表全部读取完毕  
    		int len = 0;  
    		//使用一个输入流从buffer里把数据读取出来  
    		while( (len=inStream.read(buffer)) != -1 ){  
    			//用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度  
    			outStream.write(buffer, 0, len);  
    		}  
    		//关闭输入流  
    		inStream.close();  
    		//把outStream里的数据写入内存  
		} catch (Exception e) {
			// TODO: handle exception
		}
        return outStream.toByteArray();  
    }  
}
