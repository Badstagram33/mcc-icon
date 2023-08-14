package gay.badstagram.mccicon.client;

import gay.badstagram.mccicon.IconStorage;
import gay.badstagram.mccicon.ModData;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCIconClient implements ClientModInitializer {
    private Logger LOGGER;
    private IconStorage iconStorage;
    private static MCCIconClient INSTANCE;

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        LOGGER = LoggerFactory.getLogger(ModData.MOD_ID);
        iconStorage = new IconStorage();
        iconStorage.init();

        LOGGER.info("Initializing {}", ModData.MOD_NAME);
    }

    public static MCCIconClient getInstance() {
        return INSTANCE;
    }

    public Logger getLogger() {
        return LOGGER;
    }

    public IconStorage getIconStorage() {
        return iconStorage;
    }
}
