package winlyps.kotlinPlugins

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import winlyps.kotlinPlugins.utils.PluginUtils

class KotlinPluginCommand(private val plugin: KotlinPlugins) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (!sender.hasPermission("kotlinplugins.use")) {
            sender.sendMessage("§cYou do not have permission to use this command.")
            return true
        }

        // Get the list of Kotlin plugins
        val kotlinPlugins = PluginUtils.getKotlinPlugins(plugin)

        // Send the list of Kotlin plugins to the player
        if (kotlinPlugins.isEmpty()) {
            sender.sendMessage("§aNo Kotlin plugins found.")
        } else {
            val numberOfPlugins = kotlinPlugins.size
            sender.sendMessage("§6Kotlin Plugins ($numberOfPlugins):")
            kotlinPlugins.forEach { pluginName ->
                sender.sendMessage("§a- $pluginName")
            }
        }

        return true
    }
}