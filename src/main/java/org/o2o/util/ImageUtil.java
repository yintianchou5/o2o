package org.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.o2o.dto.ImageHolder;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
	private static final  Random r=new Random();
	
	public static String generateThumbnail(ImageHolder thumbnail,String targetAddr) {
		String realFileName=getRandomFileName();
		String extension=getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr=targetAddr+realFileName+extension;
		
		File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage()).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")), 1f)
			.outputQuality(0.8f).toFile(dest);
		}catch(IOException e){
			e.printStackTrace();
		}
		return relativeAddr;
	}
	/**
	 * 创建目标路径涉及到的目录如/home/work/dzq/xxx.jpg,
	 * 那么home   work dzq三个文件夹都需要自动创建
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
		File dirPath=new File(realFileParentPath);
		if(!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}
	/**
	 * 获取输入文件流的拓展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
		
	}
	/**
	 * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
	 * @param targetAddr
	 */
	public static String getRandomFileName() {
		//获取随机五位数
		int rannum=r.nextInt(89999)+10000;
		//获取当前时间
		String nowTimeStr=sDateFormat.format(new Date());
		return nowTimeStr+rannum;
	}
	/**
	 * storePath是文件路径则删除文件
	 * storePath是目录路径则删除该目录下的所有文件
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath=new File(PathUtil.getImgBasePath()+storePath);
		if(fileOrPath.exists()) {
			//如果是目录，将目录下的文件递归删除
			if(fileOrPath.isDirectory()) {
				File files[]=fileOrPath.listFiles();
				for(int i=0;i<files.length;i++) {
					files[i].delete();
				}
			}
			//如果是文件直接删除，如果是目录也删除
			fileOrPath.delete();
		}
	}
	/**
	 * watermark 水印
	 * 其中三个参数，第一个是水印的位置，第二个是水印的路径，第三个是透明度
	 * outputQuality  压缩图片大小
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		Thumbnails.of(new File("C://Users/xxx-d2q/Desktop/测试文件夹/图片/7.jpg")).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")), 1f)
				.outputQuality(0.8f).toFile("C://Users/xxx-d2q/Desktop/测试文件夹/图片/new1.jpg");
	}
	/**
	 * 处理详情图，并返回新生成图片的相对值路径
	 * @param productImgHolder
	 * @param dest
	 * @return
	 */
	public static String generateNormalImg(ImageHolder Thumbnail, String targetAddr) {
		//获取不重复的随机名
		String realFileName=getRandomFileName();
		//获取文件的拓展名如png,jpg等
		String extension=getFileExtension(Thumbnail.getImageName());
		//如果目标路径不存在，则自动创建
		makeDirPath(targetAddr);
		//获取文件存储的相对路径（带文件名）
		String relativeAddr=targetAddr+realFileName+extension;
		//获取文件要保存到的目标路径
		File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			Thumbnails.of(Thumbnail.getImage()).size(337, 640)
			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/watermark.png")), 1f)
			.outputQuality(0.9f).toFile(dest);
		}catch(IOException e) {
			throw new RuntimeException("创建缩略图失败："+e.toString());
		}
		//返回图片相对路径
		return relativeAddr;
	}
}
