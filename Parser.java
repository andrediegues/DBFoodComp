import java.util.*;

public class Parser{

    public static void main(String[] args){
	int n = 1132;
	File inputFile;
	for(int i = 1; i < n; i++){
	    inputFile = new File("~/git/DBFoodComp/pdf" + i + ".txt");
	    parseFile(i, inputFile);
	}
    }
    public static void parseFile(int n, File inputFile) throws IOException{
	FileReader fr = new FileReader(inputFile);
	BufferedReader br = new BufferedReader(fr);
	
	File outputFile = new File("~/git/DBFoodComp/parsedFile" + n + ".txt");
	FileWriter fw = new FileWriter(outputFile);
	BufferedWriter bw = new BufferedWriter(fw);

	String inputLine;
        
	while((inputLine = br.readline()) != null){
	    //todo - cases to parse
	    ;
	}
    }
}
