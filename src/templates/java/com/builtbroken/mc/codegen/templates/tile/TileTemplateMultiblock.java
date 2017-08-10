package com.builtbroken.mc.codegen.templates.tile;

import com.builtbroken.jlib.data.vector.IPos3D;
import com.builtbroken.mc.api.tile.listeners.IBlockListener;
import com.builtbroken.mc.api.tile.listeners.ITileEventListener;
import com.builtbroken.mc.api.tile.multiblock.IMultiTile;
import com.builtbroken.mc.api.tile.multiblock.IMultiTileHost;
import com.builtbroken.mc.api.tile.node.ITileNode;
import com.builtbroken.mc.codegen.processor.TileWrappedTemplate;
import com.builtbroken.mc.framework.logic.wrapper.TileEntityWrapper;
import net.minecraft.entity.player.EntityPlayer;

import java.util.HashMap;
import java.util.List;

/**
 * Template for implementing multiblock support for a wrapper to support a node object
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 4/1/2017.
 */
@TileWrappedTemplate(annotationName = "MultiBlockWrapped")
public class TileTemplateMultiblock extends TileEntityWrapper implements IMultiTileHost
{
    public TileTemplateMultiblock(ITileNode controller)
    {
        super(controller);
    }

    //#StartMethods#

    @Override
    public void onMultiTileAdded(IMultiTile tileMulti)
    {
        if (getTileNode() instanceof IMultiTileHost)
        {
            ((IMultiTileHost) getTileNode()).onMultiTileAdded(tileMulti);
        }
        for (List<ITileEventListener> list : getMultiTileListeners("multiblock"))
        {
            if (list != null && !list.isEmpty())
            {
                for (ITileEventListener listener : list)
                {
                    if (listener instanceof IMultiTileHost)
                    {
                        if (listener instanceof IBlockListener)
                        {
                            ((IBlockListener) listener).inject(world(), xi(), yi(), zi());
                        }
                        if (listener.isValidForTile())
                        {
                            ((IMultiTileHost) listener).onMultiTileAdded(tileMulti);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean onMultiTileBroken(IMultiTile tileMulti, Object source, boolean harvest)
    {
        if (isServer())
        {
            if (getTileNode() instanceof IMultiTileHost)
            {
                return ((IMultiTileHost) getTileNode()).onMultiTileBroken(tileMulti, source, harvest);
            }
            for (List<ITileEventListener> list : getMultiTileListeners("multiblock"))
            {
                if (list != null && !list.isEmpty())
                {
                    boolean b = false;
                    for (ITileEventListener listener : list)
                    {
                        if (listener instanceof IMultiTileHost)
                        {
                            if (listener instanceof IBlockListener)
                            {
                                ((IBlockListener) listener).inject(world(), xi(), yi(), zi());
                            }
                            if (listener.isValidForTile())
                            {
                                if (((IMultiTileHost) listener).onMultiTileBroken(tileMulti, source, harvest))
                                {
                                    b = true;
                                }
                            }
                        }
                    }
                    return b;
                }
            }
        }
        return false;
    }

    @Override
    public void onTileInvalidate(IMultiTile tileMulti)
    {
        if (isServer())
        {
            if (getTileNode() instanceof IMultiTileHost)
            {
                ((IMultiTileHost) getTileNode()).onTileInvalidate(tileMulti);
            }
            for (List<ITileEventListener> list : getMultiTileListeners("multiblock"))
            {
                if (list != null && !list.isEmpty())
                {
                    for (ITileEventListener listener : list)
                    {
                        if (listener instanceof IMultiTileHost)
                        {
                            if (listener instanceof IBlockListener)
                            {
                                ((IBlockListener) listener).inject(world(), xi(), yi(), zi());
                            }
                            if (listener.isValidForTile())
                            {
                                ((IMultiTileHost) listener).onTileInvalidate(tileMulti);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean onMultiTileActivated(IMultiTile tile, EntityPlayer player, int side, float xHit, float yHit, float zHit)
    {
        boolean b = false;
        if (getTileNode() instanceof IMultiTileHost)
        {
            b = ((IMultiTileHost) getTileNode()).onMultiTileActivated(tile, player, side, xHit, yHit, zHit);
        }
        for (List<ITileEventListener> list : getMultiTileListeners("multiblock"))
        {
            if (list != null && !list.isEmpty())
            {
                for (ITileEventListener listener : list)
                {
                    if (listener instanceof IMultiTileHost)
                    {
                        if (listener instanceof IBlockListener)
                        {
                            ((IBlockListener) listener).inject(world(), xi(), yi(), zi());
                        }
                        if (listener.isValidForTile())
                        {
                            if (((IMultiTileHost) listener).onMultiTileActivated(tile, player, side, xHit, yHit, zHit))
                            {
                                b = true;
                            }
                        }
                    }
                }
            }
        }
        return b;
    }

    @Override
    public void onMultiTileClicked(IMultiTile tile, EntityPlayer player)
    {
        if (getTileNode() instanceof IMultiTileHost)
        {
            ((IMultiTileHost) getTileNode()).onMultiTileClicked(tile, player);
        }
        for (List<ITileEventListener> list : getMultiTileListeners("multiblock"))
        {
            if (list != null && !list.isEmpty())
            {
                for (ITileEventListener listener : list)
                {
                    if (listener instanceof IMultiTileHost)
                    {
                        if (listener instanceof IBlockListener)
                        {
                            ((IBlockListener) listener).inject(world(), xi(), yi(), zi());
                        }
                        if (listener.isValidForTile())
                        {
                            ((IMultiTileHost) listener).onMultiTileClicked(tile, player);
                        }
                    }
                }
            }
        }
    }

    @Override
    public HashMap<IPos3D, String> getLayoutOfMultiBlock()
    {
        if (getTileNode() instanceof IMultiTileHost)
        {
            HashMap<IPos3D, String> map = ((IMultiTileHost) getTileNode()).getLayoutOfMultiBlock();
            if (map != null && !map.isEmpty())
            {
                return map;
            }
        }
        for (List<ITileEventListener> list : getMultiTileListeners("multiblock"))
        {
            if (list != null && !list.isEmpty())
            {
                for (ITileEventListener listener : list)
                {
                    if (listener instanceof IMultiTileHost)
                    {
                        if (listener instanceof IBlockListener)
                        {
                            ((IBlockListener) listener).inject(world(), xi(), yi(), zi());
                        }
                        if (listener.isValidForTile())
                        {
                            HashMap<IPos3D, String> map = ((IMultiTileHost) listener).getLayoutOfMultiBlock();
                            if (map != null && !map.isEmpty())
                            {
                                return map;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    //#EndMethods#
}
