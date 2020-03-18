package de.dytanic.cloudnet.ext.cloudperms.sponge.listener;

import de.dytanic.cloudnet.ext.cloudperms.CloudPermissionsHelper;
import de.dytanic.cloudnet.ext.cloudperms.CloudPermissionsManagement;
import de.dytanic.cloudnet.ext.cloudperms.sponge.SpongeCloudNetCloudPermissionsPlugin;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;

public class SpongeCloudNetCloudPermissionsPlayerListener {
    private SpongeCloudNetCloudPermissionsPlugin plugin;

    public SpongeCloudNetCloudPermissionsPlayerListener(SpongeCloudNetCloudPermissionsPlugin plugin){
        this.plugin = plugin;
    }

    @Listener
    public void onJoin(final ClientConnectionEvent.Login event){
        CloudPermissionsHelper.initPermissionUser(event.getProfile().getUniqueId(), event.getProfile().getName().get(),false);

        Sponge.getEventManager().registerListeners(this,new SpongeCloudNetCloudPermissionsPlayerListener(plugin));
    }

    @Listener
    public void onQuit(final ClientConnectionEvent.Disconnect event){
        CloudPermissionsManagement.getInstance().getCachedPermissionUsers().remove(event.getTargetEntity().getUniqueId());
    }
}
