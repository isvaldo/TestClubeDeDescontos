package br.clubededesconto.helpers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadSiteMapJson {
	
	
	private List<String> urls;

	public ReadSiteMapJson(String Filepath) {
		this.urls = new ArrayList<String>();
		
		try {
			
			String content = readFile(Filepath, Charset.defaultCharset());
			JSONObject obj = new JSONObject(content);
			JSONArray items = obj.getJSONObject("rss").
					getJSONObject("channel").getJSONArray("item");		
			
			
			
			for (int i=0; i<items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				String url = item.getString("link");
				this.urls.add(url);
			}
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
		
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			  
			
			}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
	
	
	
	

}
