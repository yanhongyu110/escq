package com.jero.esc.service.impl.goodsinfo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.StringUtil;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.mapper.goodsinfo.VideoMapper;
import com.jero.esc.po.goodsinfo.VideoInfo;
import com.jero.esc.service.goodsinfo.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoMapper videoMapper;
	
	@Override
	public JsonResult addVideoInfo(VideoInfo videoInfo) {
		if(videoInfo != null){
			if(StringUtil.isNotEmpty(videoInfo.getLogId())){
				if(StringUtil.isNotEmpty(videoInfo.getVideoTitle())){
					if(StringUtil.isNotEmpty(videoInfo.getVideoUrl())){
						videoInfo = setAttribute(videoInfo);
						int i = videoMapper.addVideoInfo(videoInfo);
						if(i == 1){
							return new JsonResult(true, "上传成功", videoInfo);
						}else{
							return new JsonResult(false, "上传视频失败,请检查网络",null);
						}
					}else{
						return new JsonResult(false, "请上传视频",null);
					}
				}else{
					return new JsonResult(false, "请输入标题",null);
				}
			}else{
				return new JsonResult(false, "登录超时",null);

			}
		}else{
			return new JsonResult(false, "未获取到数据",null);

		}
	}
	
	/**
	 * 
	 *<pre>
	 *<b> 初始化属性 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2018-2-6 上午10:24:57
	 *@param videoInfo
	 *@return
	 *</pre>
	 */
	public VideoInfo setAttribute(VideoInfo videoInfo){
		if(videoInfo == null){
			return null;
		}
		videoInfo.setVideoCreateTime(new Date());
		videoInfo.setVideoId(UUIDUtil.getUUID());
		videoInfo.setVideoIsDel("0");
		videoInfo.setVideoStuta("2");
		return videoInfo;
	}
}
