import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TextBoxManager extends Actor {
    private int score = 0;
    private int arms = 0;
    private int bombs = 0;
    private String additionalText = "60";
    
    private int fontSize = 18;
    private Color textColor = Color.BLACK;
    private Color backgroundColor = new Color(0,0,0,0);  // Fondo transparente
    //private Color backgroundColor = Color.BLACK;  // Fondo transparente
    private Font font = new Font("Public Pixel",fontSize);
    private Font font2 = new Font("Public Pixel",35);
    
    private GreenfootImage scoreBox;
    private GreenfootImage armsBox;
    private GreenfootImage bombsBox;
    private GreenfootImage additionalBox;
    
    private TextBox scoreTextBox;
    private TextBox armsTextBox;
    private TextBox bombsTextBox;
    private TextBox additionalTextBox;
    
    public TextBoxManager() {
        this.font = new Font("Public Pixel",fontSize);  // Fuente por defecto
    }
    
    public void addedToWorld(World world) {
        scoreTextBox = new TextBox(new GreenfootImage(200, 30));
        armsTextBox = new TextBox(new GreenfootImage(200, 30));
        bombsTextBox = new TextBox(new GreenfootImage(200, 30));
        additionalTextBox = new TextBox(new GreenfootImage(200, 30));
        
        world.addObject(scoreTextBox, 151, 24);  // Ajusta la posición según sea necesario
        world.addObject(armsTextBox, 185, 39);    // Ajusta la posición según sea necesario
        world.addObject(bombsTextBox, 275, 39);  // Ajusta la posición según sea necesario
        world.addObject(additionalTextBox, 345, 26);  // Ajusta la posición según sea necesario
        
        updateScoreBox();
        updateArmsBox();
        updateBombsBox();
        updateAdditionalBox();
    }
    
    public void act() {
        // Aquí puedes agregar cualquier código que necesites ejecutar en cada ciclo de actualización
    }

    public void setScore(int score) {
        this.score = score;
        updateScoreBox();
    }
    
    public void setArms(int arms) {
        this.arms = arms;
        updateArmsBox();
    }
    
    public void setBombs(int bombs) {
        this.bombs = bombs;
        updateBombsBox();
    }
    
    public void setAdditionalText(String text) {
        this.additionalText = text;
        updateAdditionalBox();
    }
    
    private void updateScoreBox() {
        scoreBox = new GreenfootImage(200, 30);
        scoreBox.setColor(backgroundColor);
        scoreBox.fill();
        scoreBox.setColor(textColor);
        scoreBox.setFont(font);
        scoreBox.drawString("" + score, 10, 25);
        scoreTextBox.updateText(scoreBox);
    }
    
    private void updateArmsBox() {
        armsBox = new GreenfootImage(50, 30);
        armsBox.setColor(backgroundColor);
        armsBox.fill();
        armsBox.setColor(textColor);
        armsBox.setFont(font);
        armsBox.drawString("" + arms, 5, 25);
        armsTextBox.updateText(armsBox);
    }
    
    private void updateBombsBox() {
        bombsBox = new GreenfootImage(64, 35);
        bombsBox.setColor(backgroundColor);
        bombsBox.fill();
        bombsBox.setColor(textColor);
        
        //bombsBox.setColor();
        
        bombsBox.setFont(font);
        bombsBox.drawString("" + bombs, 5, 25);
        bombsTextBox.updateText(bombsBox);
    }
    
    private void updateAdditionalBox() {
        additionalBox = new GreenfootImage(64, 30);
        additionalBox.setColor(backgroundColor);
        additionalBox.fill();
        additionalBox.setColor(Color.YELLOW);
        additionalBox.setFont(font2);
        additionalBox.drawString(additionalText, -1, 30);
        additionalTextBox.updateText(additionalBox);
    }
}
