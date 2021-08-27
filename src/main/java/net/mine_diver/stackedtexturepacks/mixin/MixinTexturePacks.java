package net.mine_diver.stackedtexturepacks.mixin;

import com.sun.org.apache.bcel.internal.generic.PUTFIELD;
import net.mine_diver.stackedtexturepacks.gui.screen.menu.ActiveTexturePackList;
import net.mine_diver.stackedtexturepacks.gui.screen.menu.AvailableTexturePackList;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.screen.menu.TexturePacks;
import net.minecraft.client.gui.widgets.Button;
import net.minecraft.client.gui.widgets.ScrollableBase;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;

@Mixin(TexturePacks.class)
public class MixinTexturePacks extends ScreenBase {

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @Redirect(
            method = "init()V",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/gui/screen/menu/TexturePacks;texturePackList:Lnet/minecraft/client/gui/screen/menu/TexturePacks$TexturePackList;",
                    opcode = Opcodes.PUTFIELD
            )
    )
    private void stopOriginalTexturePackList1(TexturePacks texturePacks, ScrollableBase value) {}

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @Redirect(
            method = "init()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screen/menu/TexturePacks$TexturePackList;registerButtons(Ljava/util/List;II)V"
            )
    )
    private void stopOriginalTexturePackList2(ScrollableBase texturePackList, List<Button> list, int i, int j) {}

    @Unique
    private AvailableTexturePackList availableTexturePackList;

    @Unique
    private ActiveTexturePackList activeTexturePackList;

    @Inject(
            method = "init()V",
            at = @At("TAIL")
    )
    private void initActiveTexturePackList(CallbackInfo ci) {
        availableTexturePackList = new AvailableTexturePackList((TexturePacks) (Object) this);
        availableTexturePackList.registerButtons(buttons, 7, 8);
        activeTexturePackList = new ActiveTexturePackList((TexturePacks) (Object) this);
        activeTexturePackList.registerButtons(buttons, 7, 8);
    }

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @Redirect(
            method = "buttonClicked(Lnet/minecraft/client/gui/widgets/Button;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screen/menu/TexturePacks$TexturePackList;buttonClicked(Lnet/minecraft/client/gui/widgets/Button;)V"
            )
    )
    private void clickedTextureList(ScrollableBase texturePackList, Button arg) {
        availableTexturePackList.buttonClicked(arg);
        activeTexturePackList.buttonClicked(arg);
    }

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @Redirect(
            method = "render(IIF)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screen/menu/TexturePacks$TexturePackList;render(IIF)V"
            )
    )
    private void renderActiveTexturePackList(ScrollableBase texturePackList, int mouseX, int mouseY, float delta) {
        renderBackground();
        availableTexturePackList.render(mouseX, mouseY, delta);
        activeTexturePackList.render(mouseX, mouseY, delta);
    }
}
