package me.bubbles.teleportmod.block;

import me.bubbles.teleportmod.creativetab.CreativeTabTM;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTP extends Block {

    public BlockTP(Material materialIn) {
        super(materialIn);
        this.setCreativeTab(CreativeTabTM.TM_TAB);
    }

    public BlockTP() {
        this(Material.rock);
    }
}
