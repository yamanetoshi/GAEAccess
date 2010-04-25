import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

import jp.shuri.yamanetoshi.gaeaccess.HTTPResponse2JSON;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.params.HttpParams;
import org.apache.http.HttpResponse;

public class HTTPResponse2JSONTest extends TestCase {
	class TmpEntity implements HttpEntity {
		public InputStream getContent() {
			ByteArrayInputStream ret = new ByteArrayInputStream("auth=ABC\nxx=abc".getBytes());
			return (InputStream)ret;
		}

		public void consumeContent() throws IOException {
			// TODO Auto-generated method stub
			
		}

		public Header getContentEncoding() {
			// TODO Auto-generated method stub
			return null;
		}

		public long getContentLength() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Header getContentType() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isChunked() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isRepeatable() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isStreaming() {
			// TODO Auto-generated method stub
			return false;
		}

		public void writeTo(OutputStream arg0) throws IOException {
			// TODO Auto-generated method stub
			
		}
	}

	class MyHttpResponse implements HttpResponse {
		private TmpEntity myEntity;
		
		MyHttpResponse () {
			super();
			myEntity = new TmpEntity();
		}
		
		public TmpEntity getEntity() {
			return myEntity;
		}

		public Locale getLocale() {
			// TODO Auto-generated method stub
			return null;
		}

		public StatusLine getStatusLine() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setEntity(HttpEntity arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setLocale(Locale arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setReasonPhrase(String arg0) throws IllegalStateException {
			// TODO Auto-generated method stub
			
		}

		public void setStatusCode(int arg0) throws IllegalStateException {
			// TODO Auto-generated method stub
			
		}

		public void setStatusLine(StatusLine arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setStatusLine(ProtocolVersion arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		public void setStatusLine(ProtocolVersion arg0, int arg1, String arg2) {
			// TODO Auto-generated method stub
			
		}

		public void addHeader(Header arg0) {
			// TODO Auto-generated method stub
			
		}

		public void addHeader(String arg0, String arg1) {
			// TODO Auto-generated method stub
			
		}

		public boolean containsHeader(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		public Header[] getAllHeaders() {
			// TODO Auto-generated method stub
			return null;
		}

		public Header getFirstHeader(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public Header[] getHeaders(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public Header getLastHeader(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public HttpParams getParams() {
			// TODO Auto-generated method stub
			return null;
		}

		public ProtocolVersion getProtocolVersion() {
			// TODO Auto-generated method stub
			return null;
		}

		public HeaderIterator headerIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		public HeaderIterator headerIterator(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public void removeHeader(Header arg0) {
			// TODO Auto-generated method stub
			
		}

		public void removeHeaders(String arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setHeader(Header arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setHeader(String arg0, String arg1) {
			// TODO Auto-generated method stub
			
		}

		public void setHeaders(Header[] arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setParams(HttpParams arg0) {
			// TODO Auto-generated method stub
			
		}
	}

	public HTTPResponse2JSONTest() {
		
	}
	
	public void testgetJSONString() {
		try {
			String tmp = HTTPResponse2JSON.getJSONString(new MyHttpResponse());
			assertEquals("auth=ABC xxx=abc", tmp);
		} catch (Exception e) {
		}		
	}
}
