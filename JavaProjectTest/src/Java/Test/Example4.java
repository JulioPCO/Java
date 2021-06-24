package Java.Test;


public class Example4 {
    public static void main(String[] args){
        var control = new TextBox();
        var control2 = control; 
        //var control3 = new UIControl(true); // abstracted class
        control.disable();
        control.setText("Hello");
        System.out.println(control.isEnabled());

        System.out.println(control.hashCode());
        System.out.println(control2.hashCode());
        System.out.println(control.equals(control2));
        System.out.println(control.toString());
        System.out.println(control);

        //show(control3);
        show(control);


        var point1 = new Point(1,2);
        var point2 = new Point(1,2);

        System.out.println(point1.equals(point2));

        System.out.println(point1.hashCode());
        System.out.println(point2.hashCode());
        
        UIControl[] controls = {new TextBox(), new CheckBox()};
        for (var objs : controls)
            objs.render();

        //final methods are not overrritable
    }
    
    public static void show(UIControl control){
        if (control instanceof TextBox){
            var textBox = (TextBox) control;
            textBox.setText("Howdy");
        }

        System.out.println(control);
    }
}
