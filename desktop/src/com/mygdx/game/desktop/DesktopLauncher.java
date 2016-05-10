package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import thebreakingbones.TheBreakingBones;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
                config.height = 480;
                config.fullscreen = false;
                config.resizable = false;
                config.title = "The Breaking Bones";
                new LwjglApplication(new TheBreakingBones(), config);
	}
}
