package org.o2o.util;


public class PathUtil {
	private static String separator=System.getProperty("file.separator");
	public static String getImgBasePath() {
		String os=System.getProperty("os.name");
		String basePath="";
		if(os.toLowerCase().startsWith("win")) {
			basePath="C:/Users/xxx-d2q/Desktop/测试文件夹/图片/images";
		}else {
			basePath="/home/dzq/image";
		}
		basePath=basePath.replace("/",separator);
		return basePath;
	}
	public static String getShopImagePath(long shopId) {
		String imagePath="/upload/item/shop/"+shopId+"/";
		return imagePath.replace("/",separator);
	}
	public static void main(String[] args) {
		System.out.println(separator);
	}
}
