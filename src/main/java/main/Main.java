
package main;

import Controlers.MainMenuControler;
import Views.MainMenu;


public class Main {
    public static void main(String [] args){
        java.awt.EventQueue.invokeLater(()->{
            System.out.print("Iniciando sistema");
            MainMenu mainMenu=new MainMenu();
            MainMenuControler mainControler = new MainMenuControler(mainMenu);
            mainMenu.setVisible(true);
        }
        );
    }
    
}
