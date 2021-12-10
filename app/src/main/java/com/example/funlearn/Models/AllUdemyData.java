package com.example.funlearn.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllUdemyData implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("next")
    @Expose
    private String next;

    @SerializedName("previous")
    @Expose
    private String previous;

    @SerializedName("results")
    @Expose
    private ArrayList<CourseInfo> courseInfoArrayList;

    public static final Creator<AllUdemyData> CREATOR = new Creator<AllUdemyData>() {
        @Override
        public AllUdemyData createFromParcel(Parcel in) {
            return new AllUdemyData(in);
        }

        @Override
        public AllUdemyData[] newArray(int size) {
            return new AllUdemyData[size];
        }
    };

    protected AllUdemyData(Parcel in) {
        count = in.readInt();
        next = in.readString();
        previous = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeString(next);
        dest.writeString(previous);
    }
}
