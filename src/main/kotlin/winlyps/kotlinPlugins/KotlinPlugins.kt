package winlyps.kotlinPlugins

import org.bukkit.plugin.java.JavaPlugin

class KotlinPlugins : JavaPlugin() {

    override fun onEnable() {
        logger.info("🌟 KotlinFix has been enabled! 🌟")
        getCommand("kotlinplugins")?.setExecutor(KotlinPluginCommand(this))
    }

    override fun onDisable() {
        logger.info("🌙 KotlinFix is going to sleep... 🌙")
    }
}