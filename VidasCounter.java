import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VidasCounter extends HUID {
    private int value = 0;
    private int fontSize = 30;  // Tamaño de la fuente
    private Color textColor = Color.BLACK;
    private Color backgroundColor = new Color(0, 0, 0, 0);  // Fondo transparente
    

    public VidasCounter() {
        updateImage();
    }

    public void act() {
        // Aquí puedes agregar cualquier código que necesites ejecutar en cada ciclo de actualización
    }

    public void add(int score) {
        value += score;
        updateImage();
    }

    public void subtract(int score) {
        value -= score;
        updateImage();
    }

    public void setValue(int value) {
        this.value = value;
        updateImage();
    }

    public int getValue() {
        return value;
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(200, 30);  // Ajusta el tamaño de la imagen según sea necesario
        image.setColor(backgroundColor);
        image.fill();
        image.setColor(textColor);
        image.setFont(new Font("Public Pixel", fontSize));
        image.drawString(""+value, 5, 25);//"Score: " + 
        setImage(image);
    }
}
