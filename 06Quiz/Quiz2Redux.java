import java.util.*;
public class Quiz2Redux{  

    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help( words , s /*fill this in with more */);
	Collections.sort(words);
	return words;
    }
  
    private static void help( ArrayList<String> words, String s
			      /*fill this in with more arguments*/ ){

	/*METHOD TO BE WRITTEN BY YOU.*/
	boolean unique=true;
	for (int i=0 ; i<words.size() ; i++){
	    if (s.equals(words.get(i))){
		unique = false;
	    }
	}
	if (unique){
	    words.add(s);
	    if (s.length()>0){
		String part;
		for (int i=0 ; i<s.length() ; i++){
		    part = "";
		    part += s.substring(0,i);
		    if (i+1<s.length()){
			part += s.substring(i+1,s.length());
		    }
		    //System.out.println(part);
		    help(words,part);
		}
	    }
	}
    }


}

