package com.application.presonalcolud.application.remote.models.response;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResponseModel implements Parcelable {

    @SerializedName("names_with_time")
    private List<List<String>> namesWithTime;

    protected ResponseModel(Parcel in) {
    }

    public static final Creator<ResponseModel> CREATOR = new Creator<ResponseModel>() {
        @Override
        public ResponseModel createFromParcel(Parcel in) {
            return new ResponseModel(in);
        }

        @Override
        public ResponseModel[] newArray(int size) {
            return new ResponseModel[size];
        }
    };

    public List<List<String>> getNamesWithTime() {
        return namesWithTime;
    }

    public void setNamesWithTime(List<List<String>> namesWithTime) {
        this.namesWithTime = namesWithTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NamesWithTimeResponse{\n");
        for (List<String> entry : namesWithTime) {
            sb.append("\t[");
            for (String item : entry) {
                sb.append(item).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()); // Remove the last ", "
            sb.append("]\n");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
    }
}