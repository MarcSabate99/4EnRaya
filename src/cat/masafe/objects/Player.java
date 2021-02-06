package cat.masafe.objects;

public class Player {

    private String color;
    private boolean firstToPlay;

    public Player(String color, boolean firstToPlay){
        this.color = color;
        this.firstToPlay = firstToPlay;
    }

    public Player(String color){
        this.color = color;
        this.firstToPlay = false;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFirstToPlay() {
        return firstToPlay;
    }

    public void setFirstToPlay(boolean firstToPlay) {
        this.firstToPlay = firstToPlay;
    }
}

