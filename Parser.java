import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Parser{

	public static int iD = 1;

	public static void main(String[] args) throws IOException {
		int n = 1133;
		Food[] food = new Food[n];
		File inputFile;
		File outputFile;

		outputFile = new File("/home/adiegues/git/DBFoodComp/dataBase.txt");
		FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("ID,Nome,Grupo,Energia,Energia,Lípidos,Ácidos gordos saturados,Ácidos gordos monoinsaturados,Ácidos gordos polinsaturados,Ácido linoleico,Hidratos de carbono,Oligossacáridos,Sacarose,Lactose,Amido,Sal,Fibra alimentar,Proteína,Álcool,Água,Ácidos orgânicos,Colesterol," + 
				"Vitamina A,Caroteno,Vitamina D,a-tocoferol,Tiamina,Riboflavina,Equivalentes de niacina,Niacina,Vitamina B6,Vitamina B12,Vitamina C,Folatos,Cinza,Sódio,Potássio,Cálcio,Fósforo,Magnésio,Ferro,Zinco\n");
		for(int i = 1; i < n; i++){
			if(i == 264 || i == 967 || i == 968 || i == 969 || i == 970 || i == 972 || i == 975 || i == 976 || i == 978 || i == 979 || i == 985 || i == 1009 || i == 1020 || i == 1051 ||i == 1055 || i == 1057 ||i == 1058 || i == 1063 || i == 1087 || i == 1088 || i == 1119 || i == 1120 || i == 1121) continue;
			inputFile = new File("/home/adiegues/git/DBFoodComp/pdf" + i + ".txt");
			food[i] = parseFile(inputFile, /*bw*/ i);
			if(food[i] != null){
				printFood(food[i], bw);
				bw.write("\n");
			}
		}

		bw.close();
	}
	private static void printFood(Food food, BufferedWriter bw) throws IOException {
		// TODO Auto-generated method stub
		bw.write(food.getId() + "," + food.getName() + "," + food.getGroup());

		if(food.energie.size() == 2){
			for(int i = 0; i < food.energie.size(); i++){
				bw.write("," + food.energie.get(i).value + " " + food.energie.get(i).unity);
			}
		}
		else{
			if(food.energie.get(0).unity.contains("J")){
				bw.write("," + food.energie.get(0).value + " " + food.energie.get(0).unity + ",0 kcal");
			}
			else{
				bw.write(",0 kJ," + food.energie.get(0).value + " " + food.energie.get(0).unity);
			}
		}

		//if(food.macro.size() == 9){
			for(int i = 0; i < food.macro.size(); i++){

				bw.write("," + food.macro.get(i).value + " " + food.macro.get(i).unity);
				if(food.macro.get(i).name.equals("Lípidos")){
					//if(food.macro.get(i).subcomps.size() == 4){
						for(int j = 0; j < food.macro.get(i).subcomps.size(); j++){
							bw.write("," + food.macro.get(i).subcomps.get(j).value + " " + food.macro.get(i).subcomps.get(j).unity);							
						}
				}

				if(food.macro.get(i).name.equals("Hidratos de carbono")){
					//if(food.macro.get(i).subcomps.size() == 4){
						for(int j = 0; j < food.macro.get(i).subcomps.size(); j++){
							bw.write("," + food.macro.get(i).subcomps.get(j).value + " " + food.macro.get(i).subcomps.get(j).unity);							
						}
				}
			}
		
		for(int i = 0; i < food.vitamins.size(); i++){
			bw.write("," + food.vitamins.get(i).value + " " + food.vitamins.get(i).unity);	
		}

		for(int i = 0; i < food.minerals.size(); i++){
			bw.write("," + food.minerals.get(i).value + " " + food.minerals.get(i).unity);	
		}
	}
	public static Food parseFile(File inputFile, int i) throws IOException {
		System.out.println("Parsing file " + i + "...");
		Food f = new Food();
		FileReader fr = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(fr);

		String inputLine;
		Scanner in;
		////bw.write(i.toString());
		while((inputLine = br.readLine()) != null){
			inputLine = inputLine.replaceAll(",", "");
			inputLine = inputLine.replaceAll("\"", "");
			//System.out.println(inputLine);

			if(inputLine.contains("Nome:")){
				in = new Scanner(inputLine);
				//	//bw.write(in.next());
				in.next();
				in.skip("\\s+");
				f.setName(in.nextLine());
				////bw.write("," + name + "\n");
			}
			else if(inputLine.contains("Grupo:") && !inputLine.contains("SubGrupo:")){
				in = new Scanner(inputLine);

				if(in.next().equals("Grupo:")){
					if(!in.hasNext()){
						////bw.write(",NULL\n");
					}
					else{
						in.skip("\\s+");
						f.setGroup(in.nextLine());
						////bw.write("," + group + "\n");
					}
				}
			}
			else if(inputLine.contains("SubGrupo:")){
				continue;
			}
			if(inputLine.contains("Energia")){
				in = new Scanner(inputLine);
				//	//bw.write(in.next());
				f.energie.add(new Comp(in.next(), in.nextFloat(), in.next()));
				////bw.write("," + name + "\n");
			}
			else if(inputLine.contains("Lípidos")){
				in = new Scanner(inputLine);
				f.macro.add(new Comp(in.next(), in.nextFloat(), in.next()));
			}
			else if(inputLine.contains("Ácidos gordos")){
				in = new Scanner(inputLine);
				for(int i1 = 0; i1 < f.macro.size(); i1++){
					if(f.macro.get(i1).name.equals("Lípidos")){
						f.macro.get(i1).subcomps.add(new Comp(in.next() + " " + in.next() + " " + in.next(), in.nextFloat(), in.next()));
						break;
					}
				}
			}
			else if(inputLine.contains("Ácido linoleico")){
				in = new Scanner(inputLine);
				for(int i2 = 0; i2 < f.macro.size(); i2++){
					if(f.macro.get(i2).name.equals("Lípidos")){
						f.macro.get(i2).subcomps.add(new Comp(in.next() + " " + in.next(), in.nextFloat(), in.next()));
						break;
					}
				}
			}
			else if(inputLine.contains("Hidratos de carbono")){
				in = new Scanner(inputLine);
				f.macro.add(new Comp(in.next()+" "+in.next()+" "+in.next(), in.nextFloat(), in.next()));
			}
			else if(inputLine.contains("Oligossacáridos")){
				in = new Scanner(inputLine);
				for(int i2 = 0; i2 < f.macro.size(); i2++){
					if(f.macro.get(i2).name.equals("Hidratos de carbono")){
						f.macro.get(i2).subcomps.add(new Comp(in.next(), in.nextFloat(), in.next()));
						break;
					}
				}
			}
			else if(inputLine.contains("Sacarose")){
				in = new Scanner(inputLine);
				for(int i2 = 0; i2 < f.macro.size(); i2++){
					if(f.macro.get(i2).name.equals("Hidratos de carbono")){
						f.macro.get(i2).subcomps.add(new Comp(in.next(), in.nextFloat(), in.next()));
						break;
					}
				}
			}
			else if(inputLine.contains("Lactose")){
				in = new Scanner(inputLine);
				for(int i2 = 0; i2 < f.macro.size(); i2++){
					if(f.macro.get(i2).name.equals("Hidratos de carbono")){
						f.macro.get(i2).subcomps.add(new Comp(in.next(), in.nextFloat(), in.next()));
						break;
					}
				}
			}
			else if(inputLine.contains("Amido")){
				in = new Scanner(inputLine);
				for(int i2 = 0; i2 < f.macro.size(); i2++){
					if(f.macro.get(i2).name.equals("Hidratos de carbono")){
						f.macro.get(i2).subcomps.add(new Comp(in.next(), in.nextFloat(), in.next()));
						break;
					}
				}
			}
			else if(inputLine.contains("Sal") && !inputLine.contains("Nome:")){
				in = new Scanner(inputLine);
				////bw.write(in.next());
				f.macro.add(new Comp(in.next(), in.nextFloat(), in.next()));
			}
			else if(inputLine.contains("Fibra alimentar")){
				in = new Scanner(inputLine);
				////bw.write(in.next() + " " + in.next());
				f.macro.add(new Comp(in.next()+ " " + in.next(), in.nextFloat(), in.next()));

			}
			else if(inputLine.contains("Proteína")){
				in = new Scanner(inputLine);
				////bw.write(in.next());				
				f.macro.add(new Comp(in.next(), in.nextFloat(), in.next()));

			}
			else if(inputLine.contains("Álcool")){
				in = new Scanner(inputLine);
				////bw.write(in.next());
				f.macro.add(new Comp(in.next(), in.nextFloat(), in.next()));
				//bw.write("," + amount + " " + unity+ "\n");
			}else if(inputLine.contains("Água")&& !inputLine.contains("Nome:")){
				in = new Scanner(inputLine);
				////bw.write(in.next());
				f.macro.add(new Comp(in.next(), in.nextFloat(), in.next()));
				////bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Ácidos orgânicos")){
				in = new Scanner(inputLine);
				////bw.write(in.next() + " " + in.next());
				f.macro.add(new Comp(in.next() + " " + in.next(), in.nextFloat(), in.next()));

				////bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Colesterol")){
				in = new Scanner(inputLine);
				////bw.write(in.next());
				f.macro.add(new Comp(in.next(), in.nextFloat(), in.next()));

				////bw.write("," + amount + " " + unity+ "\n");
			}

			else if(inputLine.contains("Vitamina A")){
				in = new Scanner(inputLine);
				////bw.write(in.next()+" "+in.next()+" "+in.next()+" "+	in.next()+" "+in.next()+" "+in.next()+" "+in.next());
				String va = in.next() + " " + in.next();
				in.next();
				in.next();
				in.next();
				in.next();
				f.vitamins.add(new Comp(va, in.nextFloat(), in.next()));

				////bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Caroteno")){
				in = new Scanner(inputLine);
				////bw.write(in.next());
				f.vitamins.add(new Comp(in.next(), in.nextFloat(), in.next()));

				////bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Vitamina ")){
				in = new Scanner(inputLine);
				////bw.write(in.next() +" "+in.next());
				f.vitamins.add(new Comp(in.next() + " " + in.next(), in.nextFloat(), in.next()));

				////bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("a-tocoferol")){
				in = new Scanner(inputLine);
				f.vitamins.add(new Comp(in.next(), in.nextFloat(), in.next()));

				////bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Tiamina")){
				in = new Scanner(inputLine);
				////bw.write(in.next());
				f.vitamins.add(new Comp(in.next(), in.nextFloat(), in.next()));

				////bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Riboflavina")){
				in = new Scanner(inputLine);
				//bw.write(in.next());
				f.vitamins.add(new Comp(in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Equivalentes de niacina")){
				in = new Scanner(inputLine);
				//bw.write(in.next()+" "+in.next()+" "+in.next());
				f.vitamins.add(new Comp(in.next() + " " + in.next() + " " + in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Niacina")){
				in = new Scanner(inputLine);
				//bw.write(in.next());
				f.vitamins.add(new Comp(in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Folatos")){
				in = new Scanner(inputLine);
				//bw.write(in.next());
				f.vitamins.add(new Comp(in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}

			else if(inputLine.contains("Cinza")){
				in = new Scanner(inputLine);
				//bw.write(in.next());
				f.minerals.add(new Comp(in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Sódio")){
				in = new Scanner(inputLine);
				//bw.write(in.next()+" " +in.next());
				f.minerals.add(new Comp(in.next() + " " + in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Potássio")){
				in = new Scanner(inputLine);
				//bw.write(in.next()+" " +in.next());
				f.minerals.add(new Comp(in.next() + " " + in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Cálcio")){
				in = new Scanner(inputLine);
				//bw.write(in.next()+" "+in.next());
				f.minerals.add(new Comp(in.next() + " " + in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Fósforo")){
				in = new Scanner(inputLine);
				//bw.write(in.next()+" "+in.next());
				f.minerals.add(new Comp(in.next() + " " + in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Magnésio")){
				in = new Scanner(inputLine);
				//bw.write(in.next()+" "+in.next());
				f.minerals.add(new Comp(in.next() + " " + in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Ferro")){
				in = new Scanner(inputLine);
				//bw.write(in.next()+" "+in.next());
				f.minerals.add(new Comp(in.next() + " " + in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity+ "\n");
			}
			else if(inputLine.contains("Zinco")){
				in = new Scanner(inputLine);
				//bw.write(in.next()+" "+in.next());
				f.minerals.add(new Comp(in.next() + " " + in.next(), in.nextFloat(), in.next()));

				//bw.write("," + amount + " " + unity + "\n");
			}

			if(inputLine.contains("Legend_pt"))
				break;
		}
		f.removeAllEmptySubComps();
		i++;
		br.close();
		return f;
	}

}
