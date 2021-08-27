package net.mine_diver.stackedtexturepacks.gui.screen.menu;

import net.mine_diver.stackedtexturepacks.mixin.ScreenBaseAccessor;
import net.mine_diver.stackedtexturepacks.mixin.ScrollableBaseAccessor;
import net.minecraft.client.gui.screen.menu.TexturePacks;
import net.minecraft.client.render.Tessellator;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public abstract class MultiTexturePackList extends TexturePacks.TexturePackList {

    protected final TexturePacks texturePacks;
    protected final ScreenBaseAccessor screenBaseAccessor;
    protected final ScrollableBaseAccessor _super = (ScrollableBaseAccessor) this;

    public MultiTexturePackList(TexturePacks texturePacks, int origin, int startX, int endX) {
        texturePacks.super();
        this.texturePacks = texturePacks;
        screenBaseAccessor = (ScreenBaseAccessor) texturePacks;
        _super.setField_1529(origin);
        _super.setField_1532(startX);
        _super.setField_1531(endX);
    }

    @Override
    protected void renderBackground() {}

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        int var4 = this.getSize();
        int var6 = _super.getField_1529();
        int var5 = var6 - 6;
        if (Mouse.isButtonDown(0)) {
            if (_super.getField_1538() == -1.0F) {
                boolean var7 = mouseX >= _super.getField_1532() && mouseX <= _super.getField_1531();
                if (mouseY >= this.field_1535 && mouseY <= this.field_1536) {
                    int var8 = _super.getField_1529() / 2 - 110;
                    int var9 = _super.getField_1529() / 2 + 110;
                    int var10 = mouseY - this.field_1535 - _super.getField_1545() + (int) _super.getField_1540() - 4;
                    int var11 = var10 / this.field_1537;
                    if (mouseX >= var8 && mouseX <= var9 && var11 >= 0 && var10 >= 0 && var11 < var4) {
                        boolean var12 = var11 == _super.getField_1541() && System.currentTimeMillis() - _super.getField_1542() < 250L;
                        this.entryClicked(var11, var12);
                        _super.setField_1541(var11);
                        _super.setField_1542(System.currentTimeMillis());
                    } else if (mouseX >= var8 && mouseX <= var9 && var10 < 0) {
                        this.mouseClicked(mouseX - var8, mouseY - this.field_1535 + (int) _super.getField_1540() - 4);
                        var7 = false;
                    }

                    if (mouseX >= var5 && mouseX <= var6) {
                        _super.setField_1539(-1.0F);
                        int var22 = this.getTotalRenderHeight() - (this.field_1536 - this.field_1535 - 4);
                        if (var22 < 1) {
                            var22 = 1;
                        }

                        int var13 = (int)((float)((this.field_1536 - this.field_1535) * (this.field_1536 - this.field_1535)) / (float)this.getTotalRenderHeight());
                        if (var13 < 32) {
                            var13 = 32;
                        }

                        if (var13 > this.field_1536 - this.field_1535 - 8) {
                            var13 = this.field_1536 - this.field_1535 - 8;
                        }

                        _super.setField_1539(_super.getField_1539() / ((float)(this.field_1536 - this.field_1535 - var13) / (float)var22));
                    } else {
                        _super.setField_1539(1.0F);
                    }

                    if (var7) {
                        _super.setField_1538((float)mouseY);
                    } else {
                        _super.setField_1538(-2.0F);
                    }
                } else {
                    _super.setField_1538(-2.0F);
                }
            } else if (_super.getField_1538() >= 0.0F) {
                _super.setField_1540(_super.getField_1540() - ((float)mouseY - this._super.getField_1538()) * _super.getField_1539());
                _super.setField_1538((float)mouseY);
            }
        } else {
            _super.setField_1538(-1.0F);
        }

        _super.invokeMethod_1263();
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator var16 = Tessellator.INSTANCE;
        GL11.glBindTexture(3553, _super.getMinecraft().textureManager.getTextureId("/gui/background.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float var17 = 32.0F;
        var16.start();
        var16.colour(2105376);
        var16.vertex(_super.getField_1532(), this.field_1536, 0.0D, (float)_super.getField_1532() / var17, (float)(this.field_1536 + (int) _super.getField_1540()) / var17);
        var16.vertex(_super.getField_1531(), this.field_1536, 0.0D, (float)_super.getField_1531() / var17, (float)(this.field_1536 + (int) _super.getField_1540()) / var17);
        var16.vertex(_super.getField_1531(), this.field_1535, 0.0D, (float)_super.getField_1531() / var17, (float)(this.field_1535 + (int) _super.getField_1540()) / var17);
        var16.vertex(_super.getField_1532(), this.field_1535, 0.0D, (float)_super.getField_1532() / var17, (float)(this.field_1535 + (int) _super.getField_1540()) / var17);
        var16.draw();
        int var18 = _super.getField_1529() / 2 - 92 - 16;
        int var19 = this.field_1535 + 4 - (int) _super.getField_1540();
        if (_super.getField_1544()) {
            this.renderStatItemSlot(var18, var19, var16);
        }

        for(int var20 = 0; var20 < var4; ++var20) {
            int var23 = var19 + var20 * this.field_1537 + _super.getField_1545();
            int var25 = this.field_1537 - 4;
            if (var23 <= this.field_1536 && var23 + var25 >= this.field_1535) {
                if (_super.getField_1543() && this.isWorldSelected(var20)) {
                    int var14 = _super.getField_1529() / 2 - 110;
                    int var15 = _super.getField_1529() / 2 + 110;
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glDisable(3553);
                    var16.start();
                    var16.colour(8421504);
                    var16.vertex(var14, var23 + var25 + 2, 0.0D, 0.0D, 1.0D);
                    var16.vertex(var15, var23 + var25 + 2, 0.0D, 1.0D, 1.0D);
                    var16.vertex(var15, var23 - 2, 0.0D, 1.0D, 0.0D);
                    var16.vertex(var14, var23 - 2, 0.0D, 0.0D, 0.0D);
                    var16.colour(0);
                    var16.vertex(var14 + 1, var23 + var25 + 1, 0.0D, 0.0D, 1.0D);
                    var16.vertex(var15 - 1, var23 + var25 + 1, 0.0D, 1.0D, 1.0D);
                    var16.vertex(var15 - 1, var23 - 1, 0.0D, 1.0D, 0.0D);
                    var16.vertex(var14 + 1, var23 - 1, 0.0D, 0.0D, 0.0D);
                    var16.draw();
                    GL11.glEnable(3553);
                }

                this.renderStatEntry(var20, var18, var23, var25, var16);
            }
        }

        GL11.glDisable(2929);
        byte var21 = 4;
        _super.invokeRenderBackground(0, this.field_1535, 255, 255);
        _super.invokeRenderBackground(this.field_1536, _super.getField_1530(), 255, 255);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        var16.start();
        var16.colour(0, 0);
        var16.vertex(_super.getField_1532(), this.field_1535 + var21, 0.0D, 0.0D, 1.0D);
        var16.vertex(_super.getField_1531(), this.field_1535 + var21, 0.0D, 1.0D, 1.0D);
        var16.colour(0, 255);
        var16.vertex(_super.getField_1531(), this.field_1535, 0.0D, 1.0D, 0.0D);
        var16.vertex(_super.getField_1532(), this.field_1535, 0.0D, 0.0D, 0.0D);
        var16.draw();
        var16.start();
        var16.colour(0, 255);
        var16.vertex(_super.getField_1532(), this.field_1536, 0.0D, 0.0D, 1.0D);
        var16.vertex(_super.getField_1531(), this.field_1536, 0.0D, 1.0D, 1.0D);
        var16.colour(0, 0);
        var16.vertex(_super.getField_1531(), this.field_1536 - var21, 0.0D, 1.0D, 0.0D);
        var16.vertex(_super.getField_1532(), this.field_1536 - var21, 0.0D, 0.0D, 0.0D);
        var16.draw();
        int var24 = this.getTotalRenderHeight() - (this.field_1536 - this.field_1535 - 4);
        if (var24 > 0) {
            int var26 = (this.field_1536 - this.field_1535) * (this.field_1536 - this.field_1535) / this.getTotalRenderHeight();
            if (var26 < 32) {
                var26 = 32;
            }

            if (var26 > this.field_1536 - this.field_1535 - 8) {
                var26 = this.field_1536 - this.field_1535 - 8;
            }

            int var27 = (int) _super.getField_1540() * (this.field_1536 - this.field_1535 - var26) / var24 + this.field_1535;
            if (var27 < this.field_1535) {
                var27 = this.field_1535;
            }

            var16.start();
            var16.colour(0, 255);
            var16.vertex(var5, this.field_1536, 0.0D, 0.0D, 1.0D);
            var16.vertex(var6, this.field_1536, 0.0D, 1.0D, 1.0D);
            var16.vertex(var6, this.field_1535, 0.0D, 1.0D, 0.0D);
            var16.vertex(var5, this.field_1535, 0.0D, 0.0D, 0.0D);
            var16.draw();
            var16.start();
            var16.colour(8421504, 255);
            var16.vertex(var5, var27 + var26, 0.0D, 0.0D, 1.0D);
            var16.vertex(var6, var27 + var26, 0.0D, 1.0D, 1.0D);
            var16.vertex(var6, var27, 0.0D, 1.0D, 0.0D);
            var16.vertex(var5, var27, 0.0D, 0.0D, 0.0D);
            var16.draw();
            var16.start();
            var16.colour(12632256, 255);
            var16.vertex(var5, var27 + var26 - 1, 0.0D, 0.0D, 1.0D);
            var16.vertex(var6 - 1, var27 + var26 - 1, 0.0D, 1.0D, 1.0D);
            var16.vertex(var6 - 1, var27, 0.0D, 1.0D, 0.0D);
            var16.vertex(var5, var27, 0.0D, 0.0D, 0.0D);
            var16.draw();
        }

        this.method_1255(mouseX, mouseY);
        GL11.glEnable(3553);
        GL11.glShadeModel(7424);
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }
}
