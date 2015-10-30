package servlet.iterations;


import java.util.List;

/**
 * Created by User on 19.10.2015.
 */
public interface IterationDao {

    void insert(Iterations iter);
    List<Iterations> findIter(int n);
    List<Iterations> findAll();
    List findThisIter(int n);
    void del(int list);
}
