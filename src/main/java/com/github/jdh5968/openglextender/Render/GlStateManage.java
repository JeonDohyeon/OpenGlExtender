package com.github.jdh5968.openglextender.Render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.opengl.GL11;

public class GlStateManage extends GlStateManager {
    public static final float DEFAULTALPHACUTOFF = 0.1F;
    private static final GlStateManage.AlphaState ALPHA_TEST = new GlStateManage.AlphaState();
    @Deprecated
    public static void _enableAlphaTest() {
        com.github.jdh5968.openglextender.Render.RendererSystem.assertThread(
                RenderSystem::isOnRenderThreadOrInit);
        ALPHA_TEST.mode.enable();
    }

    @Deprecated
    public static void _disableAlphaTest() {
        com.github.jdh5968.openglextender.Render.RendererSystem.assertThread(
                RenderSystem::isOnRenderThreadOrInit);
        ALPHA_TEST.mode.disable();
    }

    @Deprecated
    public static void _alphaFunc(int p_227639_0_, float p_227639_1_) {
        com.github.jdh5968.openglextender.Render.RendererSystem.assertThread(
                RenderSystem::isOnRenderThreadOrInit);

        if (p_227639_0_ != ALPHA_TEST.func || p_227639_1_ != ALPHA_TEST.reference) {
            ALPHA_TEST.func = p_227639_0_;
            ALPHA_TEST.reference = p_227639_1_;
            GL11.glAlphaFunc(p_227639_0_,p_227639_1_);
        }
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    static class AlphaState {
        public final GlStateManage.BooleanState mode = new GlStateManage.BooleanState(3008);
        public int func = 519;
        public float reference = -1.0F;

        private AlphaState(){}
    }

    @OnlyIn(Dist.CLIENT)
    static class BooleanState {
        private final int state;
        private boolean enabled;

        public BooleanState(int p_i50871_1_){this.state = p_i50871_1_;}

        public void disable(){this.setEnabled(false);}

        public void enable(){this.setEnabled(true);}

        public void setEnabled(boolean p_179199_1_) {
            com.github.jdh5968.openglextender.Render.RendererSystem.assertThread(
                    RenderSystem::isOnRenderThreadOrInit);
            if (p_179199_1_ != this.enabled) {
                this.enabled = p_179199_1_;
                if (p_179199_1_) GL11.glEnable(this.state);
                else GL11.glDisable(this.state);
            }
        }
    }
}
