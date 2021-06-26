package ma.eheio.schooly.utilities;

import javax.servlet.http.HttpServletRequest;

public class GenerateURL {

	public static String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}
}
