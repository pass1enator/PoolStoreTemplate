package pedro.ieslaencanta.com.poolstoretemplate;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import pedro.ieslaencanta.com.poolstoretemplate.category.CategoriesView;

/**
 * The main view contains a button and a click listener.
 */
@Route
public class MainView extends  AppLayout implements BeforeEnterObserver {

    public MainView()  {
        createHeader();
        //menu de opciones
        createDrawer();

    }

    private void createHeader() {
        H1 logo = new H1("PooStore");
        logo.addClassNames("text-l", "m-m");
        Image i = new Image("images/pool.png", "logo");
        HorizontalLayout header = new HorizontalLayout(
                new DrawerToggle(),
                i,
                logo
        );

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);

    }

    private void createDrawer() {
        RouterLink categoryLink = new RouterLink("Categorias", CategoriesView.class);
        addToDrawer(new VerticalLayout(
                categoryLink
              
        ));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent bee) {
       //validar que se tiene permiso
       
    }
}
