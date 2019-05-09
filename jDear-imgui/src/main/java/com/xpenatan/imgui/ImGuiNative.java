package com.xpenatan.imgui;

import java.nio.Buffer;

public class ImGuiNative {

	/*JNI
		#include <src/imgui.h>
		#include <iostream>

		jfieldID totalVtxCountID;
		jfieldID totalIdxCountID;
		jfieldID totalCmdCountID;
		jfieldID CmdListsCountID;
		jfieldID displayPosXID;
		jfieldID displayPosYID;
		jfieldID displaySizeXID;
		jfieldID displaySizeYID;
		jfieldID framebufferScaleXID;
		jfieldID framebufferScaleYID;
	*/

	public static native void CreateContext() /*-{ }-*/; /*
		ImGui::CreateContext();
		ImGui::GetIO().IniFilename = NULL;

		jclass jDrawDataClass = env->FindClass("com/xpenatan/imgui/DrawData");

		// Prepare IDs
		totalVtxCountID = env->GetFieldID(jDrawDataClass, "totalVtxCount", "I");
		totalIdxCountID = env->GetFieldID(jDrawDataClass, "totalIdxCount", "I");
		totalCmdCountID = env->GetFieldID(jDrawDataClass, "totalCmdCount", "I");
		CmdListsCountID = env->GetFieldID(jDrawDataClass, "cmdListsCount", "I");

		displayPosXID = env->GetFieldID(jDrawDataClass, "displayPosX", "F");
		displayPosYID = env->GetFieldID(jDrawDataClass, "displayPosY", "F");

		displaySizeXID = env->GetFieldID(jDrawDataClass, "displaySizeX", "F");
		displaySizeYID = env->GetFieldID(jDrawDataClass, "displaySizeY", "F");

		framebufferScaleXID = env->GetFieldID(jDrawDataClass, "framebufferScaleX", "F");
		framebufferScaleYID = env->GetFieldID(jDrawDataClass, "framebufferScaleY", "F");
	*/

	public static native void Begin(String title) /*-{ }-*/; /*
		ImGui::Begin(title);
	*/

	public static native void End() /*-{ }-*/; /*
		ImGui::End();
	*/

	public static native void UpdateDisplayAndInputAndFrame(float deltaTime, float w, float h, float display_w, float display_h,
			float mouseX, float mouseY, boolean mouseDown0, boolean mouseDown1, boolean mouseDown2, boolean mouseDown3, boolean mouseDown4, boolean mouseDown5) /*-{ }-*/; /*
		ImGuiIO& io = ImGui::GetIO();

		io.DisplaySize = ImVec2(w, h);
		if (w > 0 && h > 0)
			io.DisplayFramebufferScale = ImVec2((float)display_w / w, (float)display_h / h);
		io.DeltaTime = deltaTime;

		bool m0 = mouseDown0;
		bool m1 = mouseDown1;
		bool m2 = mouseDown2;
		bool m3 = mouseDown3;
		bool m4 = mouseDown4;
		bool m5 = mouseDown5;

		io.MouseDown[0] = m0;
		io.MouseDown[1] = m1;
		io.MouseDown[2] = m2;
		io.MouseDown[3] = m3;
		io.MouseDown[4] = m4;
		io.MouseDown[5] = m5;

		if (io.WantSetMousePos) {
		}
		else {
			io.MousePos = ImVec2(mouseX, mouseY);
		}

		ImGui::NewFrame();
	*/

	public static native void Text(String text) /*-{ }-*/; /*
		ImGui::Text(text);
	*/

	public static native void Render() /*-{ }-*/; /*
		ImGui::Render();
	*/

	public static native void SetNextWindowSize(int width, int height) /*-{ }-*/; /*
		ImGui::SetNextWindowSize(ImVec2(width, height));
	*/

	public static native void SetNextWindowPos(int x, int y) /*-{ }-*/; /*
		ImGui::SetNextWindowPos(ImVec2(x, y));
	 */

	public static native void ShowDemoWindow(boolean open) /*-{ }-*/; /*
		bool toOpen = open;
		ImGui::ShowDemoWindow(&toOpen);
	 */

	public static native void GetTexDataAsRGBA32(TexDataRGBA32 jTexData, Buffer pixelBuffer) /*-{ }-*/; /*
		jclass jTexDataClass = env->GetObjectClass(jTexData);
			if(jTexDataClass == NULL)
				return;

		jfieldID widthID = env->GetFieldID(jTexDataClass, "width", "I");
		jfieldID heightID = env->GetFieldID(jTexDataClass, "height", "I");

		unsigned char* pixels;
		int width, height;

		ImGuiIO& io = ImGui::GetIO();
		io.Fonts->GetTexDataAsRGBA32(&pixels, &width, &height);

		env->SetIntField (jTexData, widthID, width);
		env->SetIntField (jTexData, heightID, height);

		memcpy(pixelBuffer, pixels, width * height * 4);
	*/

	public static native void SetFontTexID(int id) /*-{ }-*/; /*
		ImGuiIO& io = ImGui::GetIO();
		io.Fonts->TexID = (ImTextureID)id;
	*/

	public static native void GetDrawData(DrawData jDrawData, Buffer indexBuffer, Buffer vertexBuffer, Buffer cmdBuffer) /*-{ }-*/; /*
		ImDrawData * drawData = ImGui::GetDrawData();

		if(drawData != NULL) {
			int cmdListsCount = drawData->CmdListsCount;

			// Set values
			env->SetIntField (jDrawData, totalVtxCountID, drawData->TotalVtxCount);
			env->SetIntField (jDrawData, totalIdxCountID, drawData->TotalIdxCount);
			env->SetIntField (jDrawData, CmdListsCountID, cmdListsCount);

			env->SetFloatField (jDrawData, displayPosXID, drawData->DisplayPos.x);
			env->SetFloatField (jDrawData, displayPosYID, drawData->DisplayPos.y);

			env->SetFloatField (jDrawData, displaySizeXID, drawData->DisplaySize.x);
			env->SetFloatField (jDrawData, displaySizeYID, drawData->DisplaySize.y);

			env->SetFloatField (jDrawData, framebufferScaleXID, drawData->FramebufferScale.x);
			env->SetFloatField (jDrawData, framebufferScaleYID, drawData->FramebufferScale.y);

			ImDrawList** drawLists = drawData->CmdLists;

			int verticeOffset = 0;
			int indicesOffset = 0;
			int cmdOffset = 0;
			int cmdCount = 0;

			for(int i = 0; i < cmdListsCount; i++) {
				ImDrawList & drawList = *drawLists[i];
				ImVector<ImDrawCmd> & imDrawCmdList = drawList.CmdBuffer;
				ImVector<ImDrawIdx> & idxBuffer = drawList.IdxBuffer;
				ImVector<ImDrawVert> & vtxBuffer = drawList.VtxBuffer;

				int verticeSize = sizeof(ImDrawVert);
				int indicesSize = sizeof(ImDrawIdx);

				float * vertexArraySource = (float *)vtxBuffer.Data;
				short * indexArraySource = (short *)idxBuffer.Data;
				float * vertexArrayDest = (float *)vertexBuffer;
				short * indexArrayDest = (short *)indexBuffer;

				int colorSize = 1;

				int verticeItemSize = (4 + colorSize);

				vertexArrayDest[verticeOffset++] = vtxBuffer.Size;
				// copy vertices to Destination buffer
				for(int j = 0; j < vtxBuffer.Size; j++) {
					ImDrawVert v = vtxBuffer[j];
					float posX = v.pos.x;
					float posY = v.pos.y;
					float uvX = v.uv.x;
					float uvY = v.uv.y;

					int byteIndex = (j * verticeItemSize) + verticeOffset;

					float color = 0;
					memcpy(&color, &v.col, 4); // move unsigned int color to float

					vertexArrayDest[byteIndex + 0] = posX;
					vertexArrayDest[byteIndex + 1] = posY;
					vertexArrayDest[byteIndex + 2] = uvX;
					vertexArrayDest[byteIndex + 3] = uvY;
					vertexArrayDest[byteIndex + 4] = color;
				}
				verticeOffset += vtxBuffer.Size * verticeItemSize;

				// copy index to destination buffer
				indexArrayDest[indicesOffset++] = idxBuffer.Size;
				for(int j = 0; j < idxBuffer.Size; j++) {

					indexArrayDest[j + indicesOffset] = idxBuffer[j];
				}
				indicesOffset += idxBuffer.Size;

				float * cmdArrayDest = (float *)cmdBuffer;

				cmdArrayDest[cmdOffset++] = imDrawCmdList.Size;
				int bytesOffset = 0;
				int imDrawCmdSize = 1 + 4 + 1;
				for (int cmd_i = 0; cmd_i < imDrawCmdList.Size; cmd_i++) {
					const ImDrawCmd * pcmd = &imDrawCmdList[cmd_i];

					float  textureID = (float)(intptr_t)pcmd->TextureId;
					float tempArray [6] = {
						pcmd->ElemCount,
						pcmd->ClipRect.x,
						pcmd->ClipRect.y,
						pcmd->ClipRect.z,
						pcmd->ClipRect.w,
						textureID
					};

					memcpy((cmdArrayDest + (cmd_i * imDrawCmdSize) + cmdOffset), tempArray, imDrawCmdSize * 4);
					bytesOffset = bytesOffset + imDrawCmdSize;
				}
				cmdOffset += imDrawCmdList.Size * imDrawCmdSize;
				cmdCount +=  imDrawCmdList.Size;
			}

			env->SetIntField (jDrawData, totalCmdCountID, cmdCount);
		}
	*/


	// Parameters stacks (current window)

	public static native void PushItemWidth(float item_width) /*-{ }-*/; /*
		ImGui::PushItemWidth(item_width);
	*/

	public static native void PopItemWidth() /*-{ }-*/; /*
		ImGui::PopItemWidth();
	*/

	public static native void SetNextItemWidth(float item_width) /*-{ }-*/; /*
		ImGui::SetNextItemWidth(item_width);
	*/

	public static native float CalcItemWidth() /*-{ }-*/; /*
		return ImGui::CalcItemWidth();
	*/

	public static native void PushTextWrapPos(float wrap_local_pos_x) /*-{ }-*/; /*
		ImGui::PushTextWrapPos(wrap_local_pos_x);
	*/

	public static native void PushTextWrapPos() /*-{ }-*/; /*
		ImGui::PushTextWrapPos();
	*/

	public static native void PopTextWrapPos() /*-{ }-*/; /*
		ImGui::PopTextWrapPos();
	*/

	public static native void PushAllowKeyboardFocus(boolean allow_keyboard_focus) /*-{ }-*/; /*
		ImGui::PushAllowKeyboardFocus(allow_keyboard_focus);
	*/

	public static native void PopAllowKeyboardFocus() /*-{ }-*/; /*
		ImGui::PopAllowKeyboardFocus();
	*/

	public static native void PushButtonRepeat(boolean repeat) /*-{ }-*/; /*
		ImGui::PushButtonRepeat(repeat);
	*/

	public static native void PopButtonRepeat() /*-{ }-*/; /*
		ImGui::PopButtonRepeat();
	*/

	// Cursor / Layout
	// - By "cursor" we mean the current output position.
	// - The typical widget behavior is to output themselves at the current cursor position, then move the cursor one line down.

	public static native void Separator() /*-{ }-*/; /*
		ImGui::Separator();
	*/

	public static native void SameLine() /*-{ }-*/; /*
		ImGui::SameLine();
	*/

	public static native void SameLine(float offsetFromStartX, float spacing) /*-{ }-*/; /*
		ImGui::SameLine(offsetFromStartX, spacing);
	*/

	public static native void NewLine() /*-{ }-*/; /*
		ImGui::NewLine();
	*/

	public static native void Spacing() /*-{ }-*/; /*
		ImGui::Spacing();
	*/

	public static native void Dummy(float width, float height) /*-{ }-*/; /*
		ImGui::Dummy(ImVec2(width, height));
	*/

	public static native void Indent() /*-{ }-*/; /*
		ImGui::Indent();
	*/

	public static native void Indent(float indentW) /*-{ }-*/; /*
		ImGui::Indent(indentW);
	*/

	public static native void Unindent() /*-{ }-*/; /*
		ImGui::Unindent();
	*/

	public static native void Unindent(float indentW) /*-{ }-*/; /*
		ImGui::Unindent(indentW);
	*/

	public static native void BeginGroup() /*-{ }-*/; /*
		ImGui::BeginGroup();
	*/

	public static native void EndGroup() /*-{ }-*/; /*
		ImGui::EndGroup();
	*/

	public static native void GetCursorPos(float [] vec2) /*-{ }-*/; /*
		ImVec2 vec = ImGui::GetCursorPos();
		vec2[0] = vec.x;
		vec2[1] = vec.y;
	*/

	public static native float GetCursorPosX() /*-{ }-*/; /*
		return ImGui::GetCursorPosX();
	*/

	public static native float GetCursorPosY() /*-{ }-*/; /*
		return ImGui::GetCursorPosY();
	*/

	public static native void SetCursorPos(float x, float y) /*-{ }-*/; /*
		ImGui::SetCursorPos(ImVec2(x, y));
	*/

	public static native void SetCursorPosX(float x) /*-{ }-*/; /*
		ImGui::SetCursorPosX(x);
	*/

	public static native void SetCursorPosY(float y) /*-{ }-*/; /*
		ImGui::SetCursorPosY(y);
	*/

	public static native void GetCursorStartPos(float [] vec2) /*-{ }-*/; /*
		ImVec2 vec = ImGui::GetCursorStartPos();
		vec2[0] = vec.x;
		vec2[1] = vec.y;
	*/

	public static native void GetCursorScreenPos(float [] vec2) /*-{ }-*/; /*
		ImVec2 vec = ImGui::GetCursorScreenPos();
		vec2[0] = vec.x;
		vec2[1] = vec.y;
	*/

	public static native void SetCursorScreenPos(float x, float y) /*-{ }-*/; /*
		ImGui::SetCursorScreenPos(ImVec2(x, y));
	*/

	public static native void AlignTextToFramePadding() /*-{ }-*/; /*
		ImGui::AlignTextToFramePadding();
	*/

	public static native float GetTextLineHeight() /*-{ }-*/; /*
		return ImGui::GetTextLineHeight();
	*/

	public static native float GetTextLineHeightWithSpacing() /*-{ }-*/; /*
		return ImGui::GetTextLineHeightWithSpacing();
	*/

	public static native float GetFrameHeight() /*-{ }-*/; /*
		return ImGui::GetFrameHeight();
	*/

	public static native float GetFrameHeightWithSpacing() /*-{ }-*/; /*
		return ImGui::GetFrameHeightWithSpacing();
	*/

	// Widgets: Main
	// - Most widgets return true when the value has been changed or when pressed/selected

	public static native boolean Button(String label) /*-{ }-*/; /*
		return ImGui::Button(label);
	*/

	public static native boolean Button(String label, float width, float height) /*-{ }-*/; /*
		return ImGui::Button(label, ImVec2(width, height));
	*/

	public static native boolean SmallButton(String label) /*-{ }-*/; /*
		return ImGui::SmallButton(label);
	*/

	public static native boolean InvisibleButton(String strId, float width, float height) /*-{ }-*/; /*
		return ImGui::InvisibleButton(strId, ImVec2(width, height));
	*/

	public static native boolean ArrowButton(String strId, int dir) /*-{ }-*/; /*
		return ImGui::ArrowButton(strId, dir);
	*/

	public static native boolean Checkbox(String label, boolean [] data) /*-{ }-*/; /*
		return ImGui::Checkbox(label, &data[0]);
	*/

	//TODO check if its working
	public static native boolean CheckboxFlags(String label, long [] data, int flagsValue) /*-{ }-*/; /*
		return ImGui::CheckboxFlags(label, (unsigned int*)&data[0], flagsValue);
	*/

	public static native boolean RadioButton(String label, boolean active) /*-{ }-*/; /*
		return ImGui::RadioButton(label, active);
	*/

	public static native boolean RadioButton(String label, int [] data, int v_button) /*-{ }-*/; /*
		return ImGui::RadioButton(label, &data[0], v_button);
	*/

	//TODO impl
	public static native void ProgressBar(float fraction) /*-{ }-*/; /*
	*/

	public static native void Bullet() /*-{ }-*/; /*
		ImGui::Bullet();
	*/

	private ImGuiNative() {}

}
