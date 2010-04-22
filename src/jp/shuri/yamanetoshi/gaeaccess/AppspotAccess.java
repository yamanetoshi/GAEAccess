package jp.shuri.yamanetoshi.gaeaccess;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class AppspotAccess {
	private String URL;
	private HttpClient httpClient;
	
	AppspotAccess(String url, HttpClient httpClient) {
		this.URL = url;
		this.httpClient = httpClient;
	}
	
	public HttpResponse getContent(String authKey, String URI) throws Exception {
        HttpGet httpget = new HttpGet(URL + "/_ah/login?auth=" + authKey + "&continue=" + URI);
        return httpClient.execute(httpget);
    }
	
	public HttpResponse getContent(String URI) throws Exception {
		HttpGet httpget = new HttpGet(URL + "/" + URI);
		return httpClient.execute(httpget);
	}
}
