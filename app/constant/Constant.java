package constant;

public class Constant {

	// 服务器地址
	public static String BASE_URL = "http://test.yalixinli.com";
	public static final String BASE_URL_TEST = "http://test.yalixinli.com";
	public static final String BASE_URL_ON = "http://scale.yalixinli.com";
	/**
	 * 量表请求服务器
	 */
	public static String TEST_SERVER_URL = "http://182.92.189.251:";

	// 请求测评结果测试
	public static String TEST_SERVER_URL_TEST = "http://182.92.189.251:";

	// 请求测评结果正式
	public static String TEST_SERVER_URL_ON = "http://100.98.25.2481:";

	/**
	 * 量表请求方法
	 */
	public static final String TEST_SERVER_METHOD = "/submitScaleAnswers";
	// 二维码上传路径
	public static String FTP_ROOT_PATH = "testManage";
	public static String FTP_UPLOAD_PATH = "/upload/";

	static {
		String online = (String) play.Play.configuration.getProperty("online").trim();
		// 正式环境和测试环境配置
		if (online.trim() != null && online.trim().equals("on")) {
			BASE_URL = BASE_URL_ON;
			TEST_SERVER_URL = TEST_SERVER_URL_ON;
			FTP_ROOT_PATH = "testManage";
		} else if (online.trim() != null && online.trim().equals("test")) {
			BASE_URL = BASE_URL_TEST;
			TEST_SERVER_URL = TEST_SERVER_URL_TEST;
			FTP_ROOT_PATH = "testManage/test";
		} else {
			new java.lang.RuntimeException("online 必须为 on or test!").printStackTrace();
		}
	}

	/**
	 * 短信sn
	 */
	public static final String SN = "SDK-BBX-010-21846";
	/**
	 * 短信密码
	 */
	public static final String PWD = "3f#d3-78";
	public static final String s = "87E4729EA9DB136D8AB18BE991765084";

	/**
	 * sftp远程连接配置
	 */
	public static final String SFTP_REQ_HOST = "172.16.2.123";
	public static final String SFTP_REQ_PORT = "8200";
	public static final String SFTP_REQ_USERNAME = "wenyun";
	public static final String SFTP_REQ_PASSWORD = "wenyun338006";
	public static final int SFTP_DEFAULT_PORT = 22;
	public static final String SFTP_REQ_LOC = "location";
	
	public static final String FTP_CD_UPLOAD_PATH = "upload";
	public static final String FTP_SERVER_PATH = "upload";
	
	/**
	 * 系统版本信息，加密狗用
	 */
	public static final Integer SYS_VERSION = 64;
	public static final Integer SYS_PRODUCT = 34;
	
}
