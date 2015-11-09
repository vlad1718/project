package servlet.DAO;


import servlet.iterations.Iteration;

import java.util.List;

/**
 * Created by vl_gr on 19.10.2015.
 */
public interface IterationDao {

    void insert(Iteration iter);

    List findIter(int pr_id);

    List findThisIter(int n);

    void del(int list);

    List<Iteration> findAll();

}
