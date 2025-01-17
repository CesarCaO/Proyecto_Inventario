
package Controlers;

import Views.MainMenu;
import Views.ViewCatalogoProducto;


public class MainMenuControler {
    private MainMenu mainMenu;

    public MainMenuControler(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        this.mainMenu.addCatProEventListener(e->openCatPro());
    }
    
    public void openCatPro(){
        ViewCatalogoProducto viewcatpro = new ViewCatalogoProducto();
        new CatalogoProductoControler(viewcatpro);//Aqui se inicializa el controlador lo que provoca que se llene la tabla
        this.mainMenu.setVisible(false);
        viewcatpro.setVisible(true);
        
    }
    
    }


    
    
    

