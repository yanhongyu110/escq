//package esc;
//
//import it.sauronsoftware.jave.AudioAttributes;
//import it.sauronsoftware.jave.EncodingAttributes;
//import it.sauronsoftware.jave.InputFormatException;
//import it.sauronsoftware.jave.MultimediaInfo;
//import it.sauronsoftware.jave.VideoAttributes;
//import it.sauronsoftware.jave.VideoSize;
//
//import java.io.File;
//
//import com.alipay.api.internal.util.codec.EncoderException;
//
//public class test {
//	public static void main(String[] args) {
//		File source = new File("C:\\Users\\xfy\\desktop\\工作文档\\2817\\test.avi");  
//		File target = new File("C:\\Users\\xfy\\desktop\\工作文档\\2817\\test__001.flv");  
//		AudioAttributes audio = new AudioAttributes();  
//		audio.setCodec("libmp3lame");  
//		audio.setBitRate(new Integer(64000));  
//		audio.setChannels(new Integer(1));  
//		audio.setSamplingRate(new Integer(22050));  
//		VideoAttributes video = new VideoAttributes();  
//		video.setCodec("flv");  
//		video.setBitRate(new Integer(160000));  
//		video.setFrameRate(new Integer(15));  
//		video.setSize(new VideoSize(400, 300));  
//		EncodingAttributes attrs = new EncodingAttributes();  
//		attrs.setFormat("flv");  
//		attrs.setAudioAttributes(audio);  
//		attrs.setVideoAttributes(video);  
//		Encoder encoder = new Encoder();  
//		encoder.encode(source, target, attrs);  
//		   
////		File source = new File("C:\\Users\\xfy\\desktop\\工作文档\\2817\\test_1111.mp4");  
////		File target = new File("C:\\Users\\xfy\\desktop\\工作文档\\2817\\test_1111.avi");// 转MP4  
////		System.out.println(source.length());  
//		   
////		AudioAttributes audio = new AudioAttributes();  
////		audio.setCodec("libmp3lame");  
////		audio.setBitRate(new Integer(64000));  
////		audio.setChannels(new Integer(1));  
////		audio.setSamplingRate(new Integer(22050));  
////		VideoAttributes video = new VideoAttributes();  
////		video.setCodec("libxvid");// 转MP4  
////		video.setBitRate(new Integer(180000));// 180kb/s比特率  
////		video.setFrameRate(new Integer(1));// 1f/s帧频，1是目前测试比较清楚的，越大越模糊  
////		EncodingAttributes attrs = new EncodingAttributes();  
////		attrs.setFormat("avi");// 转MP4  
////		attrs.setAudioAttributes(audio);  
////		attrs.setVideoAttributes(video);  
////		Encoder encoder = new Encoder();  
////		long beginTime = System.currentTimeMillis();  
//		try {  
//		    // 获取时长  
////		    MultimediaInfo m = encoder.getInfo(source);  
////		    System.out.println(m.getDuration());  
////		    System.out.println("获取时长花费时间是：" + (System.currentTimeMillis() - beginTime));  
////		    beginTime = System.currentTimeMillis();  
////		    encoder.encode(source, target, attrs);  
////		    System.out.println("视频转码花费时间是：" + (System.currentTimeMillis() - beginTime));  
//		} catch (IllegalArgumentException e) {  
//		    e.printStackTrace();  
//		} catch (InputFormatException e) {  
//		    e.printStackTrace();  
//		} catch (EncoderException e) {  
//		    e.printStackTrace();  
//		}
//	}
//}
