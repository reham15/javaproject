package notebad;

import java.awt.Desktop;
import static java.awt.SystemColor.desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class noteBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem menuItem;
    protected final MenuItem menuItem0;
    protected final MenuItem menuItem1;
    protected final MenuItem menuItem2;
    protected final Menu menu0;
    protected final MenuItem menuItem3;
    protected final MenuItem menuItem4;
    protected final MenuItem menuItem5;
    protected final MenuItem menuItem6;
    protected final MenuItem menuItem7;
    protected final MenuItem menuItem8;
    protected final Menu menu1;
    protected final MenuItem menuItem9;
    protected final TextArea textArea;
   protected Stage stage=new Stage();

    public noteBase( Stage stage) {
   this.stage=stage;
        menuBar = new MenuBar();
        menu = new Menu();
        menuItem = new MenuItem();
        menuItem0 = new MenuItem();
        menuItem1 = new MenuItem();
        menuItem2 = new MenuItem();
        menu0 = new Menu();
        menuItem3 = new MenuItem();
        menuItem4 = new MenuItem();
        menuItem5 = new MenuItem();
        menuItem6 = new MenuItem();
        menuItem7 = new MenuItem();
        menuItem8 = new MenuItem();
        menu1 = new Menu();
        menuItem9 = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        menu.setMnemonicParsing(false);
        menu.setText("File");

        menuItem.setMnemonicParsing(false);
        menuItem.setText("New");
        menuItem.setOnAction(new EventHandler <ActionEvent>() {
            
            public void handle(ActionEvent e) {
            newFile();
            }
        });
        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("Open");
       menuItem0.setOnAction(new EventHandler <ActionEvent>() {
            
            public void handle(ActionEvent e) {
                try {
                    openFile();
                } catch (IOException ex) {
                    Logger.getLogger(noteBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("Save");
     menuItem1.setOnAction(new EventHandler <ActionEvent>() {
            
            public void handle(ActionEvent e) {
               saveFile();
            }
        });
        menuItem2.setMnemonicParsing(false);
        menuItem2.setText("Exit");
        menuItem2.setOnAction(new EventHandler <ActionEvent>() {
            
            public void handle(ActionEvent e) {
               exitFile();
            }
        });
        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");
      
        menuItem3.setMnemonicParsing(false);
        menuItem3.setText("Undo");
        menuItem3.setOnAction(new EventHandler <ActionEvent>() {
            
            public void handle(ActionEvent e) {
               textArea.undo();
            }
        });
        menuItem4.setMnemonicParsing(false);
        menuItem4.setText("Cut");
         menuItem4.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
       menuItem4.setOnAction(new EventHandler <ActionEvent>() {
           
            public void handle(ActionEvent e) {
                 textArea.cut();                 
            }
        });
        menuItem5.setMnemonicParsing(false);
         menuItem5.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        menuItem5.setText("Copy");
        menuItem5.setOnAction(new EventHandler <ActionEvent>() {
            
            public void handle(ActionEvent e) {
               textArea.copy(); 
            }
        });
        menuItem6.setMnemonicParsing(false);
        menuItem6.setText("Paste");
         menuItem6.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        menuItem6.setOnAction((ActionEvent e) -> {
            textArea.paste();
   });
        menuItem7.setMnemonicParsing(false);
        menuItem7.setText("Delete");
        menuItem7.setOnAction(new EventHandler <ActionEvent>() {
            
            public void handle(ActionEvent e) {
               textArea.replaceSelection("");
            }
        });
        menuItem8.setMnemonicParsing(false);
        menuItem8.setText("Select All");
      menuItem8.setOnAction(new EventHandler <ActionEvent>() {
            
            public void handle(ActionEvent e) {
               textArea.selectAll();
            }
        });
        menu1.setMnemonicParsing(false);
        menu1.setText("Help");

        menuItem9.setMnemonicParsing(false);
        menuItem9.setText("About Notepad");
        menuItem9.setOnAction(new EventHandler <ActionEvent>() {
            
            public void handle(ActionEvent e) {
               Alert help=new Alert(AlertType.INFORMATION,"created by reham");
               help.show();
            } 
            
        });
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        menu.getItems().add(menuItem);
        menu.getItems().add(menuItem0);
        menu.getItems().add(menuItem1);
        menu.getItems().add(menuItem2);
        menuBar.getMenus().add(menu);
        menu0.getItems().add(menuItem3);
        menu0.getItems().add(menuItem4);
        menu0.getItems().add(menuItem5);
        menu0.getItems().add(menuItem6);
        menu0.getItems().add(menuItem7);
        menu0.getItems().add(menuItem8);
        menuBar.getMenus().add(menu0);
        menu1.getItems().add(menuItem9);
        menuBar.getMenus().add(menu1);

    }
   void openFile() throws IOException 
   {
   
   
   FileChooser chooser =new  FileChooser();
   File file=chooser.showOpenDialog(stage);
          
           if(file!=null)
           { try{ FileInputStream f = new FileInputStream(file.getPath());
              int size = f.available();
              byte b[] = new byte[size];
              f.read(b);
              textArea.setText(""); 
              textArea.appendText(new String(b));
              f.close();}
             
           catch(Exception e1)
           {}
            
        }
   }
           
           
 void saveFile()
 {
  FileChooser chooser =new  FileChooser();
   File file=chooser.showSaveDialog(stage);
          
           if(file!=null)
           { try{ FileOutputStream f = new FileOutputStream(file.getPath());
              
               byte b[] = textArea.getText().getBytes();
                f.write(b);
               
               stage.setTitle(file.getName());
              
              f.close();}
             
           catch(Exception e1)
           {}
            
        }
 
 
 
 }
      
 void newFile()
 {
  
            
    
 textArea.clear();
 
 Parent root=new noteBase(stage);
 stage.setTitle("untitled");
 
 }   
    
 void exitFile()
          {
          
          stage.close();
          Platform.exit();
          }
    
}
