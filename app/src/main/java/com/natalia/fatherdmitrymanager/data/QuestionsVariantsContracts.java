package com.natalia.fatherdmitrymanager.data;

import android.provider.BaseColumns;

public class QuestionsVariantsContracts {

    public static final class QuestionsVariantsEntry implements BaseColumns {

        public static final String TABLE_NAME = "questions_variants";

        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_VARIANT = "variant";
    }
}
