/**
 *
 * @author M. Dabney
 *
 *
 *   This is not intended to be anything more than a crude sample of
 *    a)  How to use RadioButtons in conjunction with a ToggleGroup
 *    b)  How to use a ComboBox with an array of values, and determine which one is selected
 *    c)  How to conditionally make specific controls of your GUI visibile/invisible
 *    d)  How to use the DatePicker and capture the contents to a user variable
 *
 *    You might also find the functions for form validation of use
 *
 *    In class, we will remediate the following issues with this program
 *       5 Syntax errors
 *       1 Runtime error
 *       1 Logical error
 *
 *
 *    Please do *NOT* include this source code file when turning in your coursework for Lab3
 *
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.time.LocalDate;



import java.util.Date;
import java.util.Calendar;



public class RadioExampleFixed extends Application
{

    private  ToggleGroup tgItemType = new ToggleGroup();
    private  RadioButton rbBook = new RadioButton("Book");
    private  RadioButton rbDisc = new RadioButton("Disc");


    public static String[] formats = { "CD", "DVD", "Blu-Ray", };
    ObservableList<String> fmtOptions = FXCollections.observableArrayList(formats );


    protected VBox rootPane = new VBox();
    protected GridPane pnlEntry = new GridPane();

    protected GridPane pnlTest = new GridPane();

    protected HBox paneRadio = new HBox();

    protected TextField txtDesc           = new TextField();
    protected ComboBox <String> cbFormat  = new ComboBox<String>(fmtOptions);

    protected Label lblDesc              = new Label("ItemDesc: ");
    protected Label lblType              = new Label("Item Type: ");
    protected Label lblInvDate           = new Label("Inventory Date: ");
    protected Label lblPages             = new Label("Pages: ");
    protected Label lblFormat            = new Label("Format: ");

    protected TextField txtPages         = new TextField();

    protected Button btnSubmit           = new Button("Submit");
    protected Button btnReset            = new Button("Reset");

    protected Label lblOutput            = new Label("Output: ");
    protected TextField txtOutput        = new TextField();
    protected TextArea taToString        = new TextArea();

    protected DatePicker dpInventoryDt = new DatePicker();
    // use the following lines to show how you want date to disply
    public static final String  DATE_FMT= "MM/dd/yyyy";
    public static DateFormat dateFormat = new SimpleDateFormat(DATE_FMT);



    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {

        pnlEntry.setHgap(10); //horizontal gap in pixels
        pnlEntry.setVgap(10); //vertical gap in pixels
        pnlEntry.setPadding(new Insets(10, 10, 10, 10));


        rbBook.setSelected(true);
        rbBook.setToggleGroup(tgItemType);
        rbBook.setUserData("B");
        rbDisc.setSelected(false);
        rbDisc.setToggleGroup(tgItemType);
        rbDisc.setUserData("D");


        //paneRadio.setPadding(new Insets(10, 10, 10, 10));
        paneRadio.getChildren().addAll(rbBook, rbDisc);
        paneRadio.setSpacing(10);

        rbBook.setOnAction(e -> processBookRadio());
        rbDisc.setOnAction(e -> processDiscRadio());

        btnSubmit.setOnAction(e -> processSubmit());

        btnReset.setOnAction(e -> processReset());

        //txtDesc.setPrefColumnCount(20);
        txtDesc.setMaxWidth(80);
        pnlEntry.add(lblDesc, 0, 0);
        pnlEntry.add(txtDesc, 1, 0);

        pnlEntry.add(lblInvDate,0, 1);
        pnlEntry.add(dpInventoryDt,1, 1);

        pnlEntry.add(lblType,0, 2);
        pnlEntry.add(paneRadio,1, 2);

        // note that the two fields toggled for visibility have the ame location
        pnlEntry.add(lblPages,0, 3);
        pnlEntry.add(txtPages,1, 3);

        pnlEntry.add(lblFormat,0, 3);
        pnlEntry.add(cbFormat ,1, 3);

        pnlEntry.add(btnSubmit,0, 4);
        pnlEntry.add(btnReset,1, 4);

        pnlTest.add(lblOutput,0,0);
        pnlTest.add(txtOutput,1,0);


        taToString.setPrefColumnCount(20);
        taToString.setPrefRowCount(6);
        pnlTest.add(taToString,1,1);

        rootPane.getChildren().add(pnlEntry);
        rootPane.getChildren().add(pnlTest);

        paneRadio.setVisible(true);
        processBookRadio(); // default
        pnlTest.setVisible(false);


        // Create a scene and place it in the stage
        Scene scene = new Scene(rootPane, 400, 500);
        primaryStage.setTitle("Radio Button Example"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage


    }

    public void processBookRadio()
    {
        lblFormat.setVisible(false);
        cbFormat.setVisible(false);
        lblPages.setVisible(true);
        txtPages.setVisible(true);
    }

    public void processDiscRadio()
    {
        lblFormat.setVisible(true);
        cbFormat.setVisible(true);
        lblPages.setVisible(false);
        txtPages.setVisible(false);
    }

    public void processSubmit()
    {
        this.taToString.setText("");
        this.txtOutput.setText("");
        pnlTest.setVisible(true);
        ArrayList <String> errMsgs = validateEntry();
        if (errMsgs.size() > 0)
        {
            StringBuilder sb = new StringBuilder("");
            for (int i=0; i < errMsgs.size(); i++)
            {
                sb.append(errMsgs.get(i));
                sb.append("\n");
            }
            this.taToString.setText(sb.toString());
        }
        else
        {
            processValidatedEntry();
        }

    }


    public void processReset()
    {
        txtDesc.setText("");
        txtPages.setText("");
        txtOutput.setText("");
        taToString.setText("");
        cbFormat.getSelectionModel().clearSelection();
        pnlTest.setVisible(false);
        rbBook.setSelected(true); // default
        processBookRadio();  // default
    }

    private void processValidatedEntry()
    {
        StringBuilder msg = new StringBuilder();
        if ( this.rbDisc.isSelected() )
        {
            msg.append(discInfo());
        }
        else
        {
            msg.append(bookInfo());
        }
        Calendar cal = localdateToCal(dpInventoryDt.getValue());
        String s = dateFormat.format(cal.getTime());
        msg.append(" ("+s+")");
        this.txtOutput.setText(msg.toString());

        // now append date information:

    }


    private String bookInfo()
    {
        int pgs = Integer.parseInt(this.txtPages.getText());
        return "This book has "+pgs+" "+"pages";
    }

    private String discInfo()
    {
        String fmt = "";
        int idxFmt = fmtOptions.indexOf(cbFormat.getValue());
        if (idxFmt >= 0)
        {
            fmt =  formats[idxFmt];
        }
        return "This disc has a format of "+fmt;
    }


    private ArrayList <String> validateEntry()
    {
        // array list of messages
        ArrayList <String> al = new ArrayList <String>();
        if (this.txtDesc.getText().trim().length() == 0)
        {
            al.add("Description must be entered");
        }
        if ( this.rbBook.isSelected() )
        {
            if (this.txtPages.getText().trim().length() == 0)
            {
                al.add("Book must have pages");
            }
            if (! isNumeric( this.txtPages.getText().trim()) )
            {
                al.add("Pages must be numeric");
            }
        }
        int idxFmt = fmtOptions.indexOf(cbFormat.getValue());
        if ( this.rbDisc.isSelected() &&  (idxFmt < 0) )
        {
            al.add("Disc must have format");
        }


        return al;
    }

    /**
     * Method localdateToCal
     *
     *
     * Useful because in DatePicker returns a localDate
     *
     *
     * @param string
     */
    public static Calendar localdateToCal(LocalDate localDate)
    {
        Calendar cal = Calendar.getInstance();
        //Method 1
        Date date = java.sql.Date.valueOf(localDate);
        cal.setTime(date);
        // Method 2
        // localdate uses "real" month (e.g. 1-12 insted of 0-11)
        cal.set(Calendar.MONTH, localDate.getMonthValue() - 1);
        cal.set(Calendar.DATE, localDate.getDayOfMonth());
        cal.set(Calendar.YEAR, localDate.getYear());
        return cal;
    }

    /**
     * Method calToLocalDate
     *
     * Not used, but deomonstrates how to convert the other direction
     *
     *
     * @param string
     */
    public static LocalDate calToLocalDate(Calendar cal)
    {
        // Method 1
        //Date dt = cal.getTime();
        //LocalDate ld = new java.sql.Date(dt.getTime()).toLocalDate();
        // Method 2
        // localDate wants "real" month
        LocalDate ld = LocalDate.of(cal.get(Calendar.YEAR),  cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
        return ld;

    }

    public static void main(String[] args)
    {
        launch(args);
    }

    private static boolean isNumeric(String str)
    {
        if (str == null)
        {
            str = "";
        }
        return str.matches("[0-9]*");
    }




}