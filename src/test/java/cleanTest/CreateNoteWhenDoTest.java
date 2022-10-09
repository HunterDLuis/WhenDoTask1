package cleanTest;

import activity.ConfirmDeletePopup;
import activity.CreateNoteForm;
import activity.DeleteNoteForm;
import activity.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class CreateNoteWhenDoTest {
    MainScreen mainScreen = new MainScreen();
    CreateNoteForm createNoteForm = new CreateNoteForm();
    DeleteNoteForm deleteNoteForm = new DeleteNoteForm();
    ConfirmDeletePopup confirmDeletePopup = new ConfirmDeletePopup();
    String title = "Cato";
    String note="esta es una nota";
    String updateTitle = "CatoUpdate";
    String updateNote = "nota updated";

    @Test
    public void verifyCUDNote(){
        //Create Note
        mainScreen.addNoteButton.click();
        createNoteForm.titleTxtBox.setText(title);
        createNoteForm.noteTxtBox.setText(note);
        createNoteForm.saveButton.click();

        Assertions.assertTrue(mainScreen.isNoteDisplayed(title),
                "ERROR, the note was not created");

        //Update Note
        mainScreen.clickNoteCreated(title);
        createNoteForm.titleTxtBox.setText(updateTitle);
        createNoteForm.noteTxtBox.setText(updateNote);
        createNoteForm.saveButton.click();

        Assertions.assertTrue(mainScreen.isNoteDisplayed(updateTitle),
                "ERROR, the note was not updated");

        //Delete Note
        mainScreen.clickNoteCreated(updateTitle);
        deleteNoteForm.deleteButton.click();
        confirmDeletePopup.deleteButtonConfirm.click();

        Assertions.assertTrue(mainScreen.noTasksAddedMessageIsDisplayed(),
                "ERROR, the note was not deleted");
    }

    @AfterEach
    public void closeApp(){
        Session.getInstance().closeApp();
    }

}
