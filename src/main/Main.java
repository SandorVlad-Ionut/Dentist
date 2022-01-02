package main;
import java.util.*;
import domain.*;
import exceptions.RepositoryException;
import repository.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		PatientRepository test = new PatientRepository();
		test.add(new Patient(12, "alex pop", 41));
		test.add(new Patient(14, "ion salagean", 52));
		test.add(new Patient(4, "luiza matei", 16));
		test.add(new Patient(234, "maria popescu", 10));
		test.add(new Patient(43, "dorina ardelean", 38));

		for (Patient el : test.findAll()) {
			System.out.println(el);
		}

		System.out.println("-------------");

		test.delete(test.findById(4));
		for (Patient el : test.findAll()) {
			System.out.println(el);
		}

		System.out.println("-------------");
		test.oldest();
	}




		/*AppointmentRepositoryFile file = new AppointmentRepositoryFile("D:\\Users\\sando\\IdeaProjects\\file2.txt");

		file.add(new Appointment(41,"albire"));
		file.add(new Appointment(22,"plomba"));
		for(Appointment elem:file.findAll()){
			System.out.println(elem);
		}

		System.out.println("After delete");
		file.delete(file.findById(12));
		for(Appointment elem:file.findAll()){
			System.out.println(elem);
		}

        AppointmentRepositorySerialization fileRepoS = new AppointmentRepositorySerialization("D:\\Users\\sando\\IdeaProjects\\file3.txt");
        for(Appointment el: fileRepoS.findAll())
            System.out.println(el);

        AppointmentRepositorySerialization formRepoS = new AppointmentRepositorySerialization("D:\\Users\\sando\\IdeaProjects\\file4.txt", fileRepoS);
        formRepoS.add(new Appointment(1,"plomba"));
        formRepoS.add(new Appointment(2, "albire"));
        for(Appointment el: formRepoS.findAll())
            System.out.println(el);
    }

		 */


}
