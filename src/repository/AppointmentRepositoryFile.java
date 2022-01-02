package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.io.*;
import java.util.*;

import domain.Appointment;
import exceptions.RepositoryException;
import domain.Appointment;

public class AppointmentRepositoryFile extends AbstractRepository<Appointment, Integer> {
    private String filename;
    private AppointmentRepositoryFile reqRepository;

    public AppointmentRepositoryFile(String filename, AppointmentRepositoryFile reqRepo) {
        this.filename = filename;
        this.reqRepository = reqRepo;//new RequestRepositoryFile("D:\\laboratoare_licenta\\MAP\\sem3-822\\Sem3\\src\\requests.txt");
        readFromFile();
    }

    public AppointmentRepositoryFile(String filename) {
    }

    private void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] el = line.split(";");
                if (el.length != 2) {System.err.println("Not a valid number of atributes" + line);
                    continue;
                }
                try {

                    String[] userArray = line.split(",");
                    int Id=  Integer.valueOf(userArray[0]);
                    String problem=userArray[1];
                    Appointment c = new Appointment(Id, problem);
                    super.add(c);

                } catch (NumberFormatException n) {
                    System.err.println("The ID is not a valid number" + el[0]);
                }
            }
        } catch (IOException ex) {
            throw new RepositoryException("Error reading" + ex);
        }
    }

    @Override
    public void add(Appointment obj) {
        try {
            super.add(obj);
            writeToFile();
        } catch (RuntimeException e) {
            throw new RepositoryException("Object wasn t added" + e + " "+obj);
        }
    }

    private void writeToFile() {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (Appointment el : findAll()) {
                String line = el.getPatientId() + ";"+el.getProblem() ;

                pw.println(line);
            }
        } catch (IOException ex) {
            throw new RepositoryException("Error writing" + ex);
        }
    }

    @Override
    public void delete(Appointment obj) {
        try {
            super.delete(obj);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not deleted" + ex +" "+obj);
        }
    }

    @Override
    public void update(Appointment obj, Integer id) {
        try {
            super.update(obj, id);
            writeToFile();
        } catch (RuntimeException ex) {
            throw new RepositoryException("Object was not updated" + ex + " "+obj);
        }
    }

    public void lab6()

    {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("App.properties"));
            String requestFileName = properties.getProperty("RequestsFile");

            if (requestFileName == null) {
                requestFileName = "AppointmentRepository.txt";
                System.err.println("Requests file not found. Using default" + requestFileName);
            }
            String formsFileName = properties.getProperty("FormsFile");

            if (formsFileName == null) {
                formsFileName = "RepairedForms.txt";
                System.err.println("RepairedForms file not found. Using default" + formsFileName);
            }
            AppointmentRepositoryFile crrRepo = new AppointmentRepositoryFile(requestFileName);
            AppointmentRepositoryFile crfRepo = new AppointmentRepositoryFile(formsFileName, crrRepo);
        } catch
        (
                IOException ex) {
            System.err.println("Error reading the configuration file" + ex);
        }

    }
}