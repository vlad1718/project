package servlet.iterations;


import java.util.List;

/**
 * Created by User on 19.10.2015.
 */
public interface IterationDao {

    void insert(Iteration iter);
    List<Iteration> findIter(int n);
    List<Iteration> findAll();
    List findThisIter(int n);
    void del(int list);
}
