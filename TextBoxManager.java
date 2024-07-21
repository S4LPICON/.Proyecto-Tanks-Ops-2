import greenfoot.*; 

public class TextBoxManager extends Actor {
    private int score = 0;
    private int arms = 0;
    private int bombs = 0;
    private int round = 1;

    private int fontSize = 18;
    private Color textColor = Color.LIGHT_GRAY;
    private Color backgroundColor = new Color(0,0,0,0);  // Fondo transparente
    private Font font = new Font("Public Pixel",fontSize);
    private Font font2 = new Font("Public Pixel",35);
    private Font font3 = new Font("Brutalworld",15);
    
    private TextBox scoreTextBox;
    private TextBox armsTextBox;
    private TextBox bombsTextBox;
    private TextBox roundsTextBox;

    public TextBoxManager() {
        scoreTextBox = new TextBox(new GreenfootImage(200, 30));
        armsTextBox = new TextBox(new GreenfootImage(200, 30));
        bombsTextBox = new TextBox(new GreenfootImage(200, 30));
        roundsTextBox = new TextBox(new GreenfootImage(200,100));
    }

    public void addedToWorld(World world) {
        world.addObject(scoreTextBox, 170, 643);  // Ajusta la posición según sea necesario
        world.addObject(armsTextBox, 1267, 601);  // Ajusta la posición según sea necesario1267
        world.addObject(bombsTextBox, 1270, 650); // Ajusta la posición según sea necesario
        world.addObject(roundsTextBox, 1243, 63); // Ajusta la posición según sea necesario
        
        
        updateScoreBox();
        updateArmsBox();
        updateBombsBox();
        updateRoundsBox();
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

    public void setRound(int round) {
        this.round = round;
        updateRoundsBox();
    }
    
    private void updateScoreBox() {
        GreenfootImage scoreBox = new GreenfootImage(200, 30);
        scoreBox.setColor(backgroundColor);
        scoreBox.fill();
        scoreBox.setColor(textColor);
        scoreBox.setFont(font);
        scoreBox.drawString("" + score, 10, 25);
        scoreTextBox.updateText(scoreBox);
    }

    private void updateArmsBox() {
        GreenfootImage armsBox = new GreenfootImage(50, 35);
        armsBox.setColor(backgroundColor);
        armsBox.fill();
        armsBox.setColor(textColor);
        armsBox.setFont(font);
        armsBox.drawString("" + arms, -1, 25);
        armsTextBox.updateText(armsBox);
    }

    private void updateBombsBox() {
        GreenfootImage bombsBox = new GreenfootImage(64, 35);
        bombsBox.setColor(backgroundColor);
        bombsBox.fill();
        bombsBox.setColor(textColor);
        bombsBox.setFont(font);
        bombsBox.drawString("" + bombs, 5, 25);
        bombsTextBox.updateText(bombsBox);
    }

    private void updateRoundsBox() {
        GreenfootImage roundsBox = new GreenfootImage(150, 100);
        roundsBox.setColor(backgroundColor);
        roundsBox.fill();
        roundsBox.setColor(Color.RED);
        roundsBox.setFont(font3);
        roundsBox.drawString("Oleada " + round, -1, 20);
        roundsTextBox.updateText(roundsBox);
    }
}
