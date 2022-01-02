package repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import domain.Appointment;
import repository.AbstractRepository;
import exceptions.RepositoryException;

public class AppointmentRepositorySerialization extends AbstractRepository<Appointment, Integer>
{
    private String filename;
    private AppointmentRepositorySerialization reqRepository;

    public AppointmentRepositorySerialization(String filename, AppointmentRepositorySerialization reqRepository)
    {
        this.filename = filename;
        this.reqRepository = reqRepository;
//        readFromFile();
    }

    public AppointmentRepositorySerialization(String filename) {
    }


    private void writeToFile(){
        try(ObjectOutputStream e=new ObjectOutputStream(new FileOutputStream(filename)))
        {
            e.writeObject(repo);
        }
        catch(IOException r){
            throw new RepositoryException("message " + r);
        }
    }


    private void readFromFile ()
    {
        try(ObjectInputStream in= new ObjectInputStream (new FileInputStream(filename)))
        {
            repo = (Map<Integer, Appointment>) in.readObject();
        }
        catch(IOException|ClassNotFoundException err)
        {
            throw new RepositoryException("Error reading from file: "+err);
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


}