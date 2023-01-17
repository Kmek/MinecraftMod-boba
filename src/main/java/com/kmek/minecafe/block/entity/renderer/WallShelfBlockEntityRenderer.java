package com.kmek.minecafe.block.entity.renderer;

import com.kmek.minecafe.block.WallShelfBlock;
import com.kmek.minecafe.block.entity.WallShelfBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.items.ItemStackHandler;

public class WallShelfBlockEntityRenderer implements BlockEntityRenderer<WallShelfBlockEntity> {
    public WallShelfBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(WallShelfBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        ItemStackHandler items = pBlockEntity.getRenderStack();
        pPoseStack.pushPose();

        pPoseStack.translate(0.5f, 0.78f, 0.5f);
        pPoseStack.scale(0.2f, 0.2f, 0.2f);
        switch(pBlockEntity.getBlockState().getValue(WallShelfBlock.FACING)) {
            case NORTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(180.f));
            case EAST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
            case SOUTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
            case WEST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
        }

        pPoseStack.translate(0f, 0f, -0.9f);

        // Render front rows of 4
        renderRowOf4Slots(itemRenderer, pPoseStack, items, pBlockEntity, pBufferSource, 0);
        pPoseStack.translate(0f, -1.55f, 0f);
        renderRowOf4Slots(itemRenderer, pPoseStack, items, pBlockEntity, pBufferSource, 8);
        pPoseStack.translate(0f, -1.55f, 0f);
        renderRowOf4Slots(itemRenderer, pPoseStack, items, pBlockEntity, pBufferSource, 16);

        pPoseStack.translate(0f, 3.10f, -1.1f);

        // Render Back rows of 4
        renderRowOf4Slots(itemRenderer, pPoseStack, items, pBlockEntity, pBufferSource, 4);
        pPoseStack.translate(0f, -1.55f, 0f);
        renderRowOf4Slots(itemRenderer, pPoseStack, items, pBlockEntity, pBufferSource, 12);
        pPoseStack.translate(0f, -1.55f, 0f);
        renderRowOf4Slots(itemRenderer, pPoseStack, items, pBlockEntity, pBufferSource, 20);

        pPoseStack.popPose();
    }

    private void renderRowOf4Slots(ItemRenderer itemRenderer, PoseStack pPoseStack, ItemStackHandler items,
                                   WallShelfBlockEntity pBlockEntity, MultiBufferSource pBufferSource, int slotStart) {
        pPoseStack.translate(-1.5f, 0f, 0f);
        for (int i = 0; i < 4; i++) {
            itemRenderer.renderStatic(items.getStackInSlot(i + slotStart), ItemTransforms.TransformType.GUI,
                    getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
                    OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
            pPoseStack.translate(1.0f, 0f, 0f);
        }
        pPoseStack.translate(-2.5f, 0f, 0f);
    }

    private int getLightLevel(Level level, BlockPos blockPos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, blockPos);
        int sLight = level.getBrightness(LightLayer.SKY, blockPos);
        return LightTexture.pack(bLight, sLight);
    }
}
