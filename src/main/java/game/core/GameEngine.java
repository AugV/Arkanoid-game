package game.core;

import game.objects.GameObject;
import game.objects.TheVaus;
import game.rules.GameRules;
import game.user.UserInteraction;

public class GameEngine {
    private GameObjects gameObjects;
    private GameLayout gameLayout;
    private GameRules gameRules;
    private UserInteraction<game.objects.TheVaus> userInteraction;


    public GameEngine(GameObjects gameObjects, GameLayout gameLayout) {
        this.gameObjects = gameObjects;
        this.gameLayout = gameLayout;
        initializeGameRules();
        initializeUserInteraction();
    }

    private void initializeGameRules() {
        this.gameRules = new GameRules(gameObjects.getBall(),
                gameObjects.getTheVaus(),
                gameObjects.getBrickList(),
                gameLayout.getRoot());
    }

    private void initializeUserInteraction() {
        this.userInteraction = new UserInteraction<>(gameLayout.getGameScene().getScene(),
                                                    gameObjects.getTheVaus(),
                                                    gameRules);
    }
}
