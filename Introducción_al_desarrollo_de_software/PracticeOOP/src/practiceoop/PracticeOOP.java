/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceoop;

import practiceoop.entity.Dictionary;
import practiceoop.entity.Menu;

/**
 *
 * @author niltonrodriguez
 */
public class PracticeOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Dictionary translate = new Dictionary();
        Menu menu = new Menu(translate);
        menu.run();
        
    }
    
}
