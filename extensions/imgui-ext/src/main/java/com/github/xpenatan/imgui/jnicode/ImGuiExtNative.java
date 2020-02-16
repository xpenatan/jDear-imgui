package com.github.xpenatan.imgui.jnicode;

import com.github.xpenatan.imgui.custom.EditTextFloatData;
import com.github.xpenatan.imgui.custom.EditTextIntData;

public class ImGuiExtNative {

	/*JNI
		#include <src/imgui_ext.h>



		jfieldID leftLabelID;
		jfieldID leftLabelColorID;
		jfieldID leftLabelDragColorID;
		jfieldID tooltipID;
		jfieldID tooltipDelayID;
		jfieldID v_speedID;
		jfieldID powerID;
		jfieldID formatID;

		jfieldID valueFID;
		jfieldID v_minFID;
		jfieldID v_maxFID;

		jfieldID valueIID;
		jfieldID v_minIID;
		jfieldID v_maxIID;
	*/

	public static native void init() /*-{ }-*/; /*
		jclass jEditTextDataClass = env->FindClass("com/github/xpenatan/imgui/custom/EditTextData");
		jclass jEditTextFloatDataClass = env->FindClass("com/github/xpenatan/imgui/custom/EditTextFloatData");
		jclass jEditTextIntDataClass = env->FindClass("com/github/xpenatan/imgui/custom/EditTextIntData");

		leftLabelID = env->GetFieldID(jEditTextDataClass, "leftLabel", "Ljava/lang/String;");
		leftLabelColorID = env->GetFieldID(jEditTextDataClass, "leftLabelColor", "I");
		leftLabelDragColorID = env->GetFieldID(jEditTextDataClass, "leftLabelDragColor", "I");
		tooltipID = env->GetFieldID(jEditTextDataClass, "tooltip", "Ljava/lang/String;");
		tooltipDelayID = env->GetFieldID(jEditTextDataClass, "tooltipDelay", "F");
		v_speedID = env->GetFieldID(jEditTextDataClass, "v_speed", "F");
		powerID = env->GetFieldID(jEditTextDataClass, "power", "F");
		formatID = env->GetFieldID(jEditTextDataClass, "format", "Ljava/lang/String;");

		valueFID = env->GetFieldID(jEditTextFloatDataClass, "value", "F");
		v_minFID = env->GetFieldID(jEditTextFloatDataClass, "v_min", "F");
		v_maxFID = env->GetFieldID(jEditTextFloatDataClass, "v_max", "F");

		valueIID = env->GetFieldID(jEditTextIntDataClass, "value", "I");
		v_minIID = env->GetFieldID(jEditTextIntDataClass, "v_min", "I");
		v_maxIID = env->GetFieldID(jEditTextIntDataClass, "v_max", "I");
	*/

	public static native float GetTableContentHeight() /*-{ }-*/; /*
		return ImGuiExt::GetTableContentHeight();
	*/

	public static native void CalculateTableRowHeight() /*-{ }-*/; /*
		ImGuiExt::CalculateTableRowHeight();
	*/

	public static native float GetTableRowHeight() /*-{ }-*/; /*
		return ImGuiExt::GetTableRowHeight();
	*/

	/*JNI

		template<typename TYPE>
		void putEditText(JNIEnv* env, ImGuiDataType data_type, EditTextData<TYPE> * data, jobject jData) {
			if(data == NULL)
				return;
			jstring jleftLabel = (jstring)env->GetObjectField(jData, leftLabelID);
			if(jleftLabel != NULL) {
				const char* leftLabel = env->GetStringUTFChars(jleftLabel, NULL);
				data->leftLabel = (char*)leftLabel;
			}

			jstring jtooltip = (jstring)env->GetObjectField(jData, tooltipID);
			if(jtooltip != NULL) {
				const char* tooltip = env->GetStringUTFChars(jtooltip, NULL);
				data->tooltip = (char*)tooltip;
			}

			int leftLabelColor = env->GetIntField(jData, leftLabelColorID);
			if(leftLabelColor != 0) {
				data->leftLabelColor = leftLabelColor;
			}

			int leftLabelDragColor = env->GetIntField(jData, leftLabelDragColorID);
			if(leftLabelDragColor != 0) {
				data->leftLabelDragColor = leftLabelDragColor;
			}

			float tooltipDelay = env->GetFloatField(jData, tooltipDelayID);
			if(tooltipDelay >=0) {
				data->tooltipDelay = tooltipDelay;
			}

			float v_speed = env->GetFloatField(jData, v_speedID);
			if(v_speed != -1) {
				data->v_speed = v_speed;
			}

			jstring jformat = (jstring)env->GetObjectField(jData, formatID);
			if(jformat != NULL) {
				const char* format = env->GetStringUTFChars(jformat, NULL);
				data->format = (char*)format;
			}

			TYPE v_min;
			TYPE v_max;
			TYPE value;

			if(data_type == ImGuiDataType_Float) {
				v_min = env->GetFloatField(jData, v_minFID);
				v_max = env->GetFloatField(jData, v_maxFID);
				value = env->GetFloatField(jData, valueFID);
			}
			else if(data_type == ImGuiDataType_S32) {
				v_min = env->GetIntField(jData, v_minIID);
				v_max = env->GetIntField(jData, v_maxIID);
				value = env->GetIntField(jData, valueIID);
			}
			data->v_min = v_min;
			data->v_max = v_max;
			data->value = value;
		}

		template<typename TYPE>
		void getEditText(JNIEnv* env, ImGuiDataType data_type, EditTextData<TYPE> * data, jobject jData) {
			if(data == NULL)
				return;
			if(data_type == ImGuiDataType_Float) {
				env->SetFloatField (jData, valueFID, data->value);
			}
			else if(data_type == ImGuiDataType_S32) {
				env->SetIntField (jData, valueIID, data->value);
			}
		}
	*/

	public static native int EditTextF(String id, EditTextFloatData jData01, EditTextFloatData jData02, EditTextFloatData jData03, EditTextFloatData jData04) /*-{ }-*/; /*
		EditTextData<float> localData01;
		EditTextData<float> localData02;
		EditTextData<float> localData03;
		EditTextData<float> localData04;

		EditTextData<float> * data01 = jData01 != NULL ? &localData01 : NULL;
		EditTextData<float> * data02 = jData02 != NULL ? &localData02 : NULL;
		EditTextData<float> * data03 = jData03 != NULL ? &localData03 : NULL;
		EditTextData<float> * data04 = jData04 != NULL ? &localData04 : NULL;

		putEditText<float>(env, ImGuiDataType_Float, data01, jData01);
		putEditText<float>(env, ImGuiDataType_Float, data02, jData02);
		putEditText<float>(env, ImGuiDataType_Float, data03, jData03);
		putEditText<float>(env, ImGuiDataType_Float, data04, jData04);
		int ret = ImGuiExt::EditTextF(id, data01, data02, data03, data04);

		if(ret != -1) {
			if(ret == 0)
				getEditText<float>(env, ImGuiDataType_Float, data01, jData01);
			else if(ret == 1)
				getEditText<float>(env, ImGuiDataType_Float, data02, jData02);
			else if(ret == 2)
				getEditText<float>(env, ImGuiDataType_Float, data03, jData03);
			else if(ret == 3)
				getEditText<float>(env, ImGuiDataType_Float, data04, jData04);
		}
		return ret;
	*/

	public static native int EditTextI(String id, EditTextIntData jData01, EditTextIntData jData02, EditTextIntData jData03, EditTextIntData jData04) /*-{ }-*/; /*
		EditTextData<int> localData01;
		EditTextData<int> localData02;
		EditTextData<int> localData03;
		EditTextData<int> localData04;

		EditTextData<int> * data01 = jData01 != NULL ? &localData01 : NULL;
		EditTextData<int> * data02 = jData02 != NULL ? &localData02 : NULL;
		EditTextData<int> * data03 = jData03 != NULL ? &localData03 : NULL;
		EditTextData<int> * data04 = jData04 != NULL ? &localData04 : NULL;

		putEditText<int>(env, ImGuiDataType_S32, data01, jData01);
		putEditText<int>(env, ImGuiDataType_S32, data02, jData02);
		putEditText<int>(env, ImGuiDataType_S32, data03, jData03);
		putEditText<int>(env, ImGuiDataType_S32, data04, jData04);
		int ret = ImGuiExt::EditTextI(id, data01, data02, data03, data04);

		if(ret != -1) {
			if(ret == 0)
				getEditText<int>(env, ImGuiDataType_S32, data01, jData01);
			else if(ret == 1)
				getEditText<int>(env, ImGuiDataType_S32, data02, jData02);
			else if(ret == 2)
				getEditText<int>(env, ImGuiDataType_S32, data03, jData03);
			else if(ret == 3)
				getEditText<int>(env, ImGuiDataType_S32, data04, jData04);
		}
		return ret;
	 */
}