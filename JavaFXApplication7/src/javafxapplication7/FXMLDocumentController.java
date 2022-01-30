/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

/**
 *
 * @author elkrnk 1
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> colUsername;
    @FXML
    private TableColumn<User, String> colScore;
    @FXML
    private TableColumn<User, String> colStatus;
    @FXML
    private TableColumn<User, String> colRequest;
    ObservableList<User> userList=FXCollections.observableArrayList();
   /* private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //  DataBase d=new DataBase();
       // Client ui = new Client();
       /* try {
            //userList= ui.obeerveList();
           // for(int i=0;i<userList.size();i++)
                       
                 
                  // {
                   
                    //System.out.println(userList.get(i).getUserName());
                  // }
                     
            userList = d.selectusers( );
        } catch (SQLException ex) {
           // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    tableView.setItems(userList);
    colUsername.setCellValueFactory(new PropertyValueFactory<>("userName"));
   colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    Callback<TableColumn<User, String>, TableCell<User, String>> cellFoctory = (TableColumn<User, String> param) -> {
            // make cell containing buttons
            final TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        //setGraphic(null);
                        //setText(null);

                    } else {
                        Button bt1=new Button() ; 
                        bt1.setText("   send   ");
                        //FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        
                  
                        
                        
                        
                       

                        HBox managebtn = new HBox(bt1);  
                        managebtn.setStyle("-fx-color:green");                    
                        setGraphic(managebtn);

                       
                      bt1.setOnAction((ActionEvent event) -> {
                        /*TablePosition pos = (TablePosition) tableView.getSelectionModel().getSelectedCells();
                        int index= pos.getRow();
                         Item item = table.getItems().get(index);
                       // TableColumn col=pos.getTableColumn();
                        TableColumn col =tableView .getColumns().get(3);
                        String data = (String) col.getCellObservableValue(item).getValue();*/
                                
                       /* User u=getTableView().getItems().get(getIndex());
                          String s=u.getStatus();
                          
                        if( s.equals("offline")  )
                           //System.out.println(u.getUserName());    
                        { managebtn.setStyle("-fx-color:red");
                        Alert error=new Alert(Alert.AlertType.ERROR,u.getUserName()+ "is offline ");
                            error.show();}
                         else
                          {
                             System.out.println(u.getUserName());  
                        } 
                            
                           

                        });
                        

                    }
                }

            };

            return cell;
        };
         colRequest.setCellFactory(cellFoctory);
         tableView.setItems(userList);*/
         
         
    }
  void hello()
   {
   
    
    System.out.println("hello");  
   
   
    }
  
 void loadUsers( ObservableList<User> userList)
   {
   
    
   // try {
            
           // for(int i=0;i<userList.size();i++)
                       
                 
                  // {
                   
                    //System.out.println(userList.get(i).getUserName());
                  // }
                     
           
        //} catch (SQLException ex) {
           // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        //}
    
    tableView.setItems(userList);
    colUsername.setCellValueFactory(new PropertyValueFactory<>("userName"));
   colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    Callback<TableColumn<User, String>, TableCell<User, String>> cellFoctory = (TableColumn<User, String> param) -> {
            // make cell containing buttons
            final TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        //setGraphic(null);
                        //setText(null);

                    } else {
                        Button bt1=new Button() ; 
                        bt1.setText("   send   ");
                        //FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        
                  
                        
                        
                        
                       

                        HBox managebtn = new HBox(bt1);  
                        managebtn.setStyle("-fx-color:green");                    
                        setGraphic(managebtn);

                       
                      bt1.setOnAction((ActionEvent event) -> {
                        /*TablePosition pos = (TablePosition) tableView.getSelectionModel().getSelectedCells();
                        int index= pos.getRow();
                         Item item = table.getItems().get(index);
                       // TableColumn col=pos.getTableColumn();
                        TableColumn col =tableView .getColumns().get(3);
                        String data = (String) col.getCellObservableValue(item).getValue();*/
                                
                        User u=getTableView().getItems().get(getIndex());
                          String s=u.getStatus();
                          
                        if( s.equals("offline")  )
                           //System.out.println(u.getUserName());    
                        { managebtn.setStyle("-fx-color:red");
                        Alert error=new Alert(Alert.AlertType.ERROR,u.getUserName()+ "is offline ");
                            error.show();}
                         else
                          {
                             System.out.println(u.getUserName());  
                        } 
                            
                           

                        });
                        

                    }
                }

            };

            return cell;
        };
         colRequest.setCellFactory(cellFoctory);
         tableView.setItems(userList);
         
         
    }
  
  
}
    
    

