package com.natalia.fatherdmitrymanager.data;

import android.provider.BaseColumns;

public class VariantsAssociationsContracts {

    public static final class VariantsAssociatiosEntry implements BaseColumns {

        public static final String TABLE_VARIANTS = "variants_associations";

        public static final String COLUMN_VARIANT_FROM = "variant_from";
        public static final String COLUMN_VARIANT_TO = "variant_to";
    }
}
