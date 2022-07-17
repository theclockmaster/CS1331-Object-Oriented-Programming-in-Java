import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Clinic {
	private File patientFile;
	private int day;
	
	public Clinic(File file) {
		this.patientFile = file;
		this.day = 1;
	}
	
	public Clinic(String fileName) {
		this.patientFile = new File(fileName);
	}
	
	public String nextDay(File f) throws FileNotFoundException{
		Scanner appointments = new Scanner(f);
		Scanner user = new Scanner(System.in);
		String summary = "";
		while (appointments.hasNextLine()) {
			String[] arrOfAppointments = appointments.nextLine().split(",");
			String name = arrOfAppointments[0];
			String type = arrOfAppointments[1];
			String petProp = arrOfAppointments[2]; //droolRate or MiceCaught
			String time = arrOfAppointments[3];
			
			if (type.equals("Cat") || !type.equals("Dog")) { //if not cat or not dog, close scanner & throw invalid pet.
				appointments.close();
				throw new InvalidPetException();
			}
			System.out.printf("Consultation for %s the %s at %s.\n", name, type, time);
			System.out.printf("What is the health of %s.\n", name);
			double health=0.0;
			boolean isDone = false;
			while(!isDone) {
				if(user.hasNextDouble()) {
					health = user.nextDouble();
					isDone = true;
				}
				else {
					System.out.println("Please enter a number");
				}
			}
			System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?", name);
			int painLevel=0;
			isDone=false;
			while(!isDone) {
				if(user.hasNextInt()) {
					painLevel = user.nextInt();
					isDone = true;
				}
				else {
					System.out.println("Please enter a number");
				}
			}
			Pet patient;
			if (type.equals("Dog")) {
				patient = new Dog(name, health, painLevel, Double.parseDouble(petProp));
			}
			else {
				patient = new Cat(name, health, painLevel, Integer.parseInt(petProp));
			}
			patient.speak();

			summary = String.format("%s,%s,%s,%s,%s,%s,%s,%d\n", name, type, petProp,"Day " + this.day, time, 
					addTime(time, patient.treat()), String.format("%.2f", health), painLevel);
		}
		appointments.close();
		user.close();
		this.day++;
		return summary;
	}
	
    public String addTime(String timeIn, int treatmentTime) {
        int m = Integer.parseInt(timeIn.substring(2, 4)) + treatmentTime % 60;
        int h = Integer.parseInt(timeIn.substring(0, 2)) + treatmentTime / 60 + m / 60;
        m = m % 60;
        return String.format("%02d%02d", h, m);
    }
	
    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }
    
    public boolean addToFile(String patientInfo) {
        String[] info = patientInfo.split(",");
        String name = info[0];
        String update = String.format(",%s,%s,%s,%s,%s", info[3], info[4], info[5], info[6], info[7]);
        String patients = "";
        boolean returningPatient = false;
        try (Scanner user = new Scanner(patientFile)) {
            while (user.hasNextLine()) {
                String pInfo = user.nextLine();
                if (name.equals(pInfo.split(",")[0])) {
                    returningPatient = true;
                    patients += pInfo + update + "\n";
                } else {
                    patients += pInfo + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        patients = returningPatient ? patients : patients + patientInfo + "\n";
        try (PrintWriter insert = new PrintWriter(patientFile)) {
            insert.write(patients);
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
        
    }
	

	
	
	
}