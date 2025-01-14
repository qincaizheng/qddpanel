package com.qdd.qddpanel.gui;

import com.qdd.qddpanel.QddpanelMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;


@SideOnly(Side.CLIENT)
public class GuiNinjaInfo extends GuiContainer {
    private static final String TEXTURE_PATH = QddpanelMod.MODID + ":" + "textures/gui/container/gui_demo.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);
    private static final int BUTTON_UP = 0;
    private static final int BUTTON_DOWN = 1;

    public GuiNinjaInfo (NinjaInfo  inventorySlotsIn)
    {
        super(inventorySlotsIn);
        this.xSize = 176;
        this.ySize = 133;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.drawDefaultBackground();
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        //将自定义背景贴图与Minecraft材质管理器绑定
        this.mc.getTextureManager().bindTexture(TEXTURE);
        //计算相对位置（以背景贴图左上角为(0,0)点）
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
        //绘制背景贴图（参数说明：在游戏中的XY位置；贴图在贴图文件中的XY位置；贴图的大小）
        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
        //用完了别忘了关掉
        //警告：一定要关！！不然可能会出问题！！
        GlStateManager.disableBlend();
        //结束渲染
        GlStateManager.popMatrix();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.drawVerticalLine(30, 19, 36, 0xFF000000);
        this.drawHorizontalLine(8, 167, 43, 0xFF000000);

        String title = I18n.format("container.qddpanel.demo");
        this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);

        // ItemStack item = new ItemStack(ItemLoader.goldenEgg);
        // this.itemRender.renderItemAndEffectIntoGUI(item, 8, 20);
    }

    @Override
    public void initGui()
    {
        super.initGui();
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiButton(BUTTON_UP, offsetX + 153, offsetY + 17, 15, 10, "")
        {
            // @Override
            public void drawButton(Minecraft mc, int mouseX, int mouseY)
            {
                if (this.visible)
                {
                    GlStateManager.color(1.0F, 1.0F, 1.0F);

                    mc.getTextureManager().bindTexture(TEXTURE);
                    int x = mouseX - this.x, y = mouseY - this.y;

                    if (x >= 0 && y >= 0 && x < this.width && y < this.height)
                    {
                        this.drawTexturedModalRect(this.x, this.y, 1, 146, this.width, this.height);
                    }
                    else
                    {
                        this.drawTexturedModalRect(this.x, this.y, 1, 134, this.width, this.height);
                    }
                }
            }
        });
        this.buttonList.add(new GuiButton(BUTTON_DOWN, offsetX + 153, offsetY + 29, 15, 10, "")
        {
            // @Override
            public void drawButton(Minecraft mc, int mouseX, int mouseY)
            {
                if (this.visible)
                {
                    GlStateManager.color(1.0F, 1.0F, 1.0F);

                    mc.getTextureManager().bindTexture(TEXTURE);
                    int x = mouseX - this.x, y = mouseY - this.y;

                    if (x >= 0 && y >= 0 && x < this.width && y < this.height)
                    {
                        this.drawTexturedModalRect(this.x, this.y, 20, 146, this.width, this.height);
                    }
                    else
                    {
                        this.drawTexturedModalRect(this.x, this.y, 20, 134, this.width, this.height);
                    }
                }
            }
        });
    }
}
