package activity;

import appiumControl.Button;
import appiumControl.Label;
import org.openqa.selenium.By;
public class MainScreen {

    public Button addNoteButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public MainScreen(){}


    public boolean isNoteDisplayed(String title){
        Label note= new Label(By.xpath("//android.widget.TextView[@text='"+title+"']"));
        return note.isControlDisplayed();
    }

    public void clickNoteCreated(String title){
        Label updateNote = new Label(By.xpath("//android.widget.TextView[@text='"+title+"']"));
        updateNote.click();
    }

    public boolean noTasksAddedMessageIsDisplayed(){
        Label message = new Label(By.id("com.vrproductiveapps.whendo:id/noNotesText"));
        return message.isControlDisplayed();
    }

}
