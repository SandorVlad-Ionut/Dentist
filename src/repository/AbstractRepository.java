package repository;
import domain.*;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRepository <T extends Identifiable<ID>,ID>{
    protected Map<ID, T> repo;

    public AbstractRepository() {
        repo=new HashMap<>();
    }


        public void add (T elem)
        {
            if (repo.containsKey( elem.getId()))
                throw new RuntimeException("Element already exists!!!”");
            else
                repo.put(elem.getId(), elem);
        }

        public void delete (T elem){
            if (repo.containsKey(elem.getId()))
                repo.remove(elem.getId());
        }

        public void update (T elem, ID id)
        {
            if (repo.containsKey(id))
                repo.put(elem.getId(), elem);
            else
                throw new RuntimeException("Element doesn’t exist");
        }

        public T findById (ID id)
        {
            if (repo.containsKey(id))
                return repo.get(id);
            else
                throw new RuntimeException("Element doesn't exist");
        }

        public Iterable<T> findAll () {
            return repo.values();
        }
    }
