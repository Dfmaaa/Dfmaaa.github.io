package bin;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class packageFrontendFFUPOnly{
	String sourceFileLocation=""; //users can change this.
    private static ArrayList<String> sourcesToArrayList(File sources){
		FileReader read=new FileReader(sources);
		BufferedReader bread=new BufferedReader(read);
		ArrayList<String> realSources=new ArrayList<String>();
		String containLine="";
		while(containLine=bread.readLine()!=null){
			if(containLine.charAt(0)!='#'){
				sourcesToArrayList.add(containLine);
			}
		}
		return sourcesToArrayList;
	}
	public static String getURLIfExists(String packageName){
		ArrayList<String> sources=sourcesToArrayList(new File(sourceFileLocation));
		for(int x=0;x<sources.size();x++){
			URL checkIfExists=new URL(sources.get(x)+"/"+packageName);
			HttpURLConnection getResponse=(HttpURLConnection)checkIfExists.openConnection();
			try{
				Assert.assertEquals(HttpURLConnection.HTTP_OK, getResponse.getResponseCode());
				return sources.get(x);
			}
			catch(Exception e){
				continue;
			}
		}
		return null;
	}
}
