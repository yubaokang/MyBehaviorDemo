package com.example.ybk.mybehaviordemo.utils;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

/**
 * Created by ybk on 2017/6/8.
 */

public class MyBottomSheetDialogFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new MyBottomSheetDialog(getContext(), getTheme());
    }
}
