package biomesoplenty.common.eventhandler.client.gui;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import biomesoplenty.api.BOPObfuscationHelper;
import biomesoplenty.common.configuration.BOPConfigurationMisc;
import biomesoplenty.common.helpers.BOPReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MainMenuEventHandler 
{
	public static ResourceLocation[] bopTitlePanoramaPaths = new ResourceLocation[] {new ResourceLocation("biomesoplenty:textures/gui/title/background/panorama_0.png"), new ResourceLocation("biomesoplenty:textures/gui/title/background/panorama_1.png"), new ResourceLocation("biomesoplenty:textures/gui/title/background/panorama_2.png"), new ResourceLocation("biomesoplenty:textures/gui/title/background/panorama_3.png"), new ResourceLocation("biomesoplenty:textures/gui/title/background/panorama_4.png"), new ResourceLocation("biomesoplenty:textures/gui/title/background/panorama_5.png")};
	
    @SubscribeEvent
    public void openMainMenu(GuiOpenEvent event)
    {
        if (event.gui instanceof GuiMainMenu && BOPConfigurationMisc.titlePanorama == true)
        {
        	GuiMainMenu mainMenu = (GuiMainMenu)event.gui;
    		
    		BOPReflectionHelper.setPrivateFinalValue(GuiMainMenu.class, mainMenu, bopTitlePanoramaPaths, BOPObfuscationHelper.titlePanoramaPaths);
        }
    }
}