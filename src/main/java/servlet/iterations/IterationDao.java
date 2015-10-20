package servlet.iterations;


import java.util.List;

/**
 * Created by User on 19.10.2015.
 */
public interface IterationDao {

    public void insert(Iterations iter);
    public List<Iterations> findIter(int n);
    public List<Iterations> findAll();
}
