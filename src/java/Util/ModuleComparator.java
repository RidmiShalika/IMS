/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import login.bean.TaskBean;
import java.util.Comparator;

/**
 *
 * @author kreshan
 */
public class ModuleComparator implements Comparator<TaskBean>{
    
        public int compare(TaskBean _first, TaskBean _second) {
            return _first.getTASK_ID().compareTo(_second.getTASK_ID());
    }

   

}
