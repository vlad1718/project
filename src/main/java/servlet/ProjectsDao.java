package servlet;

import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.10.2015.
 */
public class ProjectsDao {
    HibernateTemplate template;
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public void saveProjects(Projects p){
        template.save(p);
    }

    public void updateProjects(Projects p){
        template.update(p);
    }
    public List<Projects> getProjects(){
        List<Projects> list=new ArrayList<Projects>();
        list=template.loadAll(Projects.class);
        return list;
    }
}
