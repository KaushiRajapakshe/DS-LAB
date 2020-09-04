/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author user
 */
@Stateless
public class NewsEntityFacade {
    @PersistenceContext(unitName = "NewsApp-ejbPU")
    private EntityManager em;

    public void create(NewsEntity newsEntity) {
        em.persist(newsEntity);
    }

    public void edit(NewsEntity newsEntity) {
        em.merge(newsEntity);
    }

    public void remove(NewsEntity newsEntity) {
        em.remove(em.merge(newsEntity));
    }

    public NewsEntity find(Object id) {
        return em.find(NewsEntity.class, id);
    }

    public List<NewsEntity> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(NewsEntity.class));
        return em.createQuery(cq).getResultList();
    }

    public List<NewsEntity> findAllSortedDesc(){
        
        List newsList=new ArrayList();
        
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(NewsEntity.class));
        
        newsList=em.createQuery(cq).getResultList();
        
        Collections.sort(newsList,new CompareDates());
      
        return newsList;    
    }

    public List<NewsEntity> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(NewsEntity.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<NewsEntity> rt = cq.from(NewsEntity.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @PostConstruct
    public void print(){
        System.out.print("Hi Im PostConstructor");
    }
    
    
    public class CompareDates implements Comparator<NewsEntity>{

        public int compare(NewsEntity o1, NewsEntity o2) {
            if(o1.dateTime.compareTo(o2.dateTime)>0){
                return -1;
            }       
            else{
                return 1; 
            }
                
        }
        
    }

}
