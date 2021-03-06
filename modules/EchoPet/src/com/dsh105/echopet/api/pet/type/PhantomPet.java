package com.dsh105.echopet.api.pet.type;

import org.bukkit.entity.Player;

import com.dsh105.echopet.api.pet.Pet;
import com.dsh105.echopet.compat.api.entity.EntityPetType;
import com.dsh105.echopet.compat.api.entity.PetType;
import com.dsh105.echopet.compat.api.entity.type.pet.IPhantomPet;

/**
 * @author Arnah
 * @since Aug 12, 2018
*/
@EntityPetType(petType = PetType.PHANTOM)
public class PhantomPet extends Pet implements IPhantomPet{

	public PhantomPet(Player owner){
		super(owner);
	}
}
