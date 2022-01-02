package repository;
import domain.*;

public class AppointmentRepository extends AbstractRepository<Appointment,Integer>
{
public AppointmentRepository(){};



    public void manyProblem(String problem) {
        int many=0;
        for (Appointment el:findAll())
        {
            if (el.getProblem()==problem)
            {
                many++;
            }
        }

        String x="There are "+many+" people coming to the dentist for "+problem;
        System.out.println(x);

    }
}

