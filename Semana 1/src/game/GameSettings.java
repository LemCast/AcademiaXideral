package game;

public class GameSettings { //SINGLETON implementation

    private static GameSettings globalSettings;
    private int masterVolume;

    private GameSettings(int masterVolume){
        this.masterVolume = masterVolume;
    }

    public static GameSettings getInstance(int masterVolume) {
        if(globalSettings == null) {
            globalSettings = new GameSettings(masterVolume);
        }
        return globalSettings;
    }
}
