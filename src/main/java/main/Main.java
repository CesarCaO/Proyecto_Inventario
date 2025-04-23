
package main;

import Views.ViewLogin;




public class Main {
    
    public static void main(String [] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new ViewLogin().setVisible(true);
            }
        });
    }
}
