package jp.shuri.yamanetoshi.gaeaccess;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

public class HTTPResponse2JSON {
	public static String getJSONString(HttpResponse response) throws Exception {
		StringBuffer ret = new StringBuffer();
		if(response.getStatusLine().getStatusCode() < 400) {
			InputStream is = response.getEntity().getContent();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while((line = br.readLine()) != null) {
				ret.append(line);
			}
		}
		return ret.toString();
	}
}
