import java.io.IOException;
import java.io.InputStream;

import jp.shuri.yamanetoshi.gaeaccess.GoogleAuth;
import junit.framework.TestCase;
import java.io.ByteArrayInputStream;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class GoogleAuthTest extends TestCase {
	class TmpEntity {
		public InputStream getContent() {
			ByteArrayInputStream ret = new ByteArrayInputStream("auth=ABC".getBytes());
			return (InputStream)ret;
		}
	}
	
	class TmpStatusLine {
		private int status;
		public TmpStatusLine() {
			status = 200;
		}
		
		public void setStatus(int i) {
			status = i;
		}
		public int getStatus() {
			return status;
		}
	}

	class HttpResponse {
		private TmpEntity myEntity;
		private TmpStatusLine myStatusLine;
		
		HttpResponse () {
			myEntity = new TmpEntity();
			myStatusLine = new TmpStatusLine();
		}
		
		HttpResponse(int status) {
			this();
			myStatusLine.setStatus(status);
		}
		
		public TmpStatusLine getStatusLine() {
			return myStatusLine;
		}
		
		public TmpEntity getEntity() {
			return myEntity;
		}
	}

	class MyHttpClient implements HttpClient {
		HttpResponse myResponse;
		
		public MyHttpClient() {
			myResponse = new HttpResponse();
		}
		
		public HttpResponse getResponse() {return myResponse;}
		
		public HttpResponse execute(HttpPost p) {
			return myResponse;
		}

		public org.apache.http.HttpResponse execute(HttpUriRequest arg0)
				throws IOException, ClientProtocolException {
			// TODO Auto-generated method stub
			return null;
		}

		public org.apache.http.HttpResponse execute(HttpUriRequest arg0,
				HttpContext arg1) throws IOException, ClientProtocolException {
			// TODO Auto-generated method stub
			return null;
		}

		public org.apache.http.HttpResponse execute(HttpHost arg0,
				HttpRequest arg1) throws IOException, ClientProtocolException {
			// TODO Auto-generated method stub
			return null;
		}

		public <T> T execute(HttpUriRequest arg0,
				ResponseHandler<? extends T> arg1) throws IOException,
				ClientProtocolException {
			// TODO Auto-generated method stub
			return null;
		}

		public org.apache.http.HttpResponse execute(HttpHost arg0,
				HttpRequest arg1, HttpContext arg2) throws IOException,
				ClientProtocolException {
			// TODO Auto-generated method stub
			return null;
		}

		public <T> T execute(HttpUriRequest arg0,
				ResponseHandler<? extends T> arg1, HttpContext arg2)
				throws IOException, ClientProtocolException {
			// TODO Auto-generated method stub
			return null;
		}

		public <T> T execute(HttpHost arg0, HttpRequest arg1,
				ResponseHandler<? extends T> arg2) throws IOException,
				ClientProtocolException {
			// TODO Auto-generated method stub
			return null;
		}

		public <T> T execute(HttpHost arg0, HttpRequest arg1,
				ResponseHandler<? extends T> arg2, HttpContext arg3)
				throws IOException, ClientProtocolException {
			// TODO Auto-generated method stub
			return null;
		}

		public ClientConnectionManager getConnectionManager() {
			// TODO Auto-generated method stub
			return null;
		}

		public HttpParams getParams() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public GoogleAuthTest(String name) {
		super(name);
	}

	public void testgetAuthKeyNormal() {
		try {
			String tmp = GoogleAuth.getAuthKey(new MyHttpClient(), "", "", "");
			assertEquals("ABC", tmp);
		} catch (Exception e) {
		}
	}
	
	public void testgetAuthKey403() {
		try {
			MyHttpClient myClient = new MyHttpClient();
			myClient.getResponse().getStatusLine().setStatus(403);
			String tmp = GoogleAuth.getAuthKey(myClient, "", "", "");
			assertEquals("", tmp);
		} catch (Exception e) {
		}
	}
}
