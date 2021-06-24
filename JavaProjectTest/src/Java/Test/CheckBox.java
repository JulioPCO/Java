package Java.Test;

public final class CheckBox extends UIControl {

    public CheckBox(){
        super(true);
    }

    @Override
    public void render(){
        System.out.println("Render CheckBox");
    }
    
}

//public class MyCheckBox extends CheckBox{} // cannot extend CheckBox is a final class

