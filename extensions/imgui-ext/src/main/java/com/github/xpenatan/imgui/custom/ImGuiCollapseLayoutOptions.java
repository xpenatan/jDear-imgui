package com.github.xpenatan.imgui.custom;

import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.enums.ImDrawCornerFlags;

public class ImGuiCollapseLayoutOptions {
	public float paddingLeft = 2;
	public float paddingRight = 2;
	public float paddingTop = 2;
	public float paddingBottom = 2;
	public int arrowColor = ImGui.ColorToIntBits(0xFF, 0xFF, 0xFF, 0xFF);
	public int arrowBackgroundHoveredColor = ImGui.ColorToIntBits(0x77, 0x77, 0x77, 0xFF);
	public int arrowBackgroundClickedColor = ImGui.ColorToIntBits(0x55, 0x55, 0x55, 0xFF);
	public int frameColor = ImGui.ColorToIntBits(0x24, 0x24, 0x24, 0xFF);
	public int borderColor = ImGui.ColorToIntBits(0x40, 0x40, 0x49, 0xFF);
	public int borderRound = 4;
	public int roundingCorners = ImDrawCornerFlags.TopLeft.or(ImDrawCornerFlags.TopRight).getValue();
}
