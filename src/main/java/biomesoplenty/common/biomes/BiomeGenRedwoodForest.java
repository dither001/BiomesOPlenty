package biomesoplenty.common.biomes;

import biomesoplenty.api.BOPBlockHelper;
import biomesoplenty.common.world.features.WorldGenBOPDoubleFlora;
import biomesoplenty.common.world.features.WorldGenBOPFlora;
import biomesoplenty.common.world.features.WorldGenBOPTallGrass;
import biomesoplenty.common.world.features.trees.WorldGenRedwoodTree;
import biomesoplenty.common.world.features.trees.WorldGenRedwoodTree2;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenShrub;

import java.util.Random;

public class BiomeGenRedwoodForest extends BOPBiome
{
    private static final Height biomeHeight = new Height(0.1F, 0.1F);
    
    public BiomeGenRedwoodForest(int id)
    {
        super(id);

        this.setHeight(biomeHeight);
        this.setColor(7187004);
        this.setTemperatureRainfall(0.8F, 0.4F);

        this.theBiomeDecorator.treesPerChunk = 99;
        this.theBiomeDecorator.grassPerChunk = 15;

        this.bopWorldFeatures.setFeature("bopFlowersPerChunk", 5);
        this.bopWorldFeatures.setFeature("bushesPerChunk", 4);
        this.bopWorldFeatures.setFeature("berryBushesPerChunk", 1);
        this.bopWorldFeatures.setFeature("shrubsPerChunk", 10);
        this.bopWorldFeatures.setFeature("waterReedsPerChunk", 2);
        this.bopWorldFeatures.setFeature("leafPilesPerChunk", 15);
        this.bopWorldFeatures.setFeature("deadLeafPilesPerChunk", 5);
        this.bopWorldFeatures.setFeature("generatePumpkins", false);

        weightedFlowerGen.put(new WorldGenBOPDoubleFlora(4, 5), 10);
        weightedFlowerGen.put(new WorldGenBOPFlora(Blocks.red_flower, 1), 8);

        weightedGrassGen.put(new WorldGenBOPTallGrass(BOPBlockHelper.get("foliage"), 10), 0.5D);
        weightedGrassGen.put(new WorldGenBOPTallGrass(BOPBlockHelper.get("foliage"), 11), 0.5D);
        weightedGrassGen.put(new WorldGenBOPTallGrass(Blocks.tallgrass, 2), 0.5D);
        weightedGrassGen.put(new WorldGenBOPTallGrass(Blocks.tallgrass, 1), 1D);
    }

    @Override
    //TODO:                     getRandomWorldGenForTrees()
    public WorldGenAbstractTree func_150567_a(Random random)
    {
        return random.nextInt(2) == 0 ? new WorldGenRedwoodTree2(BOPBlockHelper.get("logs3"), BOPBlockHelper.get("colorizedLeaves1"), 0, 3, false, 20, 15) : (random.nextInt(10) == 0 ? new WorldGenShrub(0,0) : new WorldGenRedwoodTree(BOPBlockHelper.get("logs3"), BOPBlockHelper.get("colorizedLeaves1"), 0, 3, false, 40, 10));
    }

    @Override
    public void decorate(World world, Random random, int chunkX, int chunkZ)
    {
        super.decorate(world, random, chunkX, chunkZ);
        int var5 = 12 + random.nextInt(6);

        for (int var6 = 0; var6 < var5; ++var6)
        {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(28) + 4;
            int z = chunkZ + random.nextInt(16);

            Block block = world.getBlock(x, y, z);

            if (block != null && block.isReplaceableOreGen(world, x, y, z, Blocks.stone))
            {
                world.setBlock(x, y, z, BOPBlockHelper.get("gemOre"), 0, 2);
            }
        }
    }
    
    public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_)
    {

        if (p_150573_7_ > 1.75D)
        {
            this.topBlock = Blocks.grass;
            this.field_150604_aj = 0;
        }
        else if (p_150573_7_ > -0.95D)
        {
            this.topBlock = Blocks.dirt;
            this.field_150604_aj = 2;
        }

        this.genBiomeTerrain(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
    }
}
