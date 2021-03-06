package com.github.xpenatan.imgui.jnicode;

import com.github.xpenatan.imgui.ImRect;
import com.github.xpenatan.imgui.custom.ImGuiCollapseLayoutOptions;
import com.github.xpenatan.imgui.custom.ImGuiLayout;

public class ImGuiLayoutNative {

	public static ImGuiCollapseLayoutOptions defaultOptions = new ImGuiCollapseLayoutOptions();

	/*JNI
		#include <src/imgui_layout.h>

		jfieldID paddingLeftID;
		jfieldID paddingRightID;
		jfieldID paddingTopID;
		jfieldID paddingBottomID;
		jfieldID arrowColorID;
		jfieldID arrowBackgroundHoveredColorID;
		jfieldID arrowBackgroundClickedColorID;
		jfieldID frameColorID;
		jfieldID borderColorID;
		jfieldID borderRoundID;
		jfieldID roundingCornersID;

		jfieldID positionXID;
		jfieldID positionYID;
		jfieldID sizeXID;
		jfieldID sizeYID;
		jfieldID contentSizeXID;
		jfieldID contentSizeYID;
		jfieldID layoutPaddingLeftID;
		jfieldID layoutPaddingRightID;
		jfieldID layoutPaddingTopID;
		jfieldID layoutPaddingBottomID;

		jfieldID minXID;
		jfieldID minYID;
		jfieldID maxXID;
		jfieldID maxYID;
	*/

	public static native void init() /*-{ }-*/; /*
		jclass jLayoutOptionsClass = env->FindClass("com/github/xpenatan/imgui/custom/ImGuiCollapseLayoutOptions");
		jclass jLayoutClass = env->FindClass("com/github/xpenatan/imgui/custom/ImGuiLayout");
		jclass jImRectClass = env->FindClass("com/github/xpenatan/imgui/ImRect");
		paddingLeftID = env->GetFieldID(jLayoutOptionsClass, "paddingLeft", "F");
		paddingRightID = env->GetFieldID(jLayoutOptionsClass, "paddingRight", "F");
		paddingTopID = env->GetFieldID(jLayoutOptionsClass, "paddingTop", "F");
		paddingBottomID = env->GetFieldID(jLayoutOptionsClass, "paddingBottom", "F");
		arrowColorID = env->GetFieldID(jLayoutOptionsClass, "arrowColor", "I");
		arrowBackgroundHoveredColorID = env->GetFieldID(jLayoutOptionsClass, "arrowBackgroundHoveredColor", "I");
		arrowBackgroundClickedColorID = env->GetFieldID(jLayoutOptionsClass, "arrowBackgroundClickedColor", "I");
		frameColorID = env->GetFieldID(jLayoutOptionsClass, "frameColor", "I");
		borderColorID = env->GetFieldID(jLayoutOptionsClass, "borderColor", "I");
		borderRoundID = env->GetFieldID(jLayoutOptionsClass, "borderRound", "I");
		roundingCornersID = env->GetFieldID(jLayoutOptionsClass, "roundingCorners", "I");

		positionXID = env->GetFieldID(jLayoutClass, "positionX", "F");
		positionYID = env->GetFieldID(jLayoutClass, "positionY", "F");
		sizeXID = env->GetFieldID(jLayoutClass, "sizeX", "F");
		sizeYID = env->GetFieldID(jLayoutClass, "sizeY", "F");
		contentSizeXID = env->GetFieldID(jLayoutClass, "contentSizeX", "F");
		contentSizeYID = env->GetFieldID(jLayoutClass, "contentSizeY", "F");
		layoutPaddingLeftID = env->GetFieldID(jLayoutClass, "paddingLeft", "F");
		layoutPaddingRightID = env->GetFieldID(jLayoutClass, "paddingRight", "F");
		layoutPaddingTopID = env->GetFieldID(jLayoutClass, "paddingTop", "F");
		layoutPaddingBottomID = env->GetFieldID(jLayoutClass, "paddingBottom", "F");

		minXID = env->GetFieldID(jImRectClass, "minX", "F");
		minYID = env->GetFieldID(jImRectClass, "minY", "F");

		maxXID = env->GetFieldID(jImRectClass, "maxX", "F");
		maxYID = env->GetFieldID(jImRectClass, "maxY", "F");
	*/

	public static native void DrawBoundingBox(float x1, float y1, float x2, float y2, int r, int g, int b, int a) /*-{ }-*/; /*
		ImGuiExt::DrawBoundingBox(x1, y1, x2, y2, r, g, b, a);
	*/

	public static native void ShowLayoutDebug() /*-{ }-*/; /*
		ImGuiExt::ShowLayoutDebug();
	*/

	public static native void ShowLayoutDebugClipping() /*-{ }-*/; /*
		ImGuiExt::ShowLayoutDebugClipping();
	*/

	public static native void BeginLayout(String id, float sizeX, float sizeY); /*-{ }-*/; /*
		ImGuiExt::BeginLayout(id, sizeX, sizeY);
	*/

	public static native void BeginLayout(String id, float sizeX, float sizeY, float paddingLeft, float paddingRight, float paddingTop, float paddingBottom); /*-{ }-*/; /*
		ImGuiLayoutOptions options;
		options.paddingLeft = paddingLeft;
		options.paddingRight = paddingRight;
		options.paddingTop = paddingTop;
		options.paddingBottom = paddingBottom;
		ImGuiExt::BeginLayout(id, sizeX, sizeY);
	*/

	public static native void EndLayout(); /*-{ }-*/; /*
		ImGuiExt::EndLayout();
	*/

	public static native void GetCurrentLayout(ImGuiLayout jLayout); /*-{ }-*/; /*
		ImGuiLayout* curLayout = ImGuiExt::GetCurrentLayout();
		env->SetFloatField (jLayout, positionXID, curLayout->position.x);
		env->SetFloatField (jLayout, positionYID, curLayout->position.y);
		env->SetFloatField (jLayout, sizeXID, curLayout->size.x);
		env->SetFloatField (jLayout, sizeYID, curLayout->size.y);
		env->SetFloatField (jLayout, contentSizeXID, curLayout->contentSize.x);
		env->SetFloatField (jLayout, contentSizeYID, curLayout->contentSize.y);
		env->SetFloatField (jLayout, layoutPaddingLeftID, curLayout->paddingLeft);
		env->SetFloatField (jLayout, layoutPaddingRightID, curLayout->paddingRight);
		env->SetFloatField (jLayout, layoutPaddingTopID, curLayout->paddingTop);
		env->SetFloatField (jLayout, layoutPaddingBottomID, curLayout->paddingBottom);
	*/


	/*JNI
		void configOptions(JNIEnv* env, ImGuiCollapseLayoutOptions & options, jobject jOptions) {
			options.paddingLeft = env->GetFloatField (jOptions, paddingLeftID);
			options.paddingRight = env->GetFloatField (jOptions, paddingRightID);
			options.paddingTop = env->GetFloatField (jOptions, paddingTopID);
			options.paddingBottom = env->GetFloatField (jOptions, paddingBottomID);
			options.arrowColor = env->GetIntField (jOptions, arrowColorID);
			options.arrowBackgroundHoveredColor = env->GetIntField (jOptions, arrowBackgroundHoveredColorID);
			options.arrowBackgroundClickedColor = env->GetIntField (jOptions, arrowBackgroundClickedColorID);
			options.frameColor = env->GetIntField (jOptions, frameColorID);
			options.borderColor = env->GetIntField (jOptions, borderColorID);
			options.borderRound = env->GetIntField (jOptions, borderRoundID);
			options.roundingCorners = env->GetIntField (jOptions, roundingCornersID);
		}
	*/

	public static native boolean BeginCollapseLayoutEx(String id, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
		ImGuiCollapseLayoutOptions options;
		configOptions(env, options, jOptions);
		return ImGuiExt::BeginCollapseLayoutEx(id, title, sizeX, sizeY, options);
	*/

	public static native boolean BeginCollapseLayoutEx(int id, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
		ImGuiCollapseLayoutOptions options;
		configOptions(env, options, jOptions);
		return ImGuiExt::BeginCollapseLayoutEx(id, title, sizeX, sizeY, options);
	*/

	public static native void BeginCollapseLayoutEx(String id, boolean [] isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
		ImGuiCollapseLayoutOptions options;
		configOptions(env, options, jOptions);
		ImGuiExt::BeginCollapseLayoutEx(id, &isOpen[0], title, sizeX, sizeY, options);
	*/

	public static native boolean BeginCollapseLayout(String id, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
		ImGuiCollapseLayoutOptions options;
		configOptions(env, options, jOptions);
		return ImGuiExt::BeginCollapseLayout(id, title, sizeX, sizeY, options);
	*/

	public static native void BeginCollapseLayout(String id, boolean [] isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
		ImGuiCollapseLayoutOptions options;
		configOptions(env, options, jOptions);
		ImGuiExt::BeginCollapseLayout(id, &isOpen[0], title, sizeX, sizeY, options);
	*/

	public static native void EndCollapseFrameLayout(); /*-{ }-*/; /*
		ImGuiExt::EndCollapseFrameLayout();
	*/

	public static native void EndCollapseLayout(); /*-{ }-*/; /*
		ImGuiExt::EndCollapseLayout();
	*/

	public static native void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY) /*-{ }-*/; /*
		ImGuiExt::BeginAlign(id, sizeX, sizeY, alignX, alignY);
	*/

	public static native void BeginAlign(byte[] id, float sizeX, float sizeY, float alignX, float alignY) /*-{ }-*/; /*
		ImGuiExt::BeginAlign(id, sizeX, sizeY, alignX, alignY);
	*/

	public static native void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY, float offsetX, float offsetY) /*-{ }-*/; /*
		ImGuiExt::BeginAlign(id, sizeX, sizeY, alignX, alignY, offsetX, offsetY);
	*/

	public static native void BeginAlign(byte[] id, float sizeX, float sizeY, float alignX, float alignY, float offsetX, float offsetY) /*-{ }-*/; /*
		ImGuiExt::BeginAlign(id, sizeX, sizeY, alignX, alignY, offsetX, offsetY);
	*/

	public static native void EndAlign() /*-{ }-*/; /*
		ImGuiExt::EndAlign();
	*/

	public static native void AlignLayout(float alignX, float alignY) /*-{ }-*/; /*
		ImGuiExt::AlignLayout(alignX, alignY);
	*/

	public static native void AlignLayout(float alignX, float alignY, float offsetX, float offsetY) /*-{ }-*/; /*
		ImGuiExt::AlignLayout(alignX, alignY, offsetX, offsetY);
	*/

	public static native void BeginBoundingBox() /*-{ }-*/; /*
		ImGuiExt::BeginBoundingBox();
	*/

	public static native void EndBoundingBox(ImRect jData) /*-{ }-*/; /*
		ImRect boundingBox = ImGuiExt::EndBoundingBox();
		env->SetFloatField (jData, minXID, boundingBox.Min.x);
		env->SetFloatField (jData, minYID, boundingBox.Min.y);
		env->SetFloatField (jData, maxXID, boundingBox.Max.x);
		env->SetFloatField (jData, maxYID, boundingBox.Max.y);
	*/

}
