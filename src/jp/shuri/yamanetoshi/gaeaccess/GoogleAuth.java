package jp.shuri.yamanetoshi.gaeaccess;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class GoogleAuth {
	public static String getAuthKey(HttpClient httpClient, String source, String id, String passwd) throws Exception {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("Email", id));
        nvps.add(new BasicNameValuePair("Passwd", passwd));
        nvps.add(new BasicNameValuePair("service", "ah"));
        nvps.add(new BasicNameValuePair("source", source));
        nvps.add(new BasicNameValuePair("accountType", "HOSTED_OR_GOOGLE"));

        //Login at Google.com
        HttpPost httpost = new HttpPost("https://www.google.com/accounts/ClientLogin");
        HttpResponse response = null;
        
        httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        response = httpClient.execute(httpost);
        
        String authKey = null;
        BufferedReader br = null;

        br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = null;
        while ((line = br.readLine()) != null) {
        	String[] s = line.split("=");
        	if (s.length == 2 && s[0].equalsIgnoreCase("auth")) {
        		authKey = s[1];
        		break;
            }
        }

        if (br != null) br.close();
        
        return authKey;
	}
}
