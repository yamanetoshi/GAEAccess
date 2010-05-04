import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;

import jp.shuri.yamanetoshi.gaeaccess.*;
import junit.framework.TestCase;

public class GAEAccessTest extends TestCase {
	private DefaultHttpClient myHttpClient;
	private AppspotAccess myAppspotAccess;
	private String URI = "";

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();

		myHttpClient = new DefaultHttpClient();
	
		myAppspotAccess = new AppspotAccess("http://test-yamanetoshi.appspot.com", myHttpClient);
	}
	
	public void testAuthAccess() {
		try {
			String authKey = GoogleAuth.getAuthKey(myHttpClient, "test-yamanetoshi", "hogehoge", "fugafuga");
			HttpResponse tmp = myAppspotAccess.getContent(authKey, URI);
			String ret = HTTPResponse2JSON.getJSONString(tmp);
			final String status = "{\"result\": \"Login Success\"}";
			assertEquals(status, ret);
		} catch (Exception e) {
			
		}
	}
	
	public void testNoAuthAccess() {
		HttpResponse tmp;
		try {
			tmp = myAppspotAccess.getContent(URI);
			String ret = HTTPResponse2JSON.getJSONString(tmp);
			final String status = "{\"result\": \"Login Unsuccessful\"}";
			assertEquals(status, ret);
		} catch (Exception e) {
			
		}
	}
}
