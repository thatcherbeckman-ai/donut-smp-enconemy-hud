package com.example.economyhud;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;
import com.mojang.blaze3d.platform.InputConstants;

public class EconomyHud implements ClientModInitializer {
    static boolean enabled = true;
    static int x = 10, y = 10;
    static String balance = "No balance data";
    private static KeyMapping settingsKey;

    @Override public void onInitializeClient() {
        settingsKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key.economyhud.settings", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O,
            KeyMapping.Category.MISC));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (settingsKey.consumeClick()) client.setScreen(new EconomySettingsScreen());
        });
        HudElementRegistry.addLast(Identifier.fromNamespaceAndPath("economyhud", "balance"), (graphics, tick) -> {
            if (!enabled || Minecraft.getInstance().options.hideGui) return;
            draw(graphics);
        });
    }
    static void draw(GuiGraphics g) {
        var font = Minecraft.getInstance().font;
        g.fill(x, y, x + 184, y + 49, 0xCC171E32);
        g.fill(x, y, x + 184, y + 2, 0xFF8554A2);
        g.drawString(font, Component.literal("ECONOMY HUD"), x + 9, y + 8, 0xFFE0A2D7, false);
        g.drawString(font, Component.literal(balance), x + 9, y + 26, 0xFF57E995, true);
    }
}
