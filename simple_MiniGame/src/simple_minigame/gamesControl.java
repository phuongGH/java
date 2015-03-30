package simple_minigame;

public interface gamesControl {
    void leftClick();
    void rightClick();
    void downClick();
    void upClick();
    void okClick();

    public int getCode();
    public int getRanking();
    public int getLevel();
    public int getLive();
    public int getHighCode();
    
}
