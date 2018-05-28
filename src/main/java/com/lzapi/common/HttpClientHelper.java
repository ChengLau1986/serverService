package com.lzapi.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

//import com.alibaba.fastjson.JSON;
import com.lzapi.util.JsonUtil;

public class HttpClientHelper {

	public static String sendGet(String targetURL, Map<String, Object> map) throws IOException {
		HttpURLConnection connection = null;
		StringBuffer sb = new StringBuffer();
		if (!map.isEmpty()) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				sb.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(), "utf-8"))
						.append("&");
			}
			sb.deleteCharAt(sb.length() - 1);
			targetURL = targetURL + "?" + sb.toString();
		}
		try {
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("requestkey", "HBGSJCYW");
			connection.setConnectTimeout(5 * 1000);
			connection.setRequestMethod("GET");

			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();
		} catch (Exception e) {
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public static String sendPost(String targetURL, Map<String, Object> urlParameters) {
		HttpURLConnection connection = null;
		String param = JsonUtil.obj2String(urlParameters);
		try {
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Length", Integer.toString(param.getBytes().length));
			connection.setRequestProperty("Content-type", "application/json");
			connection.setRequestProperty("requestkey", "HBGSJCYW");
			connection.setConnectTimeout(5 * 1000);
			connection.setUseCaches(false);
			connection.setDoOutput(true);

			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(param);
			wr.close();

			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();
		} catch (Exception e) {
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	/*根据汉字查拼音*/
	public static String startGet(String name){
		String path = new String("http://hanyu.baidu.com/s");
		HttpURLConnection conn = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		try {
			//GET请求直接在链接后面拼上请求参数
			String mPath = path + "?";
			mPath+="wd="+name+"&ptype=zici";
			URL url = new URL(mPath);
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			//Get请求不需要DoOutPut
			conn.setDoOutput(false);
			conn.setDoInput(true);
			//设置连接超时时间和读取超时时间
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			//连接服务器
			conn.connect();
			// 取得输入流，并使用Reader读取
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//关闭输入流
		finally{
			try{
				if(in!=null){
					in.close();
				}
				if (conn != null) {
					conn.disconnect();
				}
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return result.toString();
	}
}