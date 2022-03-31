package bin;
import java.util.ArrayList;
import java.io.File;
public class search{
	private static String[] altstr(ArrayList<Character> chal){
		String[] rstr=new String[chal.size()];
		for(int x=0;x<rstr.length;x++){
			rstr[x]=Character.toString(chal.get(x));
		}
		return rstr;
	}
	private static String[] getOptions(String argument){
    	ArrayList<Character> contain=new ArrayList<Character>();
    	for(int x=0;x<argument.length()-1;x++){
    		if(argument.charAt(x)=='-'){
              contain.add(argument.charAt(x+1));
    		}
    	}
    	return altstr(contain);
	}
	private static boolean linearSearchBool(String[] arr, String value){
		int len=arr.length-1;
		int start=0;
		while(len!=-1){
         if(arr[start].equals(value)){
         	return true;
         }
         if(arr[len].equals(value)){
         	return true;
         }
         len--;
         start++;
		}
		return false;
	}
	private static int linearSearchInt(String[] arr, String value){
		int len=arr.length-1;
		int start=0;
		while(len!=-1){
         if(arr[start].equals(value)){
         	return start;
         }
         if(arr[len].equals(value)){
         	return len;
         }
         len--;
         start++;
		}
		return -1;
	}
	private static int points(String id, String id2){
		int ret=0;
		if(id.length()>id2.length()){
			for(int x=0;x<id2.length();x++){
				if(id.charAt(x)==id2.charAt(x)){
					ret++;
				}
			}
		}
		else{
			for(int x=0;x<id.length();x++){
				if(id.charAt(x)==id2.charAt(x)){
					ret++;
				}
			}
		}
		return ret;
	}
	private static void linearSoundex(File[] a, String term, boolean recursive){
		Long len=new Long(a.length-1);
		Long start=new Long(0);
		while(len!=-1){
			if(points(a[start.intValue()].getName(),term)>=(int)term.length()/2){
				System.out.println(a[start.intValue()].getPath());
				if(recursive){
					return;
				}
			}
			if(points(a[len.intValue()].getName(),term)>=(int)term.length()/2){
				System.out.println(a[len.intValue()].getPath());
				if(recursive){
					return;
				}
			}
			len--;
			start++;
		}
	}
	private static void strLinear(File[] a, String term, boolean recursive, boolean soundex){
	  if(soundex){
	  	linearSoundex(a,term, recursive);
	  }
	  Long len=new Long(a.length-1);
	  Long start=new Long(0);
		while(len!=-1){
			if(a[start.intValue()].getName().equals(term)){
				System.out.println(a[start.intValue()].getPath());
				if(recursive==false){
					return;
				}
			}
			if(a[len.intValue()].getName().equals(term)){
				System.out.println(a[len.intValue()].getPath());
				if(recursive==false){
					return;
				}
			}
			len--;
			start++;
		}
	}
	public static void run(String s){
     String mArgs=s.substring(7,s.length());
     String[] options=getOptions(mArgs);
     boolean recursive=linearSearchBool(options,"r");
     boolean soundex=linearSearchBool(options,"s");
     boolean termOption=linearSearchBool(options,"t");
     File location=new File(".");
     	if(linearSearchBool(options,"l")){
     		try{
     			location=new File(mArgs.split(" ")[linearSearchInt(s.split(" "),"-l")+1]);
     		}
     		catch(ArrayIndexOutOfBoundsException arrfull){
     			System.out.println("Error: location not entered.(This is being shown because \"-l\" was used).");
     			return;
     		}
     		catch(Exception e){
     			System.out.println("Error not handled. ID: " + e.getClass().getSimpleName());
                return;
     		}
     	}
     Directory libuse=new Directory(location);
     //searching for files
     if(linearSearchBool(options,"f")){
       File[] files=new File[1];
       if(recursive){
        files=libuse.recursiveDirFiles();
       }
       else{
       	files=libuse.dirFiles();
       }
       if(termOption){
       	try{
       	strLinear(files,mArgs.split(" ")[linearSearchInt(s.split(" "),"-t")+1],recursive,soundex);
        }
        catch(ArrayIndexOutOfBoundsException ex){
        	System.out.println("Error: term not entered.(This is being shown because \"-t\" was used).");
        	return;
        }
        catch(Exception uexp){
        	System.out.println("Error not handled, ID: " + uexp.getClass().getSimpleName());
        }
       }
       else{
         strLinear(files,mArgs.split(" ")[mArgs.length()-1],recursive,soundex);
       }
     }
     //searching for directories
     else if(linearSearchBool(options,"d")){
       File[] files=new File[1];
       if(recursive){
        files=libuse.recursiveDirDirectories();
       }
       else{
       	files=libuse.dirDirectories();
       }
       if(termOption){
       	try{
       	strLinear(files,mArgs.split(" ")[linearSearchInt(s.split(" "),"-t")+1],recursive, soundex);
        }
        catch(ArrayIndexOutOfBoundsException ex){
        	System.out.println("Error: term not entered.(This is being shown because \"-t\" was used).");
        	return;
        }
        catch(Exception uexp){
        	System.out.println("Error not handled, ID: " + uexp.getClass().getSimpleName());
        }
       }
       else{
         strLinear(files,mArgs.split(" ")[mArgs.length()-1],recursive, soundex);
       }
     }
    //searching for everything, only if no "f" or "d"
    else{
       File[] files=new File[1];
       if(recursive){
        files=libuse.recursiveDirAll();
       }
       else{
       	files=libuse.dir();
       }
       if(termOption){
       	try{
       	strLinear(files,mArgs.split(" ")[linearSearchInt(s.split(" "),"-t")+1],recursive, soundex);
        }
        catch(ArrayIndexOutOfBoundsException ex){
        	System.out.println("Error: term not entered.(This is being shown because \"-t\" was used).");
        	return;
        }
        catch(Exception uexp){
        	System.out.println("Error not handled, ID: " + uexp.getClass().getSimpleName());
        }
       }
       else{
         strLinear(files,mArgs.split(" ")[mArgs.length()-1],recursive, soundex);
       }
    } 
  } 
}
