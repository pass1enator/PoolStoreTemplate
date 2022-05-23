# Project Base for a Vaadin application

This project can be used as a starting point to create your own Vaadin application.
It has the necessary dependencies and files to help you get started.
It requires Java 8 or newer and node.js 10.16 or newer.

To run the project, run `mvn jetty:run` and open [http://localhost:9999(http://localhost:9999) in browser.

To update to the latest available Vaadin release, issue `mvn 
versions:update-properties`

Some useful links:
- [Feature overview](https://vaadin.com/flow)
- [Documentation](https://vaadin.com/docs/flow/Overview.html)
- [Tutorials](https://vaadin.com/tutorials?q=tag:Flow) 
- [Component Java integrations and examples](https://vaadin.com/components)



# Infaces gráficas Web con Java

La tienda de piscinas ha decidido crear ya que tiene un almacen centralizado y diferentes tiendas en la provincia. Usando Vaadin crear una interfaz gráfica.
La aplicación ha de poder:
- Crear categorias.
- Listar categorias, en el listado la opción de borrar, editar y ver productos.
- Crear productos.
- Listar productos de una categoría y con las opciones de borrar y editar.
    
**En una aplicación real se realizaría una petición a un servidor y se obtendría los datos en formato XML o JSON. En este ejemplo se simular utilizado un método load de la clase aplicación, que simula la petición.**

Se facilita una clase controller que gestiona alguna de las funciones de la aplicación, en concreto:
    • Gestión de usuario (sólo se tiene 1) con un mecanísmo de seguridad muy rudimentario. (Se trata en profundidad en segundo curso).
    • Gestión de la tienda.
La clase implementa un patrón Singleton de forma que solo se tenga una instancia de la clase en toda la aplicación.
Java posee una serie de clases que permite trabajar con ficheros, en esta práctica se trabaja con estos tanto en formato binario, Json y XML, en especial estos dos últimos.
   

```Java
public class Controller {

    private static Controller instance;
    private String usuario, password;
    //aplicación sobre la que se hacen las operaciones
    private App aplicacion;
    private boolean islogin;
    static {
        instance = null;
    }

    private Controller() {
        this.usuario = "pedro";
        this.password = "pedro";
        this.aplicacion = new App();
        this.aplicacion.init();
        this.islogin = false;
    }

    //simular la peticion http
   /* private void load() {
        this.getAplicacion().init();
    }*/

    public boolean islogged() {
        return this.islogin;
    }
    /*no se hace el new, sino que se llama al método estático y siempre devuevle el mismo*/
    public static Controller getInstance() {
        if (Controller.instance == null) {
            Controller.instance = new Controller();
        }
        return Controller.instance;
    }
    //valida los usuarios
    public boolean validate(String user, String password) {
        if (this.usuario.equals(user) && this.password.equals(password)) {
            this.islogin = true;
            return true;
        }
        return false;
    }
    public App getAplicacion() {
        return aplicacion;
    }
    public void unloggin(){
        this.islogin=false;
    }
    public void setAplicacion(App aplicacion) {
        this.aplicacion = aplicacion;
    }
}
```
