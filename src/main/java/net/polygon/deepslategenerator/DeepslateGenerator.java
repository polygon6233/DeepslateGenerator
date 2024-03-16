package net.polygon.deepslategenerator;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.ActionResult;
// Test

public class DeepslateGenerator implements ModInitializer {
    
	@Override
	public void onInitialize() {
        CobblestoneGeneratedCallback.EVENT.register((world, pos) -> {
            Block block = world.getBlockState(pos).getBlock() == Blocks.OBSIDIAN ? Blocks.OBSIDIAN : (pos.getY() > 0 ? Blocks.COBBLESTONE : Blocks.DEEPSLATE);
            world.setBlockState(pos, block.getDefaultState());
            return ActionResult.PASS;
        });
	}
}