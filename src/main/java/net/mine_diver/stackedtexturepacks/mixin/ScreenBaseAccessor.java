package net.mine_diver.stackedtexturepacks.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.render.TextRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ScreenBase.class)
public interface ScreenBaseAccessor {

    @Accessor
    Minecraft getMinecraft();

    @Accessor
    TextRenderer getTextManager();
}
