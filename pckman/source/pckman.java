import java.io.File;
import java.io.FileReader;
package bin;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.net.URL;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class pckman{
	String sourceFileLocation=" "; //users can change this.
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
	public static void downloadFile(URL url, String fileName) throws Exception{
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }
    public static boolean exists(String[] arr, String value){
		int start=0;
		int end=arr.length-1;
		while(end!=-1){
			if(arr[start].equals(value)){
				return true;
			}
			if(arr[end].equals(value)){
				return true;
			}
			end--;
			start++;
		}
		return false;
	}
	public static void run(String s) throws Exception{
		String option=s.split(" ")[1];
		File defaultSources=new File("sources.ffup");
		if(defualtSources.exists()==false&sourceFileLocation.equals(" ")){
			defaultSources.createNewFile();
			sourceFileLocation="sources.ffup";
		}
		ArrayList<String> sourcesToSearch=sourcesToArrayList(new File(sourceFileLocation));
		
	}
}

