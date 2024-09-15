package winlyps.kotlinPlugins.utils

import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.util.jar.JarFile

object PluginUtils {

    fun getKotlinPlugins(plugin: JavaPlugin): List<String> {
        val pluginsFolder = plugin.dataFolder.parentFile
        val kotlinPlugins = mutableListOf<String>()

        pluginsFolder.listFiles()?.forEach { file ->
            if (file.name.endsWith(".jar") && hasKotlinMetadata(plugin, file)) {
                kotlinPlugins.add(file.name)
            }
        }

        return kotlinPlugins
    }

    private fun hasKotlinMetadata(plugin: JavaPlugin, file: File): Boolean {
        return try {
            JarFile(file).use { jarFile ->
                jarFile.entries().asSequence().any { entry ->
                    entry.name.startsWith("META-INF/") && entry.name.endsWith(".kotlin_module")
                }
            }
        } catch (e: Exception) {
            false
        }
    }
}