# Economy HUD — Fabric 1.21.11 source starter

Client-side Minecraft virtual economy display. Press **O** to open the settings screen and enter a display value manually. No server commands, betting, automated parsing, or network access.

## Build
Install Java 21 and Gradle compatible with Loom 1.14. From this directory run `gradle build`. The output should be in `build/libs/` if compilation succeeds. Fabric API is required in your mods folder.

**Status:** source starter, not compiled or tested against Minecraft. No Gradle wrapper is bundled. Depending on 1.21.11 mappings, `Identifier` / `GuiGraphics` / key mapping API names may need adjustment. This is not a finished screenshot-accurate multi-panel tracker.
