package hk.pazu.jb.util;

import hk.pazu.jb.constant.Constant;

import javax.servlet.http.HttpServletRequest;

public class HttpUtil {

	public static String getIpAddress(HttpServletRequest req) {

		String ipAddress = req.getHeader("HTTP_X_FORWARDED_FOR");
		if (ipAddress == null) {
			ipAddress = req.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null) {
			ipAddress = req.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null) {
			ipAddress = req.getRemoteAddr();
		}
		return ipAddress;
	}

	public static String getUserAgent(HttpServletRequest req) {
		String userAgent = req.getHeader("user-agent");

		if (StringUtil.isEmptyOrNull(userAgent)) {
			userAgent = Constant.USER_AGENT_UNKNOWN;
		}
		return userAgent;
	}

}
