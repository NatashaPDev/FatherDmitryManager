package com.natalia.fatherdmitrymanager.data;

import android.provider.BaseColumns;

public class QuestionsContracts {

    public static final class QuestionsEntry implements BaseColumns {

        public static final String TABLE_NAME = "questions";

        public static final String COLUMN_DESCRIPTION = "description";
    }
}
