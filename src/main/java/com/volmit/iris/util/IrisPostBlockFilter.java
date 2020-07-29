package com.volmit.iris.util;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;

import com.volmit.iris.generator.PostBlockChunkGenerator;

public abstract class IrisPostBlockFilter implements IPostBlockAccess
{
	public PostBlockChunkGenerator gen;

	public IrisPostBlockFilter(PostBlockChunkGenerator gen)
	{
		this.gen = gen;
	}

	public abstract void onPost(int x, int z);

	@Override
	public BlockData getPostBlock(int x, int y, int z)
	{
		return gen.getPostBlock(x, y, z);
	}

	@Override
	public void setPostBlock(int x, int y, int z, BlockData d)
	{
		gen.setPostBlock(x, y, z, d);
	}

	@Override
	public int highestTerrainOrFluidBlock(int x, int z)
	{
		return gen.highestTerrainOrFluidBlock(x, z);
	}

	@Override
	public int highestTerrainBlock(int x, int z)
	{
		return gen.highestTerrainBlock(x, z);
	}

	public boolean isAir(int x, int y, int z)
	{
		BlockData d = getPostBlock(x, y, z);
		return d.getMaterial().equals(Material.AIR) || d.getMaterial().equals(Material.CAVE_AIR);
	}

	public boolean isWater(int x, int y, int z)
	{
		BlockData d = getPostBlock(x, y, z);
		return d.getMaterial().equals(Material.WATER);
	}

	@Override
	public KList<CaveResult> caveFloors(int x, int z)
	{
		return gen.caveFloors(x, z);
	}

	@Override
	public void updateHeight(int x, int z, int h)
	{
		gen.updateHeight(x, z, h);
	}
}
