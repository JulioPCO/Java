package Java.Test;

public class TextBox extends UIControl{
    public String text ="";

    public TextBox(){
        super(true);
        System.out.println("Textbox");
    }

    @Override
    public void render(){
        System.out.println("Render TextBox");
    }

    @Override
    public String toString(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public void clear(){
        this.text = "";
    }
}
    

