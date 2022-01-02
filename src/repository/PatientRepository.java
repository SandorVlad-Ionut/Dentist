package repository;
import domain.*;

public class PatientRepository extends AbstractRepository<Patient, Integer> {
    public PatientRepository() {
    }

    public void oldest()
    {
        int max=0;
        Patient Old=new Patient();
        for (Patient el:findAll())
        {
            if (el.getAge()>max)
            {
                Old=el;
                max=el.getAge();
            }
        }
        System.out.println("The oldest patient is "+Old);

    }


}