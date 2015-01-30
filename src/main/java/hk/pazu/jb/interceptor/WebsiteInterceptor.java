package hk.pazu.jb.interceptor;

import hk.pazu.jb.util.HttpUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class WebsiteInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(WebsiteInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		HttpSession session = req.getSession();
		this.writeLog(req, resp, session);
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	private void writeLog(HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) {
		String ipAddress = HttpUtil.getIpAddress(req);
		String userAgent = HttpUtil.getUserAgent(req);
		String requestUrl = req.getRequestURI()
				+ ((req.getQueryString() != null) ? "?" + req.getQueryString()
						: "");
		logger.info("=================================================================");
		logger.info("Server Name: {}://{}:{}", req.getScheme(),
				req.getServerName(), req.getServerPort());
		logger.info("X-FORWARDED-FOR: {}", req.getHeader("X-FORWARDED-FOR"));
		logger.info("Request URL: {}", requestUrl);
		logger.info("IP Address: {}", ipAddress);
		logger.info("User Agent: {}", userAgent);
		logger.info("SessionId: {}", req.getSession(true).getId());
		logger.info("==================================================================");
	}
}
