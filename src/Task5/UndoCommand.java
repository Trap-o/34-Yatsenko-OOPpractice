package Task5;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import Task3.View;
import Task2.Item2d;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import Task3.ViewResult;

/**
 *
 * @author Trap
 */
public class UndoCommand {
    
    private static final String SNAME = "undosave.bin";
    
    private static final String UNAME = "undofile.bin";

    private ArrayList<Item2d> items;

    private View view;

    public UndoCommand(View view) {
        this.view = view;
    }
    
    public void undoWrite() throws IOException, ClassNotFoundException{
        items = ((ViewResult) view).getItems();
        undoRewrite();
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(SNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }
    
    public void undoRewrite() throws IOException, ClassNotFoundException{
        items = ((ViewResult) view).getItems();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(SNAME));
        items = (ArrayList<Item2d>)is.readObject();
        is.close();
        
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(UNAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    public void Undo() throws IOException, Exception{
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(UNAME));
            items = (ArrayList<Item2d>)is.readObject();
            is.close();
        } catch(ClassNotFoundException e){
            System.err.println("Serialization error: " + e);
        }
    }
}