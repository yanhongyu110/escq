package com.jero.esc.controller.wap.goodsinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.FileUtil;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.po.goodsinfo.VideoInfo;
import com.jero.esc.service.goodsinfo.VideoService;

/**
 * 
 * <pre>
 * <b> 视频相关接口 .</b>
 * <b>Description:</b> 
 *    视频发布,视频查询,视频修改,删除等接口
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2018-2-5上午10:28:41
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018-2-5上午10:28:41         new file.
 * </pre>
 */
@Controller
@RequestMapping(value="/wapVideo")
public class WapVideoController {
	
	@Autowired
	private VideoService videoService;
	
	@RequestMapping(value="/toVideo")
	public ModelAndView toVideo(){
		return new ModelAndView("/wap/goodsinfo/add_sp");
	}
	/**
	 * 
	 *<pre>
	 *<b> 保存视频 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2018-2-9 上午10:49:26
	 *@param request
	 *@param response
	 *@param videoInfo
	 *</pre>
	 */
	@RequestMapping(value="/addVideo")
	public void addVideo(HttpServletRequest request, HttpServletResponse response, VideoInfo videoInfo){
		JsonResult temp = new JsonResult();
		try {
			temp = videoService.addVideoInfo(videoInfo);
		} catch (Exception e) {
			temp.setSuccess(false);
			temp.setErrorMsg("系统异常");
		}
		JsonUtil.printByJSON(response, temp);
	}
	@RequestMapping(value="/uploadVideo")
	public void uploadVideo(HttpServletRequest request,HttpServletResponse response,MultipartFile file){
        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
        	String path = FileUtil.saveFileToLocal(file);
			JsonUtil.printByJSON(response, new JsonResult(true, "上传成功",path));
        } else {
        	JsonUtil.printByJSON(response, new JsonResult(false, "上传文件为空", null));
        }
	}
}
