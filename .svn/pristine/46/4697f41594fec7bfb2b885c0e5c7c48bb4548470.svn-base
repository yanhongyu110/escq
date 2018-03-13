package com.jero.esc.common.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @copyright 上善云图信息技术有限公司
 * @author zqy
 * @version v1.0  （版本号）
 * @date 2016年12月8日
 * @description 验证码的获取
 */
public class ImagesCode {

	public static void getImagesCode(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws Exception{
		//设置页面不缓存   
	    response.setHeader("Pragma", "No-cache");  
	    response.setHeader("Cache-Control", "no-cache");     
	    response.setDateHeader("Expires", 0);  
	    //在内存中创建图像  
	    int width = 60;  
	    int height = 20;  
	    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  
	    //获取图形上下文  
	    Graphics g = image.getGraphics();  
	    //随机类  
	    Random random = new Random();  
	    //设定背景  
	    g.setColor(getRandColor(200, 250));  
	    g.fillRect(0, 0, width, height);  
	    //设定字体  
	    g.setFont(new Font("Times New Roman",Font.PLAIN,18));  
	   //随机产生干扰线  
	   g.setColor(getRandColor(160, 200));     
	   for (int i = 0; i < 100; i++) {     
	        int x = random.nextInt(width);     
	        int y = random.nextInt(height);     
	        int xl = random.nextInt(12);     
	        int yl = random.nextInt(12);     
	        g.drawLine(x, y, x + xl, y + yl);     
	   }   
	   //随机产生4位验证码  
	   String[] codes = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};  
	   String code = "";  
	   for(int i=0;i<4;i++){  
	       String str = codes[random.nextInt(codes.length)];  
	       code += str;  
	       // 将认证码显示到图象中  
	       g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));  
	       //调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成     
	       g.drawString(str, 13 * i + 6, 16);     
	   }  
	    // 将认证码存入SESSION     
	   request.getSession().setAttribute("code", code);  
	   // 图象生效     
	   g.dispose();     
	  
	   try {
		   // 输出图象到页面     
		ImageIO.write(image, "JPEG", response.getOutputStream());
		//加上下面代码,运行时才不会出现java.lang.IllegalStateException: getOutputStream() has already been called ..........等异常  
		   response.getOutputStream().flush();    
		   response.getOutputStream().close();    
		   response.flushBuffer();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	      
	}
	/**
	 * 
	 * @Description <设置图片的颜色>
	 * @return 返回值
	 * @throws Exception
	 * @param fc
	 * @param bc
	 * @return
	 */
	public static Color getRandColor(int fc,int bc){  
	    Random random = new Random();  
	    if(fc>255) fc=255;  
	    if(bc>255) bc=255;  
	    int r = fc + random.nextInt(bc - fc);  
	    int g = fc + random.nextInt(bc - fc);  
	    int b = fc + random.nextInt(bc - fc);  
	    return new Color(r,g,b);  
	}  
	
	/**
	 * @Description <验证图片验证码,因为字母是不区分大小写的,所以才用这个方法把他分离出来验证>
	 * @return 返回值
	 * @throws Exception
	 * @return
	 */
	public static boolean validateImagesCode(HttpSession session,String imagesCode){
		boolean isValidateImages = false;
		String rand = session.getAttribute("code").toString();
		StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();  
        if(!imagesCode.equals("") && imagesCode != null){  
            for(int i=0;i<imagesCode.length();i++){  
                char c = imagesCode.charAt(i);  
                if(Character.isUpperCase(c)){  
                    sb.append(Character.toLowerCase(c));  
                }else{
                	sb.append(c);
                }
            }
            for(int i=0;i<rand.length();i++){  
                char c = rand.charAt(i);  
                if(Character.isUpperCase(c)){  
                    sb1.append(Character.toLowerCase(c));  
                }else{
                	sb1.append(c);
                }
            }
            if(sb.toString().equals(sb1.toString())){  
            	isValidateImages = true;
            }
        }
        return isValidateImages;
	}
	
}
