package com.example.economyhud;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class EconomySettingsScreen extends Screen {
    private EditBox balanceBox;
    public EconomySettingsScreen() { super(Component.literal("Economy HUD Settings")); }
    @Override protected void init() {
        int cx = width / 2;
        balanceBox = new EditBox(font, cx - 100, height / 2 - 30, 200, 20, Component.literal("Displayed virtual balance"));
        balanceBox.setMaxLength(64);
        balanceBox.setValue(EconomyHud.balance);
        addRenderableWidget(balanceBox);
        addRenderableWidget(Button.builder(Component.literal("HUD: " + (EconomyHud.enabled ? "ON" : "OFF")), b -> {
            EconomyHud.enabled = !EconomyHud.enabled;
            b.setMessage(Component.literal("HUD: " + (EconomyHud.enabled ? "ON" : "OFF")));
        }).bounds(cx - 100, height / 2 + 1, 200, 20).build());
        addRenderableWidget(Button.builder(Component.literal("Save & Close"), b -> {
            EconomyHud.balance = balanceBox.getValue();
            onClose();
        }).bounds(cx - 100, height / 2 + 28, 200, 20).build());
    }
    @Override public void render(GuiGraphics g, int mx, int my, float delta) {
        super.render(g, mx, my, delta);
        g.drawCenteredString(font, title, width / 2, height / 2 - 65, 0xFFFFFFFF);
    }
}
