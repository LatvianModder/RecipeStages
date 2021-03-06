package com.blamejared.recipestages.events;

import com.blamejared.recipestages.compat.JEIPlugin;
import net.darkhax.gamestages.data.GameStageSaveHandler;
import net.darkhax.gamestages.data.IStageData;
import net.darkhax.gamestages.event.StagesSyncedEvent;
import net.minecraftforge.client.event.RecipesUpdatedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEventHandler {
    
    public ClientEventHandler() {
    
    }
    
    @SubscribeEvent
    public void onGamestageSync(StagesSyncedEvent event) {
        JEIPlugin.sync(event.getData());
    }
    
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void recipes(RecipesUpdatedEvent event) {
        IStageData data = GameStageSaveHandler.getClientData();
        if(data == null) {
            return;
        }
        JEIPlugin.sync(data);
    }
    
    
}
