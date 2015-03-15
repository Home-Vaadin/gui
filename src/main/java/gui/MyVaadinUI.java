package gui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import javax.servlet.annotation.WebServlet;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    public VerticalLayout tab1;
    public VerticalLayout tab2;
    public VerticalLayout tab3;
    public VerticalLayout tab4;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "gui.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        Button button = new Button("Create");
        Button button2 = new Button("Thank You!");
        Table table = new Table("My First Table.");
        TabSheet tabsheet = new TabSheet();
        tab1 = new VerticalLayout();
        tab2 = new VerticalLayout();
        tab3 = new VerticalLayout();
        tab4 = new VerticalLayout();

        // Define two columns for the built-in container
        table.addContainerProperty("Username", String.class, null);
//        table.addContainerProperty("Mag",  Float.class, null);
        table.addContainerProperty("Ldap", String.class, null);
        table.addContainerProperty("Fullname", String.class, null);
        table.addContainerProperty("ip", String.class, null);
        table.addContainerProperty("Data create", String.class, null);
        table.addContainerProperty("Data update", String.class, null);
        table.addContainerProperty("Last ip", String.class, null);
//        // Add a row the hard way
//        Object newItemId = table.addItem();
//        Item row1 = table.getItem(newItemId);
//        row1.getItemProperty("Name").setValue("Sirius");
//        row1.getItemProperty("Mag").setValue(-1.46f);
        // Add a few other rows using shorthand addItem()
//        table.addItem(new Object[]{"Sirius",         -1.46f}, 1);
        table.addItem(new Object[]{"dima", "dn2013ban", "Belyu Dmity Nikolaevitch", "10.13.71.11", "13.03.2014", "03.01.2015", "10.13.71.11"}, 1);
        table.addItem(new Object[]{"roma", "dn2000aan", "Klichko Roman Nikolaevitch", "10.13.71.12", "01.03.2014", "03.05.2014", "10.13.71.12"}, 2);
        table.addItem(new Object[]{"diver", "dn2000vsn", "Velikotsky Vyacheslav Nikolaevitch", "10.13.71.14", "01.07.2014", "", ""}, 3);
        table.addItem(new Object[]{"dn200078lak", "dn200078lak", "Lazarchuk Alexandr Nikolaevitch", "10.13.71.15", "01.01.2014", "02.05.2014", "10.13.71.15"}, 4);
        table.addItem(new Object[]{"dn1013bav", "dn1013bav", "Belousov Artur Nikolaevitch", "10.13.71.16", "02.01.2014", "", ""}, 5);
        table.setPageLength(15); // Show 15 rows
        // Must be immediate to send the resize events immediately
        table.setImmediate(true);
        // Enable the footer
        table.setFooterVisible(true);
        // Give plenty of width
        table.setWidth("800px");


        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                tab1.addComponent(new Label("Thank you for clicking"));
//                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        button2.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                showNotification("Thank You!");
            }
        });

        // Create the first tab
        tab1.addComponent(button);
        tab1.addComponent(button2);
        // Second tab gets its caption from component caption
        tab3.addComponent(table);
//        tab2.setCaption("Venus");
        tab4.addComponent(new Embedded(null, new ThemeResource("img/mailarchiver_logo.png")));

        tabsheet.addTab(tab1, "Create", new ThemeResource("icons/48/test.png"));
        tabsheet.addTab(tab2, "Edit", new ThemeResource("icons/48/config.png"));
        tabsheet.addTab(tab3, "Search", new ThemeResource("icons/48/search.png"));
        tabsheet.addTab(tab4, "Help", new ThemeResource("icons/48/help.png"));
//        tabsheet.addTab(tab2).setIcon(new ThemeResource("icons/48/test.png"));
        layout.addComponent(tabsheet);
    }

}
