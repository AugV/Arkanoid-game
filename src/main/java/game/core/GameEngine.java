package game.core;

import game.engine.GameRules;
import game.engine.UserInteraction;

public class GameEngine {
    private GameObjects gameObjects;
    private GameLayout gameLayout;
    private GameRules gameRules;
    private UserInteraction userInteraction;

    public GameEngine(GameObjects gameObjects, GameLayout gameLayout) {
        this.gameObjects = gameObjects;
        this.gameLayout = gameLayout;
        initializeGameRules();
        initializeUserInteraction();
    }

    private void initializeUserInteraction() {
        this.userInteraction = new UserInteraction(gameLayout.getGameScene().getScene(),
                                                    gameObjects.getTheVaus(),
                                                    gameRules);
    }

    private void initializeGameRules() {
        this.gameRules = new GameRules(gameObjects.getBall(),
                gameObjects.getTheVaus(),
                gameObjects.getBrickList(),
                gameLayout.getRoot());
    }
}
