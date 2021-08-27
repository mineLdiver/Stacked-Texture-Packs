package net.mine_diver.stackedtexturepacks.gui.screen.menu;

import net.minecraft.client.gui.screen.menu.TexturePacks;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.resource.TexturePack;
import org.lwjgl.opengl.GL11;

public class ActiveTexturePackList extends MultiTexturePackList {

    public ActiveTexturePackList(TexturePacks texturePacks) {
        super(texturePacks, texturePacks.width + texturePacks.width / 2, texturePacks.width / 2, texturePacks.width);
    }

    @Override
    protected int getSize() {
        return screenBaseAccessor.getMinecraft().texturePackManager.getTexturePacks().size();
    }

    @Override
    protected void entryClicked(int entryIndex, boolean doLoad) {

    }

    @Override
    protected boolean isWorldSelected(int i) {
        return false;
    }

    @Override
    protected void renderStatEntry(int itemId, int x, int y, int i1, Tessellator arg) {
        TexturePack var6 = (TexturePack)screenBaseAccessor.getMinecraft().texturePackManager.getTexturePacks().get(itemId);
        var6.bindIconTexture(screenBaseAccessor.getMinecraft());
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        arg.start();
        arg.colour(16777215);
        arg.vertex(x, y + i1, 0.0D, 0.0D, 1.0D);
        arg.vertex(x + 32, y + i1, 0.0D, 1.0D, 1.0D);
        arg.vertex(x + 32, y, 0.0D, 1.0D, 0.0D);
        arg.vertex(x, y, 0.0D, 0.0D, 0.0D);
        arg.draw();
        texturePacks.drawTextWithShadow(screenBaseAccessor.getTextManager(), var6.name, x + 32 + 2, y + 1, 16777215);
        texturePacks.drawTextWithShadow(screenBaseAccessor.getTextManager(), var6.description, x + 32 + 2, y + 12, 8421504);
        texturePacks.drawTextWithShadow(screenBaseAccessor.getTextManager(), var6.field_1139, x + 32 + 2, y + 12 + 10, 8421504);
    }
}
