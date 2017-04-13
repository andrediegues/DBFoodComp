import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Parser{

	//static Integer i = 1;
	public static void main(String[] args) throws IOException {
		int n = 1132;
		File inputFile, outputFile;
		/*outputFile = new File("/home/adiegues/git/DBFoodComp/dataBase.csv");
		FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("ID,Nome,Grupo,Ácidos gordos saturados,Ácidos gordos monoinsaturados,Ácidos gordos polinsaturados,Ácido linoleico,Hidratos de carbono,Sal,Fibra alimentar,Proteína,Álcool,Água,Ácidos orgânicos,Colesterol,Vitamina A total,Caroteno,Vitamina D,a-tocoferol,Tiamina,Riboflavina,Equivalentes de niacina,Niacina,Vitamina B6,Vitamina B12,Vitamina C,Folatos,Cinza,Sódio,Potássio,Cálcio,Fósforo,Magnésio,Ferro,Zinco\n");*/
		for(int i = 1; i < n; i++){
			if(i == 264 || i == 967 || i == 968 || i == 969 || i == 970 || i == 972 || i == 975 || i == 976 || i == 978 || i == 979 || i == 985 || i == 1009 || i == 1020 || i == 1051 ||i == 1055 || i == 1057 ||i == 1058 || i == 1063 || i == 1087 || i == 1088 || i == 1119 || i == 1120 || i == 1121) continue;
			inputFile = new File("/home/adiegues/git/DBFoodComp/pdf" + i + ".txt");
			parseFile(inputFile, /*bw*/ i);
		}
		//bw.close();
		/*	inputFile = new File("/home/adiegues/git/DBFoodComp/pdf1.txt");
		parseFile(1, inputFile);*/
	}
	public static void parseFile(File inputFile, int i) throws IOException {
		System.out.println("Parsing file " + i + "...");
		FileReader fr = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(fr);
		File outputFile = new File("/home/adiegues/git/DBFoodComp/parsedFile" + i + ".txt");
		FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		String inputLine;
		Scanner in;
		//bw.write(i.toString());
		while((inputLine = br.readLine()) != null){
			inputLine = inputLine.replaceAll(",", "");
			inputLine = inputLine.replaceAll("\"", "");
			//System.out.println(inputLine);
			if(inputLine.contains("Nome:")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String name = in.nextLine();
				bw.write("," + name + "\n");
			}
			else if(inputLine.contains("Grupo:") && !inputLine.contains("SubGrupo:")){
				in = new Scanner(inputLine);
				String name = in.next();
						bw.write(name);
				if(name.equals("Grupo:")){
					if(!in.hasNext()){
						bw.write(",NULL\n");
					}
					else if(name.equals("Grupo:")){
						in.skip("\\s+");
						String group = in.nextLine();
						bw.write("," + group + "\n");
					}
				}
			}
			else if(inputLine.contains("SubGrupo:")){
				continue;
			}
			else if(inputLine.contains("Ácidos gordos")){
				in = new Scanner(inputLine);
				bw.write(in.next() + " " + 	in.next() + " " + in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity + "\n");
			}
			else if(inputLine.contains("Ácido linoleico")){
				in = new Scanner(inputLine);
				bw.write(in.next() + " " + in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Hidratos de carbono")){
				in = new Scanner(inputLine);
				bw.write(in.next() + " " + 	in.next() + " " + in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			
			else if(inputLine.contains("Sal")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Fibra alimentar")){
				in = new Scanner(inputLine);
				bw.write(in.next() + " " + in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Proteína")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Álcool")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}else if(inputLine.contains("Água")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Ácidos orgânicos")){
				in = new Scanner(inputLine);
				bw.write(in.next() + " " + in.next());

				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Colesterol")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}

			else if(inputLine.contains("Vitamina A")){
				in = new Scanner(inputLine);
				bw.write(in.next()+" "+in.next()+" "+in.next()+" "+	in.next()+" "+in.next()+" "+in.next()+" "+in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Caroteno")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Vitamina ")){
				in = new Scanner(inputLine);
				bw.write(in.next() +" "+in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("a-tocoferol")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Tiamina")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Riboflavina")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Equivalentes de niacina")){
				in = new Scanner(inputLine);
				bw.write(in.next()+" "+in.next()+" "+in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Niacina")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Folatos")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}

			else if(inputLine.contains("Cinza")){
				in = new Scanner(inputLine);
				bw.write(in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Sódio")){
				in = new Scanner(inputLine);
				bw.write(in.next()+" " +in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Potássio")){
				in = new Scanner(inputLine);
				bw.write(in.next()+" " +in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Cálcio")){
				in = new Scanner(inputLine);
				bw.write(in.next()+" "+in.next());
				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Fósforo")){
				in = new Scanner(inputLine);
				bw.write(in.next()+" "+in.next());

				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Magnésio")){
				in = new Scanner(inputLine);
				bw.write(in.next()+" "+in.next());

				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Ferro")){
				in = new Scanner(inputLine);
				bw.write(in.next()+" "+in.next());

				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Zinco")){
				in = new Scanner(inputLine);
				bw.write(in.next()+" "+in.next());

				in.skip("\\s+");
				String amount = in.next();
				String unity = in.next();
				bw.write("," + amount + " " + unity + "\n");
			}

			if(inputLine.contains("Legend_pt"))
				break;
		}
		i++;
		br.close();
		bw.close();
	}

}
