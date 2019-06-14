import java.io.*;
import java.util.Scanner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class Driver {

	public static void main(String[] args) throws IOException {       
		//read file line by line in Java using Scanner
		FileInputStream fis = new FileInputStream("breastCancerDataReducedDimensions.csv");
		Scanner scanner = new Scanner(fis);

		//Map for each attribute
		HashMap<String, String> radius = new HashMap<>();
		HashMap<String, String> texture = new HashMap<>();
		HashMap<String, String> perimeter = new HashMap<>();
		HashMap<String, String> area = new HashMap<>();

		//FOS for each File
		FileOutputStream q3_gte_13 = new FileOutputStream("q3_gte_13.csv");
		FileOutputStream q4_gte_18 = new FileOutputStream("q4_gte_18.csv");
		FileOutputStream q5_gte_85 = new FileOutputStream("q5_gte_85.csv");
		FileOutputStream q6_gte_500 = new FileOutputStream("q6_gte_500.csv");
		FileOutputStream NewResult = new FileOutputStream("NewResult.csv");
		/***
		 * There are 5 columns
		 ***/
		while(scanner.hasNextLine()){
			//System.out.println(scanner.nextLine());
			scanner.nextLine();
			String[] arr = scanner.nextLine().split(",");
			for (int i = 0; i < arr.length; i++) {
				//patientID = Integer.parseInt(arr[0]);
				//patientVal = Double.parseDouble(arr[i]);

				//If statements to add patient to each Map if the relevant data passes the respective threshold
				if (i == 2 && Double.parseDouble(arr[i]) >= 13) {
					String r = arr[0] + "," + arr[1] + "," + arr[i];
					byte[] b = r.getBytes();
					q3_gte_13.write(b);
					q3_gte_13.write("\n".getBytes());
					radius.put(arr[0], arr[i]);	
				}

				if (i == 3 && Double.parseDouble(arr[i]) >= 18) {
					String t = arr[0] + "," + arr[1] + "," + arr[i];
					byte[] b = t.getBytes();
					q4_gte_18.write(b);
					q4_gte_18.write("\n".getBytes());
					texture.put(arr[0], arr[i]);
				}

				if (i == 4 && Double.parseDouble(arr[i]) >= 85) {
					String p = arr[0] + "," + arr[1] + "," + arr[i];
					byte[] b = p.getBytes();
					q5_gte_85.write(b);
					q5_gte_85.write("\n".getBytes());
					perimeter.put(arr[0], arr[i]);

				}

				if (i == 5 && Double.parseDouble(arr[i]) >= 500) {
					String a = arr[0] + "," + arr[1] + "," + arr[i];
					byte[] b = a.getBytes();
					q6_gte_500.write(b);
					q6_gte_500.write("\n".getBytes());
					area.put(arr[0], arr[i]);	
				}
				if(radius.containsKey(arr[0]) && texture.containsKey(arr[0]) && perimeter.containsKey(arr[0]) && area.containsKey(arr[0])) {
					String s = arr[0];
					byte[] b = s.getBytes();
					NewResult.write(b);
					NewResult.write("\n".getBytes());
				}
			}
		}

		//Creating second set of files
		FileInputStream q3 = new FileInputStream("q3_gte_13.csv");
		FileInputStream q4 = new FileInputStream("q4_gte_18.csv");
		FileInputStream q5 = new FileInputStream("q5_gte_85.csv");
		FileInputStream q6 = new FileInputStream("q6_gte_500.csv");


		FileOutputStream q3_M = new FileOutputStream("q3_M.csv");
		FileOutputStream q4_M = new FileOutputStream("q4_M.csv");
		FileOutputStream q5_M = new FileOutputStream("q5_M.csv");
		FileOutputStream q6_M = new FileOutputStream("q6_M.csv");

		Scanner scQ3 = new Scanner(q3);
		Scanner scQ4 = new Scanner(q4);
		Scanner scQ5 = new Scanner(q5);
		Scanner scQ6 = new Scanner(q6);

		//Q3
		while(scQ3.hasNextLine()){
			//System.out.println(scanner.nextLine());
			String[] arrQ3 = scQ3.nextLine().split(",");
			for (int i = 0; i < arrQ3.length; i++) {
				if(arrQ3[1].equals("M")) {
					String s = arrQ3[0];
					byte[] b = s.getBytes();
					q3_M.write(b);
					q3_M.write("\n".getBytes());
				}
			}
		}
		scQ3.close();
		q3.close();
		q3_M.close();
		//Q4
		while(scQ4.hasNextLine()){
			//System.out.println(scanner.nextLine());
			String[] arrQ4 = scQ4.nextLine().split(",");
			for (int i = 0; i < arrQ4.length; i++) {
				if(arrQ4[1].equals("M")) {
					String s = arrQ4[0];
					byte[] b = s.getBytes();
					q4_M.write(b);
					q4_M.write("\n".getBytes());
				}
			}
		}
		scQ4.close();
		q4.close();
		q4_M.close();
		//Q5
		while(scQ5.hasNextLine()){
			//System.out.println(scanner.nextLine());
			String[] arrQ5 = scQ5.nextLine().split(",");
			for (int i = 0; i < arrQ5.length; i++) {
				if(arrQ5[1].equals("M")) {
					String s = arrQ5[0];
					byte[] b = s.getBytes();
					q5_M.write(b);
					q5_M.write("\n".getBytes());
				}
			}
		}
		scQ5.close();
		q5.close();
		q5_M.close();
		//Q6
		while(scQ6.hasNextLine()){
			//System.out.println(scanner.nextLine());
			String[] arrQ6 = scQ6.nextLine().split(",");
			for (int i = 0; i < arrQ6.length; i++) {
				if(arrQ6[1].equals("M")) {
					String s = arrQ6[0];
					byte[] b = s.getBytes();
					q6_M.write(b);
					q6_M.write("\n".getBytes());
				}
			}
		}
		scQ6.close();
		q6.close();
		q6_M.close();

		//Creating the Diagnosis files
		FileInputStream M_3 = new FileInputStream("q3_M.csv");
		FileInputStream M_4 = new FileInputStream("q4_M.csv");
		FileInputStream M_5 = new FileInputStream("q5_M.csv");
		FileInputStream M_6 = new FileInputStream("q6_M.csv");

		Scanner New3 = new Scanner(M_3);
		Scanner New4 = new Scanner(M_4);
		Scanner New5 = new Scanner(M_5);
		Scanner New6 = new Scanner(M_6);

		FileOutputStream SubsetMResult = new FileOutputStream("SubsetMResult.csv");

		HashSet<String> Q3 = new HashSet<>();
		HashSet<String> resultQ4 = new HashSet<>();
		HashSet<String> resultQ5 = new HashSet<>();
		HashSet<String> resultLast = new HashSet<>();


		while(New3.hasNextLine()){
			Q3.add(New3.nextLine());
		}

		while(New4.hasNextLine()) {
			String line = New4.nextLine();
			if(Q3.contains(line)) {
				resultQ4.add(line);
			}
		}
		while(New5.hasNextLine()) {
			String line = New5.nextLine();
			if(resultQ4.contains(line)) {
				resultQ5.add(line);
			}
		}
		while(New6.hasNextLine()) {
			String line = New6.nextLine();
			if(Q3.contains(line)) {
				String s = line;
				byte[] b = s.getBytes();
				SubsetMResult.write(b);
				SubsetMResult.write("\n".getBytes());
			}
		}
		
		//Creating the comparison files
		FileInputStream Subset = new FileInputStream("SubsetMResult.csv");
		FileInputStream Result = new FileInputStream("NewResult.csv");
		
		Scanner sc1 = new Scanner(Subset);
		Scanner sc2 = new Scanner(Result);
		
		FileOutputStream Difference_1 = new FileOutputStream("Difference_1.csv");
		while(sc1.hasNextLine() && sc2.hasNextLine()) {
			String id = sc1.nextLine();
			String[] resID = sc2.nextLine().split(",");
			for (int i = 0; i < resID.length; i++) {
				if(id.equals(resID[i])) {
					String s = id;
					byte[] b = s.getBytes();
					Difference_1.write(b);
				}
			}
		}
			
			




		NewResult.close();
		System.out.println("closed");
	}
}