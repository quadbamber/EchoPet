/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dsh105.echopet.compat.api.util;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import com.dsh105.echopet.compat.api.plugin.EchoPet;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.internal.platform.WorldGuardPlatform;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;

public class WorldUtil {

	public static boolean allowPets(Location location){
		boolean allowWorld = EchoPet.getPlugin().getMainConfig().getBoolean("worlds." + location.getWorld().getName(), EchoPet.getPlugin().getMainConfig().getBoolean("worlds.enableByDefault", true));
		return allowWorld && allowRegion(location);
	}

	public static boolean allowRegion(Location location){
		if(EchoPet.getPlugin().getWorldGuardProvider().isHooked()){
			WorldGuardPlugin wg = EchoPet.getPlugin().getWorldGuardProvider().getDependency();// is this even used in worldguard anymore? Keeping it cause it's how we hook
			if(wg == null){
				return true;
			}

			WorldGuardPlatform platform = WorldGuard.getInstance().getPlatform();
			RegionContainer container = platform.getRegionContainer();
			RegionManager regionManager = container.get(platform.getWorldByName(location.getWorld().getName()));

			if(regionManager == null){
				return true;
			}
			ApplicableRegionSet set = regionManager.getApplicableRegions(new Vector(location.getX(), location.getY(), location.getZ()));// idk if they have a wrapper

			if(set.size() <= 0){
				return true;
			}

			boolean result = true;
			boolean hasSet = false;
			boolean def = EchoPet.getPlugin().getMainConfig().getBoolean("worldguard.regions.allowByDefault", true);

			ConfigurationSection cs = EchoPet.getPlugin().getMainConfig().getConfigurationSection("worldguard.regions");

			for(ProtectedRegion region : set){
				for(String key : cs.getKeys(false)){
					if(!key.equalsIgnoreCase("allowByDefault") && !key.equalsIgnoreCase("regionEnterCheck")){
						if(region.getId().equals(key)){
							if(!hasSet){
								result = EchoPet.getPlugin().getMainConfig().getBoolean("worldguard.regions." + key, true);
								hasSet = true;
							}
						}
					}
				}
			}

			return hasSet ? result : def;
		}
		return true;
	}
}