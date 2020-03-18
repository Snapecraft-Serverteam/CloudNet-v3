package de.dytanic.cloudnet.ext.cloudperms.sponge;

import com.google.inject.Inject;
import de.dytanic.cloudnet.common.Validate;
import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.wrapper.Wrapper;
import org.slf4j.Logger;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutionException;

@Plugin(
        id = "cloudnet_cloudperms",
        name = "CloudNet-CloudPerms",
        version = "1.0",
        description = "Sponge extension which implement the permission management system from CloudNet into Sponge for players",
        url = "https://cloudnetservice.eu"
)
public final class SpongeCloudNetCloudPermissionsPlugin {

    @Inject
    private Logger logger;

    private SpongeCloudNetCloudPermissionsPlugin instance;

    public SpongeCloudNetCloudPermissionsPlugin() {
    }

    @Listener
    public void onStart(){
        instance = this;
    }

    @Listener
    public void onEnable(GameStartedServerEvent event) {

    }

    @Listener
    public void onDisable(GameStoppingServerEvent event) {
        CloudNetDriver.getInstance().getEventManager().unregisterListeners(this.getClass().getClassLoader());
        Wrapper.getInstance().unregisterPacketListenersByClassLoader(this.getClass().getClassLoader());
    }

    public SpongeCloudNetCloudPermissionsPlugin getInstance() {
        return instance;
    }
}