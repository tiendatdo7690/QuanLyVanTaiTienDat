package com.tiendat.demo.NodeService;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TabPaneService {

	public TabPaneService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void addTab(ConfigurableApplicationContext springContext, TabPane tabpane, TabService tabservice, String tenfilefx, Object e) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Tab tab = tabservice.getTab();
		
		if(tabservice.isKt()) {
					
					System.out.println("tao tab moi");
//					int vitri = tabpane.getTabs().size();
//					tabservice.setVitri(vitri);
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(tenfilefx));
			        fxmlLoader.setControllerFactory(springContext::getBean);
					 Node root = fxmlLoader.load();
					Method method = fxmlLoader.getController().getClass().getMethod("LamMoi",null);
					method.invoke(e, null);
					 AnchorPane a = new AnchorPane();
				     a.getChildren().add(root);
				     AnchorPane.setRightAnchor(root, 0.0);
				     AnchorPane.setLeftAnchor(root, 0.0);
				     AnchorPane.setBottomAnchor(root, 0.0);
				     AnchorPane.setTopAnchor(root, 0.0);				   
					 tab.setContent(a);

					 //tabservice.getTab().setContent(root);
					
					 tabpane.getTabs().add(tab);
						 
					 tabpane.getSelectionModel().select(tab);
						 
				tabservice.setKt(false);
			}
			else {
				System.out.println("tao tab cu");
				tabpane.getSelectionModel().select(tab);
		}
	}
}
