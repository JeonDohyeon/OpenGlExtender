package com.github.jdh5968.openglextender.Render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.github.jdh5968.openglextender.Render.GlStateManage;
import com.mojang.math.Matrix4f;

public class RendererSystem extends com.mojang.blaze3d.systems.RenderSystem {
    private static Matrix4f projectionMatrix = new Matrix4f();
    private static Matrix4f savedProjectionMatrix = new Matrix4f();
    private static Matrix4f modelViewMatrix = new Matrix4f();
    private static Matrix4f textureMatrix = new Matrix4f();
    @Deprecated
    public static void enableAlphaTest() {
        assertThread(RenderSystem::isOnGameThread);
        GlStateManage._enableAlphaTest();
    }

    @Deprecated
    public static void disableAlphaTest() {
        assertThread(RenderSystem::isOnGameThread);
        GlStateManage._disableAlphaTest();
    }

    @Deprecated
    public static void alphaFunc(int p_alphaFunc_0_, float p_alphaFunc_1_){
        assertThread(RenderSystem::isOnGameThread);
        GlStateManage._alphaFunc(p_alphaFunc_0_,p_alphaFunc_1_);
    }

    public static void setupDefaultState(int p_69903_, int p_69904_, int p_69905_, int p_69906_) {
        assertInInitPhase();
        GlStateManager._enableTexture();
        GlStateManager._clearDepth(1.0D);
        GlStateManager._enableDepthTest();
        GlStateManager._depthFunc(515);
        // Enable alpha test begin
        GlStateManage._enableAlphaTest();
        GlStateManage._alphaFunc(516, 0.1F);
        // Enable alpha test done
        projectionMatrix.setIdentity();
        savedProjectionMatrix.setIdentity();
        modelViewMatrix.setIdentity();
        textureMatrix.setIdentity();
        GlStateManager._viewport(p_69903_, p_69904_, p_69905_, p_69906_);
    }

    public static void assertThread(java.util.function.Supplier<Boolean> p_assertThread_0_) {
        if(!p_assertThread_0_.get()) throw new IllegalStateException("Rendersystem called from wrong thread");
    }
}
