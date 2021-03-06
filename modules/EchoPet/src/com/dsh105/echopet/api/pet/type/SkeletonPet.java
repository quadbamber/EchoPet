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

package com.dsh105.echopet.api.pet.type;

import org.bukkit.entity.Player;

import com.dsh105.echopet.api.pet.Pet;
import com.dsh105.echopet.compat.api.entity.EntityPetType;
import com.dsh105.echopet.compat.api.entity.PetType;
import com.dsh105.echopet.compat.api.entity.SkeletonType;
import com.dsh105.echopet.compat.api.entity.type.nms.IEntitySkeletonAbstractPet;
import com.dsh105.echopet.compat.api.entity.type.pet.ISkeletonAbstractPet;

@EntityPetType(petType = PetType.SKELETON)
public class SkeletonPet extends Pet implements ISkeletonAbstractPet {

	SkeletonType skeletonType;

    public SkeletonPet(Player owner) {
        super(owner);
    }

    @Override
	public void setSkeletonType(SkeletonType type){
		((IEntitySkeletonAbstractPet) getEntityPet()).setSkeletonType(type);
		this.skeletonType = type;
    }

    @Override
	public SkeletonType getSkeletonType(){
		return this.skeletonType;
    }

}