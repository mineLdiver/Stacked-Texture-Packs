package net.mine_diver.stackedtexturepacks.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widgets.ScrollableBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ScrollableBase.class)
public interface ScrollableBaseAccessor {

    @Invoker
    void invokeMethod_1263();

    @Invoker
    void invokeRenderBackground(int i, int j, int k, int i1);

    @Accessor
    Minecraft getMinecraft();

    @Accessor
    int getField_1529();

    @Accessor
    void setField_1529(int field_1529);

    @Accessor
    int getField_1530();

    @Accessor
    int getField_1531();

    @Accessor
    void setField_1531(int field_1531);

    @Accessor
    int getField_1532();

    @Accessor
    void setField_1532(int field_1532);

    @Accessor
    float getField_1538();

    @Accessor
    void setField_1538(float field_1538);

    @Accessor
    float getField_1539();

    @Accessor
    void setField_1539(float field_1539);

    @Accessor
    float getField_1540();

    @Accessor
    void setField_1540(float field_1540);

    @Accessor
    int getField_1541();

    @Accessor
    void setField_1541(int field_1541);

    @Accessor
    long getField_1542();

    @Accessor
    void setField_1542(long field_1542);

    @Accessor
    boolean getField_1543();

    @Accessor
    boolean getField_1544();

    @Accessor
    int getField_1545();
}
