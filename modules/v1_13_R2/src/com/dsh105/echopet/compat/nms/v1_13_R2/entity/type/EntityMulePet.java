package com.dsh105.echopet.compat.nms.v1_13_R2.entity.type;

import com.dsh105.echopet.compat.api.entity.EntityPetType;
import com.dsh105.echopet.compat.api.entity.EntitySize;
import com.dsh105.echopet.compat.api.entity.IPet;
import com.dsh105.echopet.compat.api.entity.PetType;
import com.dsh105.echopet.compat.api.entity.type.nms.IEntityMulePet;

import net.minecraft.server.v1_13_R2.EntityTypes;
import net.minecraft.server.v1_13_R2.World;

/**
 * @Author Borlea
 * @Github https://github.com/borlea/
 * @Website http://codingforcookies.com/
 * @since Nov 19, 2016
 */
@EntitySize(width = 1.4F, height = 1.6F)
@EntityPetType(petType = PetType.MULE)
public class EntityMulePet extends EntityHorseChestedAbstractPet implements IEntityMulePet{

	public EntityMulePet(World world){
		super(EntityTypes.MULE, world);
	}

	public EntityMulePet(World world, IPet pet){
		super(EntityTypes.MULE, world, pet);
	}
}
