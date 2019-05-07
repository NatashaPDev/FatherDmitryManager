package com.natalia.fatherdmitrymanager.data;

import android.provider.BaseColumns;

public class VariantsContracts {

    public static final class VariantsEntry implements BaseColumns {

        public static final String TABLE_VARIANTS = "variants";

        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_SOFA_POINTS = "sofa_points";
        public static final String COLUMN_GIRL_POINTS = "girl_points";
        public static final String COLUMN_WORK_POINTS = "work_points";
    }
}
