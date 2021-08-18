package raceagainst.racecourse;

import raceagainst.graphics.Shader;
import raceagainst.graphics.Texture;
import raceagainst.graphics.VertexArray;

public class RaceCourse {

    private VertexArray background;
    private Texture bgTexture;
    private PlayerCar playerCar;
    private NonPlayerCar nonPlayerCar;

    public RaceCourse() {
        float[] vertices = new float[] {
                -10.0f, -10.0f * 9.0f / 16.0f, 0.0f,
                -10.0f,  10.0f * 9.0f / 16.0f, 0.0f,
                 10.0f,  10.0f * 9.0f / 16.0f, 0.0f,
                 10.0f, -10.0f * 9.0f / 16.0f, 0.0f
        };

        byte[] indices = new byte[] {
                0, 1, 2,
                2, 3, 0
        };

        float[] tcs = new float[] {
                0, 1,
                0, 0,
                1, 0,
                1, 1
        };

        background = new VertexArray(vertices, indices, tcs);
        bgTexture = new Texture("res/racebg.png");
        playerCar = new PlayerCar();
        nonPlayerCar = new NonPlayerCar();
    }

    public void update() {
        playerCar.update();
        nonPlayerCar.update();
    }

    public void render() {
        // Render the race background.
        Shader.BG.enable();
        bgTexture.bind();
        background.render();
        bgTexture.unbind();
        Shader.BG.disable();

        // Render the cars.
        playerCar.render();
        nonPlayerCar.render();
    }
}
