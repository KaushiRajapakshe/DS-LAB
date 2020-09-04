/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.ArrayList;
import java.util.Collections;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author user
 */
@Singleton
@LocalBean
@WebListener
public class SessionManagerBean implements HttpSessionListener {

    private static int counter = 0;

    ArrayList<String> list=new ArrayList<String>();

    public void sessionCreated(HttpSessionEvent se) {
        counter++;
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        counter--;
    }

    public int getActiveSessionsCount() {
        return counter;
    }

    public ArrayList<String>  findAllSortedDesc(){
      Collections.sort(list,Collections.reverseOrder());
      return list;
    }
    
 
}
